package controller;


import controller.constant.ControllerConstant;
import entity.Client;
import service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowCreateClientControllerWithList implements Controller {

    private final String VIEW_NAME;
    private ClientService clientService = new ClientService();

    ShowCreateClientControllerWithList(String VIEW_NAME) {
        this.VIEW_NAME = VIEW_NAME;
    }

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        List<Client> clientList = clientService.findAll();
        req.setAttribute(ControllerConstant.CONTROLLER_CLIENT_LIST, clientList);
        return new ControllerResultDto(VIEW_NAME);
    }
}
