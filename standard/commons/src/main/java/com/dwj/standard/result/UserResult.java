package com.dwj.standard.result;

import com.dwj.common.result.AbstractResult;
import com.dwj.standard.entity.User;

public class UserResult extends AbstractResult<User> {
    public UserResult() {
    }

    public UserResult(User payload) {
        super(payload);
    }

    public UserResult(int code, String message) {
        super(code, message);
    }
}
