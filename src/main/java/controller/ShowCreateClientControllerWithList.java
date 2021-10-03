package controller;


import entity.Client;
import service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowCreateClientControllerWithList implements Controller {

    private final String VIEW_NAME;
    private ClientService clientService = new ClientService();

    public ShowCreateClientControllerWithList(String VIEW_NAME) {
        this.VIEW_NAME = VIEW_NAME;
    }

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Client> clientList = clientService.findAll();
        req.setAttribute("clientList", clientList);
        return new ControllerResultDto(VIEW_NAME);
    }
}
