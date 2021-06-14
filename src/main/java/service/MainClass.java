package service;

import entity.Material;
import entity.Product;
import entity.User;
import entity.roles;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        UserService userService = new UserService();

        /*Product product = new Product();
        List<Material> materials = new ArrayList<>();
        materials.add(new Material("EVA-25"));
        materials.add(new Material("EVA-35"));
        materials.add(new Material("EVA-45"));
        product.setMaterialList(materials);
        product.setPriceOfAllMaterials(100);
        product.setProductName("Shoe");
        product.setTimeToProduce(5);
        ProductService productService = new ProductService();
        productService.createProduct(product);
        */

        User user = new User("mike", "mike", "123", "DOCTOR", roles.DOCTOR);
        UserService us = new UserService();
        us.create(user);
    }
}
