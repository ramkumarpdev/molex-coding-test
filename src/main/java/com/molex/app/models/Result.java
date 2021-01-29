package com.molex.app.models;

public class Result {

    private Long in;
    private String result;

    public Long getIn() {
        return in;
    }

    public void setIn(Long in) {
        this.in = in;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Result(Long in, String result) {
        super();
        this.in = in;
        this.result = result;
    }

    public Result() {
    }
}
