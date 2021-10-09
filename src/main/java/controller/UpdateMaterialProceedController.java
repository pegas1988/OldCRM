package controller;

import annotation.CheckString;
import controller.constant.ControllerConstant;
import entity.Material;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateMaterialProceedController implements Controller {

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        @CheckString
        String name = req.getParameter(ControllerConstant.CONTROLLER_MATERIAL_NAME);
        @CheckString
        String price = req.getParameter(ControllerConstant.CONTROLLER_PRICE);
        @CheckString
        String colour = req.getParameter(ControllerConstant.CONTROLLER_COLOUR);
        @CheckString
        String type = req.getParameter(ControllerConstant.CONTROLLER_TYPE);
        @CheckString
        String quantity = req.getParameter(ControllerConstant.CONTROLLER_QUANTITY);

        Material material = new Material();
        material.setType(type);
        material.setColour(colour);
        material.setMaterialName(name);
        material.setQuantity(Integer.parseInt(quantity));
        material.setPrice(Integer.parseInt(price));

        req.getSession().setAttribute(ControllerConstant.CONTROLLER_MATERIAL, material);

        return new ControllerResultDto("materialToUpdate", true);
    }
}
