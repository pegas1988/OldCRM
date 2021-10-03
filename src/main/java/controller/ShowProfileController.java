package controller;

import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowProfileController implements Controller {
    private UserService userService;

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
}