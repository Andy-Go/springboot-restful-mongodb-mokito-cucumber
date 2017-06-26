package com.accenture.standard.api.client;

import com.accenture.common.result.EmptyResult;
import com.accenture.common.result.StringResult;

import com.accenture.standard.entity.User;
import com.accenture.standard.result.UserResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import static com.accenture.common.result.ResultCode.SYSTEM_ERROR;

@Component
public class ClientHystrix implements UserClient  {
    private static Logger logger = LoggerFactory.getLogger(ClientHystrix.class);

    public StringResult addUser(@RequestBody User user) {
        logger.info("service fuses to addUser, user:{}", user);
        return StringResult.fail(SYSTEM_ERROR,"system error");
    }

    public EmptyResult deleteUser(@PathVariable(value = "id") String id) {
        logger.info("service fuses to deleteUser, id:{}", id);
        return EmptyResult.fail(SYSTEM_ERROR,"system error");
    }

    public EmptyResult updateUser(@RequestBody User user) {
        logger.info("service fuses to updateUser, user:{}", user);
        return EmptyResult.fail(SYSTEM_ERROR,"system error");
    }

    public UserResult findUser(@PathVariable(value = "id") String id) {
        logger.info("service fuses to updateUser, id:{}", id);
        return new UserResult(SYSTEM_ERROR,"system error");
    }
}
