package dao;

import utility.PostgresUtil;
import entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private static final String SELECT_ALL = "select * from order";
    private static final String FIND_BY_CREATING_DATE = "select * from order where creating_date = ?";
    private static final String FIND_BY_PRODUCT = "select * from order where product = ?";
    private static final String FIND_BY_ID = "select * from order where order_id = ?";
    private static final String CREATE_ORDER = "insert into order (order_id, creating_date, total_price, lyfe_cycle) values (?,?,?,?)";
    private static final String DELETE = "update order set life_cycle = ?";
    //DELETE will work as i marker in line with other parameters (was deleted / alive)

    public void create(Order order) {
        try (Connection connection = PostgresUtil.getConnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ORDER);
             //PreparedStatement preparedStatementForProducts = connection.prepareStatement()
        ) {
            preparedStatement.setInt(1, order.getOrderID());
            preparedStatement.setDate(2, (Date) order.getDateCreating());
            preparedStatement.setInt(3, order.getTotalPrice());
            preparedStatement.setString(4, order.getLifeCycle());
            for (int e = 0; e < order.getProduct().size(); e ++){

            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Order order) {
        try (Connection connection = PostgresUtil.getConnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        ) {
            preparedStatement.setString(1, order.getLifeCycle());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = PostgresUtil.getConnetion();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL);
        ) {
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderID(resultSet.getInt("order_id"));
                order.setLifeCycle(resultSet.getString("life_cycle"));
                order.setComments(resultSet.getString("comment"));
                order.setStage(resultSet.getString("order_stage"));
                order.setDateCreating(resultSet.getTimestamp("date_of_birth"));
                order.setResponsibleUser(resultSet.getString("responsible_person"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public Order findById(Integer id) {
        Order order = new Order();
        ResultSet resultSet = null;
        try (Connection connection = PostgresUtil.getConnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                order.setOrderID(resultSet.getInt("order_id"));
                order.setLifeCycle(resultSet.getString("life_cycle"));
                order.setComments(resultSet.getString("comment"));
                order.setStage(resultSet.getString("order_stage"));
                order.setDateCreating(resultSet.getTimestamp("creating_date"));
                order.setResponsibleUser(resultSet.getString("responsible_person"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public List<Order> findByProduct(String product) {
        List<Order> orders = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = PostgresUtil.getConnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_PRODUCT)) {
            preparedStatement.setString(1, product);
            ordersCreating(orders, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public List<Order> findByCreatingDate(Date date) {
        List<Order> orders = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = PostgresUtil.getConnetion();
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
            order.setOrderID(resultSet.getInt("order_id"));
            order.setLifeCycle(resultSet.getString("life_cycle"));
            order.setComments(resultSet.getString("comment"));
            order.setStage(resultSet.getString("order_stage"));
            order.setDateCreating(resultSet.getTimestamp("creating_date"));
            order.setResponsibleUser(resultSet.getString("responsible_person"));
            orders.add(order);
        }
    }
}
