package com.accenture.common.result;

public class IntegerResult extends AbstractResult<Integer> {

    public IntegerResult() {
    }

    public IntegerResult(Integer payload) {
        super(payload);
    }

    public IntegerResult(int code, String message) {
        super(code, message);
    }


    public static IntegerResult success(Integer payload) {
        return new IntegerResult(payload);
    }

    public static IntegerResult fail(int code, String message) {
        return new IntegerResult(code, message);
    }
}
