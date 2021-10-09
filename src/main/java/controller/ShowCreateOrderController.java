package controller;

import controller.constant.ControllerConstant;
import entity.Product;
import service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ShowCreateOrderController implements Controller {

    private final String VIEW_NAME;
    private ProductService productService = new ProductService();

    ShowCreateOrderController(String VIEW_NAME) {
        this.VIEW_NAME = VIEW_NAME;
    }

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        List<Product> list = productService.findAllProducts();
        List<String> names = new ArrayList<>();
        for (Product product : list) {
            names.add(product.getProductName());
        }
        req.setAttribute(ControllerConstant.CONTROLLER_LIST, names);
        return new ControllerResultDto(VIEW_NAME);
    }
}
