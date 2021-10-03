package servlet;

import entity.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ShowListOfUsersServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> listOfUsers = userService.findAllUsers();
        req.setAttribute("list", listOfUsers);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/list2.jsp");
        requestDispatcher.forward(req, resp);
    }
}
