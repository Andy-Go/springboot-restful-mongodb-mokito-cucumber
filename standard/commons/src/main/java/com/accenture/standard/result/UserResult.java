package com.accenture.standard.result;

import com.accenture.common.result.AbstractResult;
import com.accenture.standard.entity.User;

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
