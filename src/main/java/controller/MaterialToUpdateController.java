package controller;

import entity.Material;
import service.MaterialService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MaterialToUpdateController implements Controller {

    MaterialService materialService = new MaterialService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("materialName");
        String price = req.getParameter("price");
        String colour = req.getParameter("colour");
        String type = req.getParameter("type");
        String quantity = req.getParameter("quantity");

        Material material = new Material();
        Material materialOld = new Material();

        materialOld.setPrice(Integer.parseInt(req.getParameter("oldPrice")));
        materialOld.setQuantity(Integer.parseInt(req.getParameter("oldQuantity")));
        materialOld.setMaterialName(req.getParameter("oldName"));
        materialOld.setColour(req.getParameter("oldColour"));
        materialOld.setType(req.getParameter("oldType"));

        material.setType(type);
        material.setColour(colour);
        material.setMaterialName(name);
        material.setQuantity(Integer.parseInt(quantity));
        material.setPrice(Integer.parseInt(price));

        materialService.updateMaterial(material, materialService.getMaterialIDByName(materialOld));

        return new ControllerResultDto("materialUpdated");
    }
}
