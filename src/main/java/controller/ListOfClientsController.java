package controller;

import entity.Client;
import service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListOfClientsController implements Controller {

    private final String VIEW_NAME;

    public ListOfClientsController(String VIEW_NAME) {
        this.VIEW_NAME = VIEW_NAME;
    }

    ClientService clientService = new ClientService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Client> materials = clientService.findAll();
        req.setAttribute("list", materials);
        return new ControllerResultDto(VIEW_NAME);
    }
}

