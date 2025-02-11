package com.example.sallereservation.service;

import com.example.sallereservation.dao.UserDao;
import com.example.sallereservation.model.User;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
}
