package controller;

import entity.Client;
import service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientCreateController implements Controller {
    ClientService clientService = new ClientService();
    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String clientName = req.getParameter("clientName");
        String clientLastName = req.getParameter("clientLastName");
        String gender = req.getParameter("gender");
        Client client = new Client();
        client.setFirstName(clientName);
        client.setLastName(clientLastName);
        client.setSex(gender);
        clientService.create(client);
        return new ControllerResultDto("clientCreated", true);
    }
}
