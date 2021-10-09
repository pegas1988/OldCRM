package controller;

import annotation.CheckString;
import controller.constant.ControllerConstant;
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

        @CheckString
        String userName = req.getParameter(ControllerConstant.CONTROLLER_FIRST_NAME);
        @CheckString
        String userLastName = req.getParameter(ControllerConstant.CONTROLLER_LAST_NAME);
        @CheckString
        String password = req.getParameter(ControllerConstant.CONTROLLER_PSW);

        User userFind = new User(userName, userLastName);
        User user = userService.findByFirstAndLastName(userFind);

        if (user.getPassword().equals(password)) {
            req.setAttribute(ControllerConstant.CONTROLLER_BUTTON, button);
            req.setAttribute("user", user);

            switch (user.getUserRole()) {
                case DESIGNER:
                    req.getSession().setAttribute(ControllerConstant.CONTROLLER_USER_ID, user.getUserID());
                    return new ControllerResultDto("designer");
                case DOCTOR:
                    req.getSession().setAttribute(ControllerConstant.CONTROLLER_USER_ID, user.getUserID());
                    return new ControllerResultDto("doctor");
                case ADMIN: {
                    req.getSession().setAttribute(ControllerConstant.CONTROLLER_USER_ID, user.getUserID());
                    req.getSession().setAttribute(ControllerConstant.CONTROLLER_BUTTON, createButton(button, "admin"));
                    return new ControllerResultDto("admin");
                }
                case ADMINISTRATOR: {
                    req.getSession().setAttribute(ControllerConstant.CONTROLLER_USER_ID, user.getUserID());
                    req.getSession().setAttribute(ControllerConstant.CONTROLLER_BUTTON, createButton(button, "administrator"));
                    return new ControllerResultDto("administrator");
                }
                default:
                    return new ControllerResultDto("error-403");
            }
        } else
            return new ControllerResultDto("error-403");
    }
}