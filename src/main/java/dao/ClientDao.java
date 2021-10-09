package dao;

import dao.dao.constant.DaoConstant;
import entity.Client;
import utility.ConnectionPool;
import utility.ContextForConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {

    private static final String SELECT_FROM_CLIENT = "select * from client";
    private static final String SELECT_FROM_CLIENT_WHERE_FIRST_NAME_AND_LAST_NAME = "select * from client where first_name = ? and last_name = ?";
    private static final String INSERT_INTO_CLIENT = "insert into client (first_name, last_name, sex) values (?,?,?)";
    private static final String DELETE_FROM_CLIENT = "delete from client where last_name = ?";
    private static final String FIND_CLIENT_BY_ID = "select *from client where client_id = ?";

    private ConnectionPool connectionPool;

    public Client findById(int id) {
        connectionPool = ContextForConnectionPool.get();
        Client client = new Client();
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_CLIENT_BY_ID)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                clientParsing(resultSet, client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public void create(Client client, Connection connection) {
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CLIENT, Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getSex());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                client.setClientID(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Client client) {
        connectionPool = ContextForConnectionPool.get();
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_CLIENT)
        ) {
            preparedStatement.setString(1, client.getLastName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> findAll() {
        connectionPool = ContextForConnectionPool.get();
        List<Client> clients = new ArrayList<>();
        try (Connection connection = connectionPool.get();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_FROM_CLIENT)
        ) {
            resultSetWork(clients, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public Client findByFirstNameAndSecondName(String name, String secondName) {
        connectionPool = ContextForConnectionPool.get();
        List<Client> clients = new ArrayList<>();
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_CLIENT_WHERE_FIRST_NAME_AND_LAST_NAME)
        ) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, secondName);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSetWork(clients, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients.get(0);
    }

    private void resultSetWork(List<Client> clients, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Client client = new Client();
            clientParsing(resultSet, client);
            clients.add(client);
        }
    }

    private void clientParsing(ResultSet resultSet, Client client) throws SQLException {
        client.setFirstName(resultSet.getString(DaoConstant.DAO_FIRST_NAME));
        client.setLastName(resultSet.getString(DaoConstant.DAO_LAST_NAME));
        client.setDiagnoses(resultSet.getString(DaoConstant.DAO_DIAGNOSE));
        client.setSex(resultSet.getString(DaoConstant.DAO_SEX));
        client.setDateOfBirth(resultSet.getTimestamp(DaoConstant.DAO_DATE_OF_BIRTH));
    }
}

