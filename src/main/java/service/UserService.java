package service;

import dao.UserDao;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void create(User user) {
        userDao.create(user);
    }

    public User findByEmail(User user) {
        return userDao.findByEmail(user);
    }

    public User findById(int id) {
        return userDao.findById(id);
    }

    public void updateUserPasswordByName(User user, String newPassword) {
        userDao.updateUserPassword(user, newPassword);
    }

    public void deleteFromUser(User user) {
        userDao.deleteFromUser(user);
    }

    public List<User> findAllUsers() {
        List<User> users;
        users = userDao.findAll();
        return users;
    }

    public User findByFirstAndLastName(User user) {
        return userDao.selectFromUserByFirstNameAndLastName(user);
    }

}
