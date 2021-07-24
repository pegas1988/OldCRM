package dao;

import utility.ConnectionPool;
import utility.ContextForConnectionPool;
import utility.PostgresUtil;
import entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static final String SELECT_FROM_PRODUCT = "select * from product";
    private static final String CREATE_PRODUCT = "insert into product (product_name) values (?)";
    private static final String DELETE_FROM_PRODUCT = "delete from product where product_name = ?";
    private static final String GET_PRODUCT_ID_BY_NAME = "select product_id from product where product_name = ?";
    private static final String INSERT_INTO_PRODUCT_MATERIAL_PRODUCT_ID_MATERIAL_ID_VALUES = "insert into product_material (product_id, material_id) values (?, ?)";

    ConnectionPool connectionPool;

    public List<Product> findAll() {
        connectionPool = ContextForConnectionPool.get();
        List<Product> products = new ArrayList<>();
        try (Connection connection = connectionPool.get();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_FROM_PRODUCT)
        ) {
            while (resultSet.next()) {
                Product product = new Product();
                product.setTimeToProduce(resultSet.getInt("production_time"));
                product.setPriceOfAllMaterials(resultSet.getInt("material_price"));
                product.setProductName(resultSet.getString("product_name"));
                product.setId(resultSet.getInt("product_id"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public int productID(Product product) {
        connectionPool = ContextForConnectionPool.get();
        int productID = 0;
        ResultSet resultSet = null;
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_ID_BY_NAME)) {
            preparedStatement.setString(1, product.getProductName());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productID = resultSet.getInt("product_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productID;
    }


    public Product findById(Integer id){
        return new Product();
    }

    public void create(Product product) {
        connectionPool = ContextForConnectionPool.get();
        MaterialDao materialDao = new MaterialDao();
        try (Connection connection = connectionPool.get();
             //PreparedStatement preparedStatementProductID = connection.prepareStatement(INSERT_INTO_PRODUCT_MATERIAL_PRODUCT_ID_MATERIAL_ID_VALUES);
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT)) {
            //preparedStatement.setInt(1, product.getPriceOfAllMaterials());
            //preparedStatement.setInt(2, product.getTimeToProduce());
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.execute();
            /*for (int e = 0; e < product.getMaterialList().size(); e++) {
                preparedStatementProductID.setInt(1, productID(product));
                preparedStatementProductID.setInt(2, materialDao.materialID(product.getMaterialList().get(e)));
                preparedStatementProductID.execute();
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromProduct(Product product) {
        connectionPool = ContextForConnectionPool.get();
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_PRODUCT)) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
