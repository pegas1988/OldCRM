package dao;

import dao.dao.constant.DaoConstant;
import entity.Order;
import utility.ConnectionPool;
import utility.ContextForConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private static final String SELECT_ALL = "select * from \"order\"";
    private static final String FIND_BY_CREATING_DATE = "select * from \"order\" where creating_date = ?";
    private static final String FIND_BY_PRODUCT = "select * from \"order\" where product = ?";
    private static final String FIND_BY_ID = "select * from \"order\" where order_id = ?";
    private static final String CREATE_ORDER = "insert into \"order\" (client_fio, comment, order_stage, responsible_person) values (?,?,?,?)";
    private static final String DELETE = "update \"order\" set client_fio = ?";
    private static final String ORDER_PRODUCT = "insert into order_product (order_id, product_name) values (?,?)";

    private ConnectionPool connectionPool;

    public void create(Order order, List<String> products) {
        connectionPool = ContextForConnectionPool.get();
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ORDER, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement preparedStatementForProducts = connection.prepareStatement(ORDER_PRODUCT)
        ) {
            preparedStatement.setString(1, order.getClient());
            preparedStatement.setString(2, order.getComments());
            preparedStatement.setString(3, order.getStage());
            preparedStatement.setString(4, order.getResponsibleUser());
            preparedStatement.execute();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()) {
                order.setOrderID(generatedKeys.getInt(DaoConstant.DAO_ORDER_ID));
            }
            for (String product : products) {
                preparedStatementForProducts.setInt(1, order.getOrderID());
                preparedStatementForProducts.setString(2, product);
                preparedStatementForProducts.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Order order) {
        connectionPool = ContextForConnectionPool.get();
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)
        ) {
            preparedStatement.setString(1, order.getLifeCycle());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> findAll() {
        connectionPool = ContextForConnectionPool.get();
        List<Order> orders = new ArrayList<>();
        try (Connection connection = connectionPool.get();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL)
        ) {
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderID(resultSet.getInt(DaoConstant.DAO_ORDER_ID));
                order.setComments(resultSet.getString(DaoConstant.DAO_COMMENT));
                order.setStage(resultSet.getString(DaoConstant.DAO_ORDER_STAGE));
                order.setDateCreating(resultSet.getTimestamp(DaoConstant.DAO_CREATING_DATE));
                order.setResponsibleUser(resultSet.getString(DaoConstant.DAO_RESPONSIBLE_PERSON));
                order.setClient(resultSet.getString(DaoConstant.DAO_CLIENTS_FIO));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public Order findById(Integer id) {
        connectionPool = ContextForConnectionPool.get();
        Order order = new Order();
        ResultSet resultSet;
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orderParsing(order, resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    private void orderParsing(Order order, ResultSet resultSet) throws SQLException {
        order.setOrderID(resultSet.getInt(DaoConstant.DAO_ORDER_ID));
        order.setLifeCycle(resultSet.getString(DaoConstant.DAO_LIFE_CYCLE));
        order.setComments(resultSet.getString(DaoConstant.DAO_COMMENT));
        order.setStage(resultSet.getString(DaoConstant.DAO_ORDER_STAGE));
        order.setDateCreating(resultSet.getTimestamp(DaoConstant.DAO_CREATING_DATE));
        order.setResponsibleUser(resultSet.getString(DaoConstant.DAO_RESPONSIBLE_PERSON));
    }

    public List<Order> findByProduct(String product) {
        connectionPool = ContextForConnectionPool.get();
        List<Order> orders = new ArrayList<>();
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_PRODUCT)) {
            preparedStatement.setString(1, product);
            ordersCreating(orders, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public List<Order> findByCreatingDate(Date date) {
        connectionPool = ContextForConnectionPool.get();
        List<Order> orders = new ArrayList<>();
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_CREATING_DATE)) {
            preparedStatement.setDate(1, date);
            ordersCreating(orders, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    private void ordersCreating(List<Order> orders, PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Order order = new Order();
            orderParsing(order, resultSet);
            orders.add(order);
        }
    }
}
