package DaoLayer;

import Utilities.PostgresUtil;
import entities.Material;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDao {
    private static final String FIND_ALL = "select * from materials";
    private static final String FIND_BY_TYPE = "select * from materials where type = ?";
    private static final String CREATE_MATERIAL = "inset into materials (quantity, colour, density, type, price, material_name) values (?,?,?,?,?,?)";
    private static final String DELETE_FROM_MATERIAL_BY_NAME = "delete from materials where material_name = ?";

    public void createNewMaterial(Material material) {
        try (Connection connection = PostgresUtil.getConnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_MATERIAL)) {
            preparedStatement.setInt(1, material.getQuantity());
            preparedStatement.setString(2, material.getColour());
            preparedStatement.setString(3, material.getDensity());
            preparedStatement.setString(4, material.getType());
            preparedStatement.setInt(5, material.getPrice());
            preparedStatement.setString(6, material.getMaterialName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromMaterialByName(Material material) {
        try (Connection connection = PostgresUtil.getConnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_MATERIAL_BY_NAME)) {
            preparedStatement.setString(1, material.getMaterialName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Material> findAll() {
        List<Material> materials = new ArrayList<>();
        try (Connection connection = PostgresUtil.getConnetion();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FIND_ALL)
        ) {
            makeMaterial(materials, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materials;
    }

    public List<Material> findByType(String type) {
        List<Material> materials = new ArrayList<>();
        try (Connection connection = PostgresUtil.getConnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_TYPE);
        ) {
            preparedStatement.setString(1, type);
            ResultSet resultSet = preparedStatement.executeQuery();
            makeMaterial(materials, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materials;
    }

    private void makeMaterial(List<Material> materials, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Material material = new Material();
            material.setColour(resultSet.getString("colour"));
            material.setDensity(resultSet.getString("density"));
            material.setPrice(resultSet.getInt("price"));
            material.setMaterialName(resultSet.getString("material_name"));
            material.setType(resultSet.getString("type"));
            material.setQuantity(resultSet.getInt("quantity"));
            materials.add(material);
        }
    }
}
