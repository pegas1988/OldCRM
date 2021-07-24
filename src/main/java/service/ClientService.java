package service;

import dao.ClientDao;
import entity.Client;
import utility.ConnectionPool;
import utility.ContextForConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class ClientService {
    ClientDao clientDao = new ClientDao();

    public List<Client> findAll() {
        List<Client> allClients = clientDao.findAll();
        if (allClients.isEmpty())
            System.out.println("List is empty");
        return allClients;
    }

    public ClientService() {
    }

    public ClientService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public Client findByName(String name, String secondName) {
        Client byName = clientDao.findByFirstNameAndSecondName(name, secondName);
        if (Objects.isNull(byName)) {
            System.out.println(String.format("Clinet with name %s was not found", name));
        }
        return byName;
    }

    public Client findById(int id) {
        return clientDao.findById(id);
    }

    public void create(Client client) throws SQLException {
        ConnectionPool connectionPool = ContextForConnectionPool.get();
        Connection connection = connectionPool.get();
        try {
            connection.setAutoCommit(false);
            clientDao.create(client, connection);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException i) {
                i.printStackTrace();
            } finally {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
    }

    public void delete(Client client) {
        clientDao.delete(client);
    }
    //public void update(Client client) {clientDao.update(client);}
}
