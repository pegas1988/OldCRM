package controller;

import controller.constant.ControllerConstant;
import entity.Product;
import service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListOfProductsController implements Controller {

    private final String VIEW_NAME;
    private ProductService productService = new ProductService();

    ListOfProductsController(String VIEW_NAME) {
        this.VIEW_NAME = VIEW_NAME;
    }

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        List<Product> products = productService.findAllProducts();
        req.setAttribute(ControllerConstant.CONTROLLER_LIST_OF_PRODUCTS, products);
        return new ControllerResultDto(VIEW_NAME);
    }
}
