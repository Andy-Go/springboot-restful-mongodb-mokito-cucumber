package com.accenture.standard.service.service;

import com.accenture.common.result.EmptyResult;
import com.accenture.common.result.StringResult;
import com.accenture.standard.entity.User;
import com.accenture.standard.result.UserResult;
import com.accenture.standard.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.accenture.common.result.ResultCode.USER_NOT_FOUNT;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResult addUser(User user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        User user_new = userRepository.insert(user);
        return new UserResult(user_new);
    }

    public EmptyResult deleteUser(String id) {
        userRepository.delete(id);
        return EmptyResult.success();
    }

    public UserResult updateUser(User user) {
        boolean exists = userRepository.exists(user.getId());
        if (!exists) {
            return new UserResult(USER_NOT_FOUNT, "user not found");
        }
        User new_user = userRepository.save(user);
        return new UserResult(new_user);
    }

    public UserResult findUserById(String id) {
        User user = userRepository.findOne(id);
        if (user != null) {
            return new UserResult(user);
        }
        return new UserResult(USER_NOT_FOUNT, "user not found");
    }
}
