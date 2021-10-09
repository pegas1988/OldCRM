package controller;

import annotation.CheckString;
import controller.constant.ControllerConstant;
import entity.Material;
import service.MaterialService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteMaterialController implements Controller {

    private MaterialService materialService = new MaterialService();

    @Override

    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        @CheckString
        String name = req.getParameter(ControllerConstant.CONTROLLER_MATERIAL_NAME);

        Material material = new Material();
        material.setMaterialName(name);
        materialService.deleteFromMaterial(material);

        req.getSession().setAttribute(ControllerConstant.CONTROLLER_MATERIAL, material);

        return new ControllerResultDto("deleteMaterial", true);

    }
}
