package dao;

import dao.dao.constant.DaoConstant;
import entity.Material;
import utility.ConnectionPool;
import utility.ContextForConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDao {
    private static final String FIND_ALL = "select * from material";
    private static final String FIND_BY_TYPE = "select * from material where type = ?";
    private static final String CREATE_MATERIAL = "insert into material (quantity, colour, type, price, material_name) values (?,?,?,?,?)";
    private static final String DELETE_FROM_MATERIAL_BY_NAME = "delete from material where material_name = ?";
    private static final String GET_MATERIAL_ID_BY_NAME = "select material_id from material where material_name = ? and colour = ? and type  = ? and price = ?";
    private static final String UPDATE_MATERIAL = "update material set quantity = ?, colour = ?, type = ?, price = ?, material_name = ? where material_id = ?";

    private ConnectionPool connectionPool;

    public void createNewMaterial(Material material) {
        connectionPool = ContextForConnectionPool.get();
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_MATERIAL)) {
            preparedStatement.setInt(1, material.getQuantity());
            preparedStatement.setString(2, material.getColour());
            preparedStatement.setString(3, material.getType());
            preparedStatement.setInt(4, material.getPrice());
            preparedStatement.setString(5, material.getMaterialName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteFromMaterialByName(Material material) {
        connectionPool = ContextForConnectionPool.get();
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_MATERIAL_BY_NAME)) {
            preparedStatement.setString(1, material.getMaterialName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int materialID(Material material) {
        connectionPool = ContextForConnectionPool.get();
        int materialID = 0;
        ResultSet resultSet;
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_MATERIAL_ID_BY_NAME)) {
            preparedStatement.setString(1, material.getMaterialName());
            preparedStatement.setString(2, material.getColour());
            preparedStatement.setString(3, material.getType());
            preparedStatement.setInt(4, material.getPrice());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                materialID = resultSet.getInt(DaoConstant.DAO_MATERIAL_ID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materialID;
    }

    public List<Material> findAll() {
        connectionPool = ContextForConnectionPool.get();
        List<Material> materials = new ArrayList<>();
        try (Connection connection = connectionPool.get();
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
        connectionPool = ContextForConnectionPool.get();
        List<Material> materials = new ArrayList<>();
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_TYPE)
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
            material.setColour(resultSet.getString(DaoConstant.DAO_COLOUR));
            material.setDensity(resultSet.getString(DaoConstant.DAO_DENSITY));
            material.setPrice(resultSet.getInt(DaoConstant.DAO_PRICE));
            material.setMaterialName(resultSet.getString(DaoConstant.DAO_MATERIAL_NAME));
            material.setType(resultSet.getString(DaoConstant.DAO_TYPE));
            material.setQuantity(resultSet.getInt(DaoConstant.DAO_QUANTITY));
            materials.add(material);
        }
    }

    public void updateMaterial(Material material, int id) {
        connectionPool = ContextForConnectionPool.get();
        try (Connection connection = connectionPool.get();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MATERIAL)) {
            preparedStatement.setInt(1, material.getQuantity());
            preparedStatement.setString(2, material.getColour());
            preparedStatement.setString(3, material.getType());
            preparedStatement.setInt(4, material.getPrice());
            preparedStatement.setString(5, material.getMaterialName());
            preparedStatement.setInt(6, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
