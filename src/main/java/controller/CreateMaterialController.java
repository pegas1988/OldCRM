package controller;

import annotation.CheckString;
import controller.constant.ControllerConstant;
import entity.Material;
import org.jetbrains.annotations.NotNull;
import service.MaterialService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateMaterialController implements Controller {

    private MaterialService materialService = new MaterialService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        return getControllerResultDto(req, materialService);

    }

    @NotNull
    private static ControllerResultDto getControllerResultDto(HttpServletRequest req, MaterialService materialService) {
        @CheckString
        String name = req.getParameter(ControllerConstant.CONTROLLER_MATERIAL_NAME);
        @CheckString
        String quantity = req.getParameter(ControllerConstant.CONTROLLER_QUANTITY);
        @CheckString
        String colour = req.getParameter(ControllerConstant.CONTROLLER_COLOUR);
        @CheckString
        String type = req.getParameter(ControllerConstant.CONTROLLER_TYPE);
        @CheckString
        String price = req.getParameter(ControllerConstant.CONTROLLER_PRICE);

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
