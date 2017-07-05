package com.dwj.standard.service.controller;

import com.dwj.common.result.EmptyResult;
import com.dwj.standard.entity.User;
import com.dwj.standard.result.UserResult;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import com.dwj.standard.service.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.google.common.base.Preconditions.checkArgument;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping()
    @ResponseBody
    public UserResult addUser(@RequestBody User user) {
        Preconditions.checkArgument(user != null, "user should be not empty");
        logger.debug("received addUser request: user={}", user);
        String name = user.getName();
        String pwd = user.getPwd();
        checkArgument(!Strings.isNullOrEmpty(name), "name should be not empty");
        checkArgument(!Strings.isNullOrEmpty(pwd), "pwd should be not empty");

        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public EmptyResult deleteUser(@PathVariable(value = "id") String id) {
        logger.debug("received deleteUser request: id={}", id);
        checkArgument(!Strings.isNullOrEmpty(id), "id should be not empty");
        return userService.deleteUser(id);
    }

    @PutMapping()
    @ResponseBody
    public UserResult updateUser(@RequestBody User user) {
        checkArgument(user != null, "user should be not null");
        logger.debug("received updateUser request: user={}", user);
        String name = user.getName();
        String pwd = user.getPwd();
        String id = user.getId();
        checkArgument(!Strings.isNullOrEmpty(name), "name should be not empty");
        checkArgument(!Strings.isNullOrEmpty(pwd), "pwd should be not empty");
        checkArgument(!Strings.isNullOrEmpty(id), "id should be not empty");
        return userService.updateUser(user);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public UserResult findUser(@PathVariable(value = "id") String id) {
        logger.debug("received updateUser request: id={}", id);
        checkArgument(!Strings.isNullOrEmpty(id), "id should be not empty");
        return userService.findUserById(id);
    }
}
