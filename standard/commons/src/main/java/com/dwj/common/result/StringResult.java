package com.dwj.common.result;

public class StringResult extends AbstractResult<String> {
    public StringResult() {
    }

    public StringResult(String payload) {
        super(payload);
    }

    public StringResult(int code, String message) {
        super(code, message);
    }

    public static StringResult success(String payload) {
        return new StringResult(payload);
    }

    public static StringResult fail(int code, String message) {
        return new StringResult(code, message);
    }
}
