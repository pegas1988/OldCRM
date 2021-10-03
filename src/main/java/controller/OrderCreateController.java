package controller;

import entity.Order;
import entity.Stages;
import service.ClientService;
import service.OrderService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderCreateController implements Controller {

    OrderService orderService = new OrderService();
    ClientService clientService = new ClientService();
    UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String clientName = req.getParameter("clientFirstName");
        String clientLastName = req.getParameter("clientLastName");

        Date date = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String creationDate = formatter.format(date);
        String comment = req.getParameter("comment");
        String orderStage = Stages.ORDER.toString();
        String responsible = userService.findById((int) req.getSession().getAttribute("UserId")).getUserRole().toString();

        Order order = new Order();
        order.setClient(clientName + " " + clientLastName);
        order.setDateCreating(date);
        order.setComments(comment);
        order.setStage(orderStage);
        order.setResponsibleUser(responsible);

        List<String> products = new ArrayList<>();

        products.add(req.getParameter("productOne"));
        products.add(req.getParameter("productTwo"));

        orderService.createOrder(order, products);

        return new ControllerResultDto("orderCreated");
    }
}
