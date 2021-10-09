package controller;

import annotation.CheckString;
import controller.constant.ControllerConstant;
import entity.Material;
import service.MaterialService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UpdateMaterialController implements Controller {

    private MaterialService materialService = new MaterialService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        @CheckString
        String type = req.getParameter(ControllerConstant.CONTROLLER_TYPE);
        List<Material> list = materialService.findByType(type);
        req.getSession().setAttribute(ControllerConstant.CONTROLLER_LIST, list);
        return new ControllerResultDto("updateMaterialProceed", true);
    }
}
