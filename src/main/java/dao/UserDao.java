package dao;

import utility.PostgresUtil;
import entity.User;
import entity.roles;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static final String SELECT_FROM_USER = "select * from \"user\"";
    private static final String SELECT_FROM_USER_BY_FIRST_NAME_LAST_NAME = "select * from \"user\" where first_name = ? and last_name = ?";
    private static final String INSERT_INTO_USER = "insert into \"user\" (first_name, last_name, password, user_role, email) VALUES (?,?,?,?,?)";
    private static final String DELETE_FROM_USER = "delete from \"user\" where first_name = ? and last_name = ?";
    private static final String UPDATE_USER_SET_PASSWORD_WHERE_FIRST_NAME_AND_LAST_NAME_AND_PASSWORD = "update \"user\" set password = ? where first_name = ? and last_name = ? and password = ?";
    private static final String FIND_USER_BY_EMAIL = "select * from \"user\" where email =?";

    public void create(User user) {
        try (Connection connection = PostgresUtil.getConnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_USER)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getUserRole().toString());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateUserPassword(User user, String newPassword) {
        try (Connection connection = PostgresUtil.getConnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SET_PASSWORD_WHERE_FIRST_NAME_AND_LAST_NAME_AND_PASSWORD)
        ) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromUser(User user) {
        try (Connection connection = PostgresUtil.getConnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_USER)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public User selectFromUserByFirstNameAndLastName(User user) {
        User searchedUser = new User();
        ResultSet resultSet = null;
        try (Connection connection = PostgresUtil.getConnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_USER_BY_FIRST_NAME_LAST_NAME)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                searchedUser.setFirstName(resultSet.getString("first_name"));
                searchedUser.setLastName(resultSet.getString("last_name"));
                searchedUser.setPassword(resultSet.getString("password"));
                searchedUser.setUserRole(roles.valueOf(resultSet.getString("user_role")));
                searchedUser.setUserID(resultSet.getInt("user_id"));
                searchedUser.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return searchedUser;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = PostgresUtil.getConnetion();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_FROM_USER)
        ) {
            while (resultSet.next()) {
                User user = new User();
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setPassword(resultSet.getString("password"));
                user.setUserID(resultSet.getInt("user_id"));
                user.setUserRole(roles.valueOf(resultSet.getString("user_role")));
                users.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User findByEmail(User userFind) {
        User userToFind = new User();
        ResultSet resultSet = null;
        try (Connection connection = PostgresUtil.getConnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_EMAIL)) {
            preparedStatement.setString(1, userFind.getEmail());
            resultSet = preparedStatement.executeQuery();
            {
                while (resultSet.next()) {
                    userToFind.setFirstName(resultSet.getString("first_name"));
                    userToFind.setLastName(resultSet.getString("last_name"));
                    userToFind.setPassword(resultSet.getString("password"));
                    userToFind.setUserID(resultSet.getInt("user_id"));
                    userToFind.setUserRole(roles.valueOf(resultSet.getString("user_role")));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userToFind;
    }
}
