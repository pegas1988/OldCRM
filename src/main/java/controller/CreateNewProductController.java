package controller;

import entity.Product;
import service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateNewProductController implements Controller {

    ProductService productService = new ProductService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("productName");

        Product product = new Product();
        product.setProductName(name);
        productService.createProduct(product);

        return new ControllerResultDto("productCreated");
    }
}
