package com.senlainc.service.user;

import com.senlainc.entity.User;

public interface UserService {

    User findUserById(Long id);
    void saveUser(User category);
}
