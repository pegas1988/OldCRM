package controller;

import entity.Material;
import service.MaterialService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateMaterialProceedController implements Controller {

    MaterialService materialService = new MaterialService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("materialName");
        String price = req.getParameter("price");
        String colour = req.getParameter("colour");
        String type = req.getParameter("type");
        String quantity = req.getParameter("quantity");
        Material material = new Material();
        material.setType(type);
        material.setColour(colour);
        material.setMaterialName(name);
        material.setQuantity(Integer.parseInt(quantity));
        material.setPrice(Integer.parseInt(price));
        req.getSession().setAttribute("material", material);
        return new ControllerResultDto("materialToUpdate", true);
    }
}
