package service;

import dao.ProductDao;
import entity.Product;

import java.util.List;

public class ProductService {
    ProductDao productDao = new ProductDao();

    public List<Product> findAllProducts() {
        return productDao.findAll();
    }

    public void createProduct(Product product) {
        productDao.create(product);

    }

    public void deleteByName(Product product) {
        productDao.deleteFromProduct(product);
    }

    public int getIDByName(Product product) {
        return productDao.productID(product);
    }
}
