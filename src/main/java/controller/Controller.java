package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This is the main controller interface to extend
 */
public interface Controller{
    ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
