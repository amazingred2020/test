package com.senlainc.service.user;

import com.senlainc.entity.User;

import java.util.List;

public interface UserService {

    User findUserById(Long id);
    void saveUser(User user);
}
