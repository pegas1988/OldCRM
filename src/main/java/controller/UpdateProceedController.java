package controller;

import entity.User;
import entity.roles;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProceedController implements Controller {
    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        String userName = req.getParameter("firstName");
        String userLastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String userRole = req.getParameter("userRole");
        String password = req.getParameter("psw");
        User user = new User();
        user.setEmail(email);
        user.setFirstName(userName);
        user.setLastName(userLastName);
        user.setPassword(password);
        user.setUserRole(roles.valueOf(userRole));
        // here will be logic of user update in DAo layer
        return new ControllerResultDto("userUpdated");
    }
}
