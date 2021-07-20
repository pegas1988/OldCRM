package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Poshta.*;

import java.util.ArrayList;
import java.util.List;

public class SerializationPoshta {

    public String serialization(String phoneNumber, String ttnCode) {
        ObjectMapper objectMapper = new ObjectMapper();

        Documents Documents = new Documents();
        Documents.setPhoneNumber(phoneNumber);
        Documents.setTtnCode(ttnCode);

        List<Documents> list = new ArrayList<>();
        list.add(Documents);
        list.add(Documents);
        MethodProperties methodProperties = new MethodProperties(list);

        PoshtaMainEntity poshtaMainEntity = new PoshtaMainEntity("TrackingDocument", "getStatusDocuments", methodProperties);
        String json = null;
        try {
            json = objectMapper.writeValueAsString(poshtaMainEntity);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }


}

