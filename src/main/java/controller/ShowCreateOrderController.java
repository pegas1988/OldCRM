package controller;

import entity.Product;
import service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowCreateOrderController implements Controller {

    private final String VIEW_NAME;
    ProductService productService = new ProductService();

    public ShowCreateOrderController(String VIEW_NAME) {
        this.VIEW_NAME = VIEW_NAME;
    }

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Product> list = productService.findAllProducts();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            names.add(list.get(i).getProductName());
        }
        req.setAttribute("list", names);
        return new ControllerResultDto(VIEW_NAME);
    }
}
