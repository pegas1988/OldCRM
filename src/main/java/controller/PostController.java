package controller;

import annotation.CheckString;
import controller.constant.ControllerConstant;
import entity.Poshta.PoshtaResponseFinal;
import service.PoshtaMainClass;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostController implements Controller {

    private PoshtaMainClass poshtaMainClass = new PoshtaMainClass();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        @CheckString
        String phone = req.getParameter(ControllerConstant.CONTROLLER_PHONE_NUMBER);
        @CheckString
        String ttn = req.getParameter(ControllerConstant.CONTROLLER_TTN_NUMBER);

        PoshtaResponseFinal poshtaResponseFinal = poshtaMainClass.poshtaMainClass(phone, ttn);

        req.setAttribute(ControllerConstant.CONTROLLER_CITY, poshtaResponseFinal.getData().get(0).getCityRecipient());
        req.setAttribute(ControllerConstant.CONTROLLER_DATE_CREATED, poshtaResponseFinal.getData().get(0).getDateCreated());
        req.setAttribute(ControllerConstant.CONTROLLER_FIO, poshtaResponseFinal.getData().get(0).getRecipientFullName());
        req.setAttribute(ControllerConstant.CONTROLLER_COST, poshtaResponseFinal.getData().get(0).getDocumentCost());
        req.setAttribute(ControllerConstant.CONTROLLER_WEIGHT, poshtaResponseFinal.getData().get(0).getDocumentWeight());
        req.setAttribute(ControllerConstant.CONTROLLER_DELIVERY_DATE, poshtaResponseFinal.getData().get(0).getScheduledDeliveryDate());

        return new ControllerResultDto("postToShow");
    }
}
