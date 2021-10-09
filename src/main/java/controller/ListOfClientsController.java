package controller;

import controller.constant.ControllerConstant;
import entity.Client;
import service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListOfClientsController implements Controller {

    private final String VIEW_NAME;

    ListOfClientsController(String VIEW_NAME) {
        this.VIEW_NAME = VIEW_NAME;
    }

    private ClientService clientService = new ClientService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        List<Client> materials = clientService.findAll();
        req.setAttribute(ControllerConstant.CONTROLLER_LIST, materials);
        return new ControllerResultDto(VIEW_NAME);
    }
}

