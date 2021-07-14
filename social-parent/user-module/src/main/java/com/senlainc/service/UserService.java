package com.senlainc.service;

import com.senlainc.entity.User;

public interface UserService {

    User findUserById(Long id);
    User saveUser(User category);
}
