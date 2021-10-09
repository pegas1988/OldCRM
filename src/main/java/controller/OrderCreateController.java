package controller;

import annotation.CheckString;
import controller.constant.ControllerConstant;
import entity.Order;
import entity.Stages;
import service.OrderService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderCreateController implements Controller {

    private OrderService orderService = new OrderService();
    private UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        @CheckString
        String clientName = req.getParameter(ControllerConstant.CONTROLLER_CLIENT_FIRST_NAME);
        @CheckString
        String clientLastName = req.getParameter(ControllerConstant.CONTROLLER_CLIENT_LAST_NAME);

        Date date = new Date();

        @CheckString
        String comment = req.getParameter(ControllerConstant.CONTROLLER_COMMENT);
        String orderStage = Stages.ORDER.toString();
        String responsible = userService.findById((int) req.getSession().getAttribute(ControllerConstant.CONTROLLER_USER_ID)).getUserRole().toString();

        Order order = new Order();
        order.setClient(clientName + " " + clientLastName);
        order.setDateCreating(date);
        order.setComments(comment);
        order.setStage(orderStage);
        order.setResponsibleUser(responsible);

        List<String> products = new ArrayList<>();

        products.add(req.getParameter(ControllerConstant.CONTROLLER_PRODUCT_ONE));
        products.add(req.getParameter(ControllerConstant.CONTROLLER_PRODUCT_TWO));

        orderService.createOrder(order, products);

        return new ControllerResultDto("orderCreated");
    }
}
