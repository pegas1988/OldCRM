package controller;

import annotation.CheckString;
import controller.constant.ControllerConstant;
import entity.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUserController implements Controller {
    UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        @CheckString
        String firstName = req.getParameter(ControllerConstant.CONTROLLER_FIRST_NAME);
        @CheckString
        String lastName = req.getParameter(ControllerConstant.CONTROLLER_LAST_NAME);

        User user = new User(firstName, lastName);
        userService.deleteFromUser(user);

        return new ControllerResultDto("userdelete", true);
    }
}
