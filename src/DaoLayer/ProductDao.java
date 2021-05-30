package DaoLayer;

import Utilities.PostgresUtil;
import entities.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static final String SELECT_FROM_PRODUCT = "select * from product";
    private static final String CREATE_PRODUCT = "insert into product (material_price, production_time, product_name) values (?,?,?)";
    private static final String DELETE_FROM_PRODUCT = "delete from product where product_name = ?";

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = PostgresUtil.getConnetion();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_FROM_PRODUCT)
        ) {
            while (resultSet.next()) {
                Product product = new Product();
                product.setTimeToProduce(resultSet.getInt("production_time"));
                product.setPriceOfAllMaterials(resultSet.getInt("material_price"));
                product.setProductName(resultSet.getString("product_name"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void create(Product product) {
        try (Connection connection = PostgresUtil.getConnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT)) {
            preparedStatement.setInt(1, product.getPriceOfAllMaterials());
            preparedStatement.setInt(2, product.getTimeToProduce());
            //preparedStatement.setString(3, product.getMaterialList());
            preparedStatement.setString(4, product.getProductName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromProduct(Product product) {
        try (Connection connection = PostgresUtil.getConnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_PRODUCT)) {
            preparedStatement.setString(1, product.getProductName());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
