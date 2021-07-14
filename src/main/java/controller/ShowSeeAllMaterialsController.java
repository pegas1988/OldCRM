package controller;

import entity.Material;
import service.MaterialService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowSeeAllMaterialsController implements Controller {
    private final String VIEW_NAME;
    private MaterialService materialService = new MaterialService();


    public ShowSeeAllMaterialsController(String VIEW_NAME) {
        this.VIEW_NAME = VIEW_NAME;
    }

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        List<Material> materials = materialService.findAllMaterials();
        req.setAttribute("list" , materials);
        return new ControllerResultDto(VIEW_NAME);
    }
}