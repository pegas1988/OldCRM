package service;

import entity.User;
import entity.roles;

public class MainClass {
    public static void main(String[] args) {
        User user = new User("mike", "mike", "123", "DOCTOR", roles.DOCTOR);
        UserService us = new UserService();
        us.create(user);
    }
}
