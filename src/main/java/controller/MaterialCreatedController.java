package controller;

import entity.Material;
import service.MaterialService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaterialCreatedController implements Controller {
    MaterialService materialService = new MaterialService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("materialName");
        String quantity = req.getParameter("quantity");
        String colour = req.getParameter("colour");
        String type = req.getParameter("type");
        String price = req.getParameter("price");

        Material material = new Material();
        material.setColour(colour);
        material.setMaterialName(name);
        material.setPrice(Integer.parseInt(price));
        material.setQuantity(Integer.parseInt(quantity));
        material.setType(type);
        materialService.createMaterial(material);

        return new ControllerResultDto("materialCreated", true);

    }
}