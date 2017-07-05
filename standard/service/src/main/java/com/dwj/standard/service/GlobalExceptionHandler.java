package com.dwj.standard.service;

import com.dwj.common.result.EmptyResult;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoSocketOpenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.dwj.common.result.ResultCode.*;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public EmptyResult defaultErrorHandler(Exception e) {
        logger.error("system error");
        if (e instanceof IllegalArgumentException) {
            logger.error("argument exception", e);
            return EmptyResult.fail(ARGUMENT_EXCEPTION, e.getMessage());
        } else if (e instanceof DuplicateKeyException) {
            logger.error("duplicate key", e);
            return EmptyResult.fail(DUPLICATE_KEY, "system error");
        } else if (e instanceof MongoSocketOpenException) {
            logger.error("mongo socket err", e);
            return EmptyResult.fail(CONNECTOR_ERROR, "system error");
        } else {
            logger.error("system error", e);
            return EmptyResult.fail(SYSTEM_ERROR, "system error");
        }
    }
}
