package controller;

import entity.Button;
import entity.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {

    private UserService userService = new UserService();

    private String createButton(Button button, String buttonName) {
        button.setButtonForNavbar(buttonName);
        return button.getButtonForNavbar();
    }

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        Button button = new Button();

        String userName = req.getParameter("firstName");
        String userLastName = req.getParameter("lastName");
        String password = req.getParameter("psw");

        User userFind = new User(userName, userLastName);
        User user = userService.findByFirstAndLastName(userFind);

        if (user.getPassword().equals(password)) {
            req.setAttribute("button", button);
            req.setAttribute("user", user);

            switch (user.getUserRole()) {
                case DESIGNER:
                    req.getSession().setAttribute("UserId", user.getUserID());
                    return new ControllerResultDto("designer");
                case DOCTOR:
                    req.getSession().setAttribute("UserId", user.getUserID());
                    return new ControllerResultDto("doctor");
                case ADMIN: {
                    req.getSession().setAttribute("UserId", user.getUserID());
                    req.getSession().setAttribute("button", createButton(button, "admin"));
                    return new ControllerResultDto("admin");
                }
                case ADMINISTRATOR: {
                    req.getSession().setAttribute("UserId", user.getUserID());
                    req.getSession().setAttribute("button", createButton(button, "administrator"));
                    return new ControllerResultDto("administrator");
                }
                default:
                    return new ControllerResultDto("error-403");
            }
        } else
            return new ControllerResultDto("error-403");
    }
}