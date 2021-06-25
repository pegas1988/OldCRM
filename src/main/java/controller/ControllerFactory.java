package controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {

    private Map<String, Controller> controllerMap = new HashMap<>();

    private void init() {
        controllerMap.put("GET/profile", new ShowPageController("profile"));
        controllerMap.put("GET/login", new ShowPageController("login"));
        controllerMap.put("GET/list", new ShowPageController("list"));
        controllerMap.put("GET/updateUser", new ShowPageController("updateUser"));
        controllerMap.put("POST/login", new LoginController());
        controllerMap.put("POST/updateUser", new UpdateUserController());
        controllerMap.put("GET/updateProceed", new ShowPageController("updateProceed"));
        controllerMap.put("POST/updateProceed", new UpdateProceedController());
        controllerMap.put("GET/userUpdated", new ShowPageController("userUpdated"));
        controllerMap.put("GET/userDelete", new ShowPageController("userDelete"));
        controllerMap.put("POST/userDelete", new DeleteUserController());
    }

    public Controller getController(HttpServletRequest request) {
        if (controllerMap.isEmpty()) {
            init();
        }
        return controllerMap.get(request.getMethod() + request.getPathInfo());
    }
}
