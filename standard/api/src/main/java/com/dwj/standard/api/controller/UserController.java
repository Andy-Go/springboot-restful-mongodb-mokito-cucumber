package com.dwj.standard.api.controller;

import com.dwj.common.result.EmptyResult;
import com.dwj.standard.api.client.UserClient;
import com.dwj.standard.entity.User;
import com.dwj.standard.result.UserResult;
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
    public UserResult addUser(@RequestBody User user, HttpServletResponse response) {
        return userClient.addUser(user);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public EmptyResult deleteUser(@PathVariable(value = "id") String id, HttpServletResponse response) {
        return userClient.deleteUser(id);
    }

    @PutMapping()
    @ResponseBody
    public UserResult updateUser(@RequestBody User user, HttpServletResponse response) {
        return userClient.updateUser(user);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public UserResult findUser(@PathVariable(value = "id") String id, HttpServletResponse response) {
        return userClient.findUser(id);
    }

}
