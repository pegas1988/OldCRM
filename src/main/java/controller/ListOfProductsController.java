package controller;

import entity.Product;
import service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListOfProductsController implements Controller {
    private final String VIEW_NAME;

    ProductService productService = new ProductService();

    public ListOfProductsController(String VIEW_NAME) {
        this.VIEW_NAME = VIEW_NAME;
    }

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Product> products = productService.findAllProducts();
        req.setAttribute("listOfProducts", products);
        return new ControllerResultDto(VIEW_NAME);
    }
}
