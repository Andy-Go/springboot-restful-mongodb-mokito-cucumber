package com.accenture.common.result;

public class EmptyResult extends AbstractResult {
    public EmptyResult() {
    }

    public EmptyResult(Object payload) {
        super(payload);
    }

    public EmptyResult(int code, String message) {
        super(code, message);
    }

    public static EmptyResult success() {
        return new EmptyResult();
    }

    public static EmptyResult fail(int code, String message) {
        return new EmptyResult(code, message);
    }
}
