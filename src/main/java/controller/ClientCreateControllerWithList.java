package controller;

import entity.Client;
import service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ClientCreateControllerWithList implements Controller {

    ClientService clientService = new ClientService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getParameter("addClient") != null) {
            String clientName = req.getParameter("clientName");
            String clientLastName = req.getParameter("clientLastName");
            String gender = req.getParameter("gender");

            Client client = new Client();
            client.setSex(gender);
            client.setLastName(clientLastName);
            client.setFirstName(clientName);

            req.getSession().setAttribute("clientFirstName", clientName);
            req.getSession().setAttribute("clientLastName", clientLastName);

            try {
                clientService.create(client);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return new ControllerResultDto("productSum", true);

        } else {
            String clientFirstName = req.getParameter("clientFirstName");
            String clientLastName = req.getParameter("clientLastName");
            req.getSession().setAttribute("clientFirstName", clientFirstName);
            req.getSession().setAttribute("clientLastName", clientLastName);

            return new ControllerResultDto("productSum", true);
        }
    }
}
