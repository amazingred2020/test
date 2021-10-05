package com.senlainc.mappers.comment;

import com.senlainc.dao.UserDao;
import com.senlainc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserById {

    @Autowired
    private UserDao userDao;

    public User fromIdToUser(Long id){
        return userDao.findById(id);
    }
}
