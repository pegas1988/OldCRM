package controller;

import annotation.CheckString;
import controller.constant.ControllerConstant;
import entity.Client;
import org.jetbrains.annotations.NotNull;
import service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class ClientCreateControllerWithList implements Controller {

    private ClientService clientService = new ClientService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter(ControllerConstant.CONTROLLER_ADD_CLIENT) != null) {
            @CheckString
            String clientName = req.getParameter(ControllerConstant.CONTROLLER_CLIENT_NAME);
            @CheckString
            String clientLastName = req.getParameter(ControllerConstant.CONTROLLER_CLIENT_LAST_NAME);
            @CheckString
            String gender = req.getParameter(ControllerConstant.CONTROLLER_GENDER);

            Client client = new Client();
            client.setSex(gender);
            client.setLastName(clientLastName);
            client.setFirstName(clientName);

            return getControllerResultDto(req, clientName, clientLastName, client, clientService);

        } else {
            String clientFirstName = req.getParameter(ControllerConstant.CONTROLLER_CLIENT_NAME);
            String clientLastName = req.getParameter(ControllerConstant.CONTROLLER_CLIENT_LAST_NAME);
            req.getSession().setAttribute(ControllerConstant.CONTROLLER_CLIENT_NAME, clientFirstName);
            req.getSession().setAttribute(ControllerConstant.CONTROLLER_CLIENT_LAST_NAME, clientLastName);

            return new ControllerResultDto(ControllerConstant.CONTROLLER_PRODUCT_SUM, true);
        }
    }

    @NotNull
    private static ControllerResultDto getControllerResultDto(HttpServletRequest req, String clientName, String clientLastName, Client client, ClientService clientService) {
        req.getSession().setAttribute(ControllerConstant.CONTROLLER_CLIENT_NAME, clientName);
        req.getSession().setAttribute(ControllerConstant.CONTROLLER_CLIENT_LAST_NAME, clientLastName);

        try {
            clientService.create(client);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ControllerResultDto(ControllerConstant.CONTROLLER_PRODUCT_SUM, true);
    }
}
