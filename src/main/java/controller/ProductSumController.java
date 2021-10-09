package controller;

import controller.constant.ControllerConstant;
import entity.Order;
import entity.Stages;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class ProductSumController implements Controller {

    private OrderService orderService = new OrderService();
    private List<String> productList = new ArrayList<>();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter(ControllerConstant.CONTROLLER_KEY_ADD) != null) {
            productList.add(req.getParameter(ControllerConstant.CONTROLLER_PRODUCT_ONE));
            req.getSession().setAttribute(ControllerConstant.CONTROLLER_PRODUCT_LIST, productList);
            return new ControllerResultDto(ControllerConstant.CONTROLLER_PRODUCT_SUM, true);
        } else {
            Order order = new Order();
            order.setClient(req.getSession().getAttribute(ControllerConstant.CONTROLLER_FIRST_NAME).toString() + " " + req.getSession().getAttribute(ControllerConstant.CONTROLLER_CLIENT_LAST_NAME).toString());
            order.setStage(valueOf(Stages.ORDER));
            order.setResponsibleUser(req.getSession().getAttribute(ControllerConstant.CONTROLLER_BUTTON).toString());
            orderService.createOrder(order, (List<String>) req.getSession().getAttribute(ControllerConstant.CONTROLLER_PRODUCT_LIST));
            productList = null;
            return new ControllerResultDto("orderWasCreated", true);
        }
    }
}
