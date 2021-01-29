package com.molex.app.services;

import com.molex.app.models.Result;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FizzbuzzService {

    public Set<Result> doSend(Long startValue, Long stopValue) {
        Set<Result> result = new HashSet<>();
        try {
            for (Long value = startValue; value <= stopValue; value++) {
                Result obj = new Result();
                obj.setIn(value);
                if ((value % 15) == 0) {
                    obj.setResult("fizzbuzz");// multiple of 5 & 3 || 15?
                } else if ((value % 3) == 0) {
                    obj.setResult("fizz");// multiple of 3?
                } else if ((value % 5) == 0) {
                    obj.setResult("buzz");// multiple of 5?
                } else {
                    obj.setResult(String.valueOf(value)); // Not a multiple of 3 or 5
                }
                result.add(obj);
            }
        } catch (Exception e) {
            return result;
        }
        return result;
    }

    public String convertNumber(Long number) {
        final boolean isFizz = number % 3 == 0;
        final boolean isBuzz = number % 5 == 0;
        if (isFizz && isBuzz) {
            return "fizzbuzz";
        } else if (isFizz) {
            return "fizz";
        } else if (isBuzz) {
            return "buzz";
        } else {
            return String.valueOf(number);
        }
    }
}
