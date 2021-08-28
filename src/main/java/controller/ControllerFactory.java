package controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {

    private Map<String, Controller> controllerMap = new HashMap<>();

    private void init() {
        controllerMap.put("GET/profile", new ShowPageController("profile"));
        controllerMap.put("GET/administrator", new ShowPageController("administrator"));
        controllerMap.put("GET/admin", new ShowPageController("admin"));
        controllerMap.put("GET/contact", new ShowPageController("contact"));
        controllerMap.put("GET/login", new ShowPageController("login"));
        controllerMap.put("GET/list", new ShowPageController("list"));
        controllerMap.put("GET/updateUser", new ShowPageController("updateUser"));
        controllerMap.put("POST/login", new LoginController());
        controllerMap.put("POST/updateUser", new UpdateUserController());
        controllerMap.put("GET/updateProceed", new ShowPageController("updateProceed"));
        controllerMap.put("POST/updateProceed", new UpdateProceedController());
        controllerMap.put("GET/userUpdated", new ShowPageController("userUpdated"));
        controllerMap.put("GET/createMaterial", new ShowPageController("createMaterial"));
        controllerMap.put("GET/materialCreated", new ShowPageController("materialCreated"));
        controllerMap.put("POST/materialCreated", new MaterialCreatedController());
        controllerMap.put("POST/createMaterial", new CreateMaterialController());
        controllerMap.put("GET/updateMaterial", new ShowPageController("updateMaterial"));
        controllerMap.put("POST/updateMaterial", new UpdateMaterialController());
        controllerMap.put("POST/updateMaterialProceed", new UpdateMaterialProceedController());
        controllerMap.put("GET/deleteMaterial", new ShowDeleteMaterialController("deleteMaterial"));
        controllerMap.put("POST/deleteMaterial", new DeleteMaterialController());
        controllerMap.put("GET/materialUpdated", new ShowPageController("materialUpdated"));
        controllerMap.put("GET/orderCreated", new ShowPageController("orderCreated"));
        controllerMap.put("GET/updateMaterialProceed", new ShowPageController("updateMaterialProceed"));
        controllerMap.put("GET/seeAllMaterials", new ShowSeeAllMaterialsController("seeAllMaterials"));
        controllerMap.put("GET/materialToUpdate", new ShowSeeAllMaterialsController("materialToUpdate"));
        controllerMap.put("GET/productAdd", new ShowPageController("productAdd"));
        controllerMap.put("GET/createClient", new ShowPageController("createClient"));
        controllerMap.put("POST/materialToUpdate", new MaterialToUpdateController());
        controllerMap.put("POST/createClient", new ClientCreateController());
        controllerMap.put("POST/productAdd", new CreateNewProductController());
        controllerMap.put("GET/clientCreated", new ShowPageController("clientCreated"));
        controllerMap.put("GET/listOfClients", new ListOfClientsController("listOfClients"));
        controllerMap.put("GET/productCreated", new ShowPageController("productCreated"));
        controllerMap.put("GET/listOfProducts", new ListOfProductsController("listOfProducts"));
        controllerMap.put("GET/orderCreate", new ShowCreateOrderController("orderCreate"));
        controllerMap.put("POST/orderCreate", new OrderCreateController());
        controllerMap.put("GET/weather", new ShowPageController("weather"));
        controllerMap.put("POST/weather", new WeatherController());
        controllerMap.put("GET/post", new ShowPageController("post"));
        controllerMap.put("POST/post", new PostController());
        controllerMap.put("GET/updateProduct", new ShowPageController("updateProduct"));
        controllerMap.put("POST/updateProduct", new UpdateProductController());
        controllerMap.put("GET/productUpdateProceed", new ShowPageController("productUpdateProceed"));
        controllerMap.put("GET/deleteProduct", new ShowDeleteProductController("deleteProduct"));
        controllerMap.put("POST/deleteProduct", new DeleteProductController());
    }

    public Controller getController(HttpServletRequest request) {
        if (controllerMap.isEmpty()) {
            init();
        }
        return controllerMap.get(request.getMethod() + request.getPathInfo());
    }
}
