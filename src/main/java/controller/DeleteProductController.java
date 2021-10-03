package controller;

import entity.Product;
import service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProductController implements Controller {

    ProductService productService = new ProductService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("productName");

        Product product = new Product();
        product.setProductName(name);
        productService.deleteByName(product);

        req.getSession().setAttribute("product", product);

        return new ControllerResultDto("deleteProduct", true);

    }
}
