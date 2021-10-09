package controller;

import annotation.CheckString;
import controller.constant.ControllerConstant;
import entity.Product;
import service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProductController implements Controller {

    private ProductService productService = new ProductService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        @CheckString
        String productName = req.getParameter(ControllerConstant.CONTROLLER_PRODUCT_CURRENT_NAME);
        @CheckString
        String productNewName = req.getParameter(ControllerConstant.CONTROLLER_PRODUCT_NEW_NAME);

        Product productToFind = new Product(productName);
        Product product = productService.updateByName(productToFind, productNewName);

        req.getSession().setAttribute(ControllerConstant.CONTROLLER_PRODUCT, product);

        return new ControllerResultDto("productUpdateProceed", true);
    }
}