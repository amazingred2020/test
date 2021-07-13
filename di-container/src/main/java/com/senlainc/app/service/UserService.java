package com.senlainc.app.service;

import com.senlainc.app.entity.User;

public interface UserService {

    User findUserById(Long id);
    User saveUser(User category);
}
