package com.molex.app.Controller;

import com.molex.app.models.Result;
import com.molex.app.services.FizzbuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.LongStream;

@RestController
public class FizzBuzzController {

    @Autowired
    private FizzbuzzService fizzbuzzService;

    @GetMapping(path = "/fizzBuzz/{startValue}-{stopValue}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<?> getResult(@PathVariable Long startValue, @PathVariable Long stopValue) {
        Set<Result> result = new HashSet<>();
        if (startValue >= stopValue) {
           return Flux.fromIterable(result);
        }
        if (stopValue - startValue <= 400000) {
            result = fizzbuzzService.doSend(startValue, stopValue);
            return Flux.fromIterable(result);
        }else{
            return Flux.from(Flux.from(Flux.fromStream(LongStream.rangeClosed(startValue, stopValue).boxed()).parallel().runOn(Schedulers.parallel())
                    .map(aLong -> new Result(aLong, fizzbuzzService.convertNumber(aLong))).sequential()));
        }
    }
}
