package controller;

import entity.Client;
import service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

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

        req.getSession().setAttribute("clientName", clientName);
        req.getSession().setAttribute("clientLastName", clientLastName);

        try {
            clientService.create(client);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ControllerResultDto("productSum", true);
    }
}
