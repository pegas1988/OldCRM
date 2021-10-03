package controller;

import entity.Product;
import service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProductController implements Controller {

    ProductService productService = new ProductService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        String productName = req.getParameter("productCurrentName");
        String productNewName = req.getParameter("productNewName");

        Product productToFind = new Product(productName);
        Product product = productService.updateByName(productToFind, productNewName);

        req.getSession().setAttribute("product", product);

        return new ControllerResultDto("productUpdateProceed", true);
    }
}