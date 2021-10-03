package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Poshta.PoshtaResponseFinal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PoshtaMainClass {

    public PoshtaResponseFinal poshtaMainClass(String phone, String ttn) throws JsonProcessingException {
        SerializationPoshta serializationPoshta = new SerializationPoshta();
        String jsonTemp = serializationPoshta.serialization(phone, ttn);

        RestTemplate restTemplate = new RestTemplate();
        System.out.println(jsonTemp);

        ResponseEntity<String> poshtaResponse = restTemplate.postForEntity("https://api.novaposhta.ua/v2.0/json/",
                jsonTemp, String.class);
        String body = poshtaResponse.getBody();
        System.out.println(body);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(body, PoshtaResponseFinal.class);
    }
}
