package service;

import controller.Controller;
import controller.ControllerResultDto;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserController implements Controller {
    UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        User userFind = new User(email);
        User user = userService.findByEmail(userFind);
        System.out.println();
        req.setAttribute("user", user);
        return new ControllerResultDto("updateProceed");
    }
}
