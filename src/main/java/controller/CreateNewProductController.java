package controller;

import annotation.CheckString;
import controller.constant.ControllerConstant;
import entity.Product;
import service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateNewProductController implements Controller {

    private ProductService productService = new ProductService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        @CheckString
        String name = req.getParameter(ControllerConstant.CONTROLLER_PRODUCT_NAME);

        Product product = new Product();
        product.setProductName(name);
        productService.createProduct(product);

        return new ControllerResultDto("productCreated");
    }
}
