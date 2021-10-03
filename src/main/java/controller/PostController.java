package controller;

import entity.Poshta.PoshtaResponseFinal;
import service.PoshtaMainClass;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostController implements Controller {

    PoshtaMainClass poshtaMainClass = new PoshtaMainClass();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String phone = req.getParameter("phoneNumber");
        String ttn = req.getParameter("ttnNumber");

        PoshtaResponseFinal poshtaResponseFinal = poshtaMainClass.poshtaMainClass(phone, ttn);

        req.setAttribute("city", poshtaResponseFinal.getData().get(0).getCityRecipient());
        req.setAttribute("dateCreated", poshtaResponseFinal.getData().get(0).getDateCreated());
        req.setAttribute("fio", poshtaResponseFinal.getData().get(0).getRecipientFullName());
        req.setAttribute("cost", poshtaResponseFinal.getData().get(0).getDocumentCost());
        req.setAttribute("weight", poshtaResponseFinal.getData().get(0).getDocumentWeight());
        req.setAttribute("deliveryDate", poshtaResponseFinal.getData().get(0).getScheduledDeliveryDate());

        return new ControllerResultDto("postToShow");
    }
}
