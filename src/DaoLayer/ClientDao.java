package DaoLayer;

import Utilities.PostgresUtil;
import entities.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {

    private static final String SELECT_FROM_CLIENT = "select * from clients";
    private static final String SELECT_FROM_CLIENT_BY_NAME = "select * from clients where first_name = ?";

    public void create(Client client) {
    }

    public void delete(Client client) {
    }

    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = PostgresUtil.getConnetion();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_FROM_CLIENT);
        ) {
            while (resultSet.next()) {
                Client client = new Client();
                client.setFirstName(resultSet.getString("first_name"));
                client.setLastName(resultSet.getString("last_name"));
                client.setDiagnoses(resultSet.getString("diagnoses"));
                client.setSex(resultSet.getString("sex"));
                client.setDateOfBirth(resultSet.getTimestamp("date_of_birth"));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public List<Client> findByName(String name) {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = PostgresUtil.getConnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_CLIENT_BY_NAME);
        ) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Client client = new Client();
                client.setFirstName(resultSet.getString("first_name"));
                client.setLastName(resultSet.getString("last_name"));
                client.setDiagnoses(resultSet.getString("diagnoses"));
                client.setSex(resultSet.getString("sex"));
                client.setDateOfBirth(resultSet.getTimestamp("date_of_birth"));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
}

