package controller;

import entity.Material;
import service.MaterialService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UpdateMaterialController implements Controller {
    MaterialService materialService = new MaterialService();
    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String type = req.getParameter("type");
        List<Material> list = materialService.findByType(type);
        req.getSession().setAttribute("list", list);
        return new ControllerResultDto("updateMaterialProceed", true);
    }
}
