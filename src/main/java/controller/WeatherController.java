package controller;

import entity.WeatherAPI;
import service.WeatherMainClassAPI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeatherController implements Controller {
    WeatherMainClassAPI weatherMainClassAPI = new WeatherMainClassAPI();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String city = req.getParameter("city");
        WeatherAPI weather = weatherMainClassAPI.myAPI(city);
        req.setAttribute("city", city);
        req.setAttribute("temp", weather.getMain().getTemp());
        req.setAttribute("fillTemp", weather.getMain().getFeels_like());
        req.setAttribute("pressure", weather.getMain().getPressure());
        req.setAttribute("windSpeed", weather.getWind().getSpeed());
        req.setAttribute("weatherType", weather.getWeather().get(0).getDescription());
        return new ControllerResultDto("weatherToShow");
    }
}
