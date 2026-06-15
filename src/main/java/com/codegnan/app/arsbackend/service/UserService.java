package com.codegnan.app.arsbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

import com.codegnan.app.arsbackend.dao.UserDao;
import com.codegnan.app.arsbackend.entity.User;

@Service 
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public boolean signUp(User user) {

        User existingUser = userDao.findByEmail(user.getEmail());

        if (existingUser != null) {
            return false;
        }

        User savedUser = userDao.save(user);

        return savedUser != null && savedUser.getUserId() != null;
    }
}