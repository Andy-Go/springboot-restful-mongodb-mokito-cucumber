package com.accenture.standard.api.client;

import com.accenture.common.result.EmptyResult;
import com.accenture.common.result.StringResult;

import com.accenture.standard.entity.User;
import com.accenture.standard.result.UserResult;
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
    StringResult addUser(@RequestBody User user);

    @DeleteMapping("/{id}")
    EmptyResult deleteUser(@PathVariable(value = "id") String id);

    @PutMapping("")
    EmptyResult updateUser(@RequestBody User user);

    @GetMapping("/{id}")
    UserResult findUser(@PathVariable(value = "id") String id);
}
