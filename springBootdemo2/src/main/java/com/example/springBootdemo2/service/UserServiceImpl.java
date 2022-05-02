package com.example.springBootdemo2.service;

import com.example.springBootdemo2.dao.UserDao;
import com.example.springBootdemo2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {



    private final  UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User getUserId(long id) {
        return userDao.getUserId(id);
    }

    @Override
    public User removeUser(long id) {
        return userDao.removeUser(id);
    }
}