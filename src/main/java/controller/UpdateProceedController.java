package controller;

import annotation.CheckString;
import controller.constant.ControllerConstant;
import entity.User;
import entity.roles;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProceedController implements Controller {

    private UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        @CheckString
        String userName = req.getParameter(ControllerConstant.CONTROLLER_FIRST_NAME);
        @CheckString
        String userLastName = req.getParameter(ControllerConstant.CONTROLLER_LAST_NAME);
        @CheckString
        String userRole = req.getParameter(ControllerConstant.CONTROLLER_USER_ROLE);
        @CheckString
        String password = req.getParameter(ControllerConstant.CONTROLLER_PSW);
        @CheckString
        String oldEmail = req.getParameter(ControllerConstant.CONTROLLER_OLD_EMAIL);

        User user = new User();
        user.setFirstName(userName);
        user.setLastName(userLastName);
        user.setPassword(password);
        user.setUserRole(roles.valueOf(userRole));
        user.setEmail(oldEmail);
        userService.updateUser(user);

        req.setAttribute(ControllerConstant.CONTROLLER_USER, user);

        return new ControllerResultDto("userUpdated");
    }
}
