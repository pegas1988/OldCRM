package dao;

import entity.User;
import entity.roles;
import utility.ConnectionPool;
import utility.ContextForConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static final String SELECT_FROM_USER = "select * from myuser";
    private static final String SELECT_FROM_USER_BY_FIRST_NAME_LAST_NAME = "select * from myuser where first_name = ? and last_name = ?";
    private static final String INSERT_INTO_USER = "insert into myuser (first_name, last_name, password, user_role, email) VALUES (?,?,?,?,?)";
    private static final String DELETE_FROM_USER = "delete from myuser where first_name = ? and last_name = ?";
    private static final String UPDATE_USER_SET_PASSWORD_WHERE_FIRST_NAME_AND_LAST_NAME_AND_PASSWORD = "update myuser set password = ? where first_name = ? and last_name = ? and password = ?";
    private static final String FIND_USER_BY_EMAIL = "select * from myuser where email =?";
    private static final String FIND_USER_BY_ID = "select * from myuser where user_id =?";
    private static final String UPDATE_USER = "update myuser set first_name = ?, last_name = ?, password = ?, user_role = ? where email = ?";

    ConnectionPool connectionPool;

    public void create(User user) {
        connectionPool = ContextForConnectionPool.get();
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_USER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getUserRole().toString());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.execute();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setUserID(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserPassword(User user, String newPassword) {
        connectionPool = ContextForConnectionPool.get();
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SET_PASSWORD_WHERE_FIRST_NAME_AND_LAST_NAME_AND_PASSWORD)
        ) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromUser(User user) {
        connectionPool = ContextForConnectionPool.get();
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_USER)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User selectFromUserByFirstNameAndLastName(User user) {
        connectionPool = ContextForConnectionPool.get();
        User searchedUser = new User();
        ResultSet resultSet;
        try (Connection connection = connectionPool.get();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return searchedUser;
    }

    public List<User> findAll() {
        connectionPool = ContextForConnectionPool.get();
        List<User> users = new ArrayList<>();
        try (Connection connection = connectionPool.get();
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
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User findByEmail(User userFind) {
        connectionPool = ContextForConnectionPool.get();
        User userToFind = new User();
        ResultSet resultSet;
        try (Connection connection = connectionPool.get();
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
                    userToFind.setEmail(userFind.getEmail());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userToFind;
    }

    public User findById(int id) {
        connectionPool = ContextForConnectionPool.get();
        User userToFind = new User();
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            {
                while (resultSet.next()) {
                    userToFind.setFirstName(resultSet.getString("first_name"));
                    userToFind.setLastName(resultSet.getString("last_name"));
                    userToFind.setPassword(resultSet.getString("password"));
                    userToFind.setUserRole(roles.valueOf(resultSet.getString("user_role")));
                    userToFind.setEmail(resultSet.getString("email"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userToFind;
    }

    public void updateUser(User user) {
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getUserRole().toString());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
