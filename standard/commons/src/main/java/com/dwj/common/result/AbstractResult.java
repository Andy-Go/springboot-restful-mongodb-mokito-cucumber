package com.dwj.common.result;

import com.google.common.base.Strings;

import static com.dwj.common.result.ResultCode.SUCCESS;
import static com.google.common.base.Preconditions.checkArgument;

public abstract class AbstractResult<T> {
    private int code = SUCCESS;
    private String message;
    private T payload;

    public AbstractResult() {
    }

    public AbstractResult(T payload) {
        checkArgument(payload != null, "payload should be not null!");
        this.payload = payload;
    }

    public AbstractResult(int code, String message) {
        checkArgument(code > 0, "code should be greater than 0!");
        checkArgument(!Strings.isNullOrEmpty(message), "message should be not empty!");
        this.code = code;
        this.message = message;
    }

    public AbstractResult(int code, String message, T payload) {
        checkArgument(code > 0, "code should be greater than 0!");
        checkArgument(Strings.isNullOrEmpty(message), "message should be not empty!");
        checkArgument(payload != null, "payload should be not null!");
        this.code = code;
        this.message = message;
        this.payload = payload;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
