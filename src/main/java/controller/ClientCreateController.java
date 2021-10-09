package controller;

import annotation.CheckString;
import controller.constant.ControllerConstant;
import entity.Client;
import service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientCreateController implements Controller {
    ClientService clientService = new ClientService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        @CheckString
        String clientName = req.getParameter(ControllerConstant.CONTROLLER_CLIENT_NAME);
        @CheckString
        String clientLastName = req.getParameter(ControllerConstant.CONTROLLER_CLIENT_LAST_NAME);
        @CheckString
        String gender = req.getParameter(ControllerConstant.CONTROLLER_GENDER);

        Client client = new Client();
        client.setFirstName(clientName);
        client.setLastName(clientLastName);
        client.setSex(gender);

        return getControllerResultDto(req, clientName, clientLastName, client, clientService);
    }
}
