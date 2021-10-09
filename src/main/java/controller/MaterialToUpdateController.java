package controller;

import annotation.CheckString;
import controller.constant.ControllerConstant;
import entity.Material;
import service.MaterialService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaterialToUpdateController implements Controller {

    private MaterialService materialService = new MaterialService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        @CheckString
        String name = req.getParameter(ControllerConstant.CONTROLLER_MATERIAL_NAME);
        @CheckString
        String price = materialParsing(req, ControllerConstant.CONTROLLER_PRICE);
        @CheckString
        String colour = req.getParameter(ControllerConstant.CONTROLLER_COLOUR);
        @CheckString
        String type = req.getParameter(ControllerConstant.CONTROLLER_TYPE);
        @CheckString
        String quantity = req.getParameter(ControllerConstant.CONTROLLER_QUANTITY);

        Material material = new Material();
        Material materialOld = new Material();

        materialOld.setPrice(Integer.parseInt(req.getParameter(ControllerConstant.CONTROLLER_OLD_PRICE)));
        materialOld.setQuantity(Integer.parseInt(req.getParameter(ControllerConstant.CONTROLLER_OLD_QUANTITY)));
        materialOld.setMaterialName(req.getParameter(ControllerConstant.CONTROLLER_OLD_NAME));
        materialOld.setColour(req.getParameter(ControllerConstant.CONTROLLER_OLD_COLOUR));
        materialOld.setType(req.getParameter(ControllerConstant.CONTROLLER_OLD_TYPE));

        material.setType(type);
        material.setColour(colour);
        material.setMaterialName(name);
        material.setQuantity(Integer.parseInt(quantity));
        material.setPrice(Integer.parseInt(price));

        materialService.updateMaterial(material, materialService.getMaterialIDByName(materialOld));

        return new ControllerResultDto("materialUpdated");
    }

    private String materialParsing(HttpServletRequest req, String price) {
        return req.getParameter(price);
    }
}
