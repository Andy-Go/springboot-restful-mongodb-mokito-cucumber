package com.dwj.standard.api.client;

import com.dwj.common.result.EmptyResult;

import com.dwj.standard.entity.User;
import com.dwj.standard.result.UserResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service-standard", path = "/service-standard/user" , fallback = ClientHystrix.class)
public interface UserClient {

    @PostMapping("")
    UserResult addUser(@RequestBody User user);

    @DeleteMapping("/{id}")
    EmptyResult deleteUser(@PathVariable(value = "id") String id);

    @PutMapping("")
    UserResult updateUser(@RequestBody User user);

    @GetMapping("/{id}")
    UserResult findUser(@PathVariable(value = "id") String id);
}
