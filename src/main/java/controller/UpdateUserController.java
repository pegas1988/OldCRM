package controller;

import annotation.CheckString;
import controller.constant.ControllerConstant;
import entity.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserController implements Controller {
    UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        @CheckString
        String email = req.getParameter(ControllerConstant.CONTROLLER_EMAIL);

        User userFind = new User(email);
        User user = userService.findByEmail(userFind);

        req.getSession().setAttribute(ControllerConstant.CONTROLLER_USER, user);

        return new ControllerResultDto("updateProceed", true);
    }
}
