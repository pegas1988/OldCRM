package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.WeatherAPI;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WeatherMainClassAPI {

    public WeatherAPI myAPI(String city) throws IOException {
        String hardFirst = "https://api.openweathermap.org/data/2.5/weather?q=";
        String hardSecond = "&APPID=2d2efdcc1ce6af9c07092733ddecd5d3";

        StringBuilder stringBuilder = new StringBuilder(hardFirst);
        stringBuilder.append(city).append(hardSecond);

        URL url = new URL(stringBuilder.toString());
        Scanner sc = new Scanner(url.openStream());
        StringBuffer sb = new StringBuffer();

        while (sc.hasNext()) {
            sb.append(sc.next());
        }

        String result = sb.toString();
        result.replaceAll("<[^>]*>", "");

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(result, entity.WeatherAPI.class);
    }

}
