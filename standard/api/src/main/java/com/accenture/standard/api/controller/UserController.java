package com.accenture.standard.api.controller;

import com.accenture.common.result.EmptyResult;
import com.accenture.common.result.StringResult;
import com.accenture.standard.api.client.UserClient;
import com.accenture.standard.entity.User;
import com.accenture.standard.result.UserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserClient userClient;

    @PostMapping()
    @ResponseBody
    public StringResult addUser(@RequestBody User user, HttpServletResponse response) {
        return userClient.addUser(user);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public EmptyResult deleteUser(@PathVariable(value = "id") String id, HttpServletResponse response) {
        return userClient.deleteUser(id);
    }

    @PutMapping("/update")
    @ResponseBody
    public EmptyResult updateUser(@RequestBody User user, HttpServletResponse response) {
        return userClient.updateUser(user);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public UserResult findUser(@PathVariable(value = "id") String id, HttpServletResponse response) {
        return userClient.findUser(id);
    }

}
