package controller;

import entity.User;
import entity.roles;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProceedController implements Controller {

    UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        String userName = req.getParameter("firstName");
        String userLastName = req.getParameter("lastName");
        String userRole = req.getParameter("userRole");
        String password = req.getParameter("psw");
        String oldEmail = req.getParameter("oldEmail");

        User user = new User();
        user.setFirstName(userName);
        user.setLastName(userLastName);
        user.setPassword(password);
        user.setUserRole(roles.valueOf(userRole));
        user.setEmail(oldEmail);
        userService.updateUser(user);

        req.setAttribute("user", user);

        return new ControllerResultDto("userUpdated");
    }
}
