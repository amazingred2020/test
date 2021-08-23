package com.senlainc.provider;

import com.senlainc.dao.UserDao;
import com.senlainc.entity.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.senlainc.principal.CustomUserDetails;

@Log4j2
@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) {
        User user = null;
        try {
            user = userDao.findByUsername(s);
        } catch (UsernameNotFoundException e){
            log.warn("Username: " + s + " not found");
        }

        return new CustomUserDetails(user);
    }
}
