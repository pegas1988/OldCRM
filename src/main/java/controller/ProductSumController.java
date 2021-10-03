package controller;

import entity.Order;
import entity.Stages;
import service.OrderService;
import service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class ProductSumController implements Controller {

    ProductService productService = new ProductService();
    OrderService orderService = new OrderService();
    List<String> productList = new ArrayList<>();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getParameter("keyAdd") != null) {
            productList.add(req.getParameter("productOne"));
            req.getSession().setAttribute("productList", productList);
            return new ControllerResultDto("productSum", true);
        } else {
            Order order = new Order();
            order.setClient(req.getSession().getAttribute("clientFirstName").toString() + " " + req.getSession().getAttribute("clientLastName").toString());
            order.setStage(valueOf(Stages.ORDER));
            order.setResponsibleUser(req.getSession().getAttribute("button").toString());
            orderService.createOrder(order, (List<String>) req.getSession().getAttribute("productList"));
            productList = null;
            return new ControllerResultDto("orderWasCreated", true);
        }
    }
}
