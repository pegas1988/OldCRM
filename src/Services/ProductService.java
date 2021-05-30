package Services;

import DaoLayer.ProductDao;
import entities.Product;

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
}
