package Services;

import DaoLayer.UserDao;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();

    public void create(User user) {
        userDao.create(user);
    }

    public void updateUserPasswordByName(User user, String newPassword) {
        userDao.updateUserPassword(user, newPassword);
    }

    public void deleteFromUser(User user) {
        userDao.deleteFromUser(user);
    }

    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        users = userDao.findAll();
        return users;
    }

    public User findByFirstAndLastName(User user) {
        return userDao.selectFromUserByFirstNameAndLastName(user);
    }

}
