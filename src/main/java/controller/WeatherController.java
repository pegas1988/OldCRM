package controller;

import entity.WeatherAPI;
import service.WeatherMainClassAPI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WeatherController implements Controller {
    WeatherMainClassAPI weatherMainClassAPI = new WeatherMainClassAPI();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String city = req.getParameter("city");
        WeatherAPI weather = weatherMainClassAPI.myAPI(city);

        req.setAttribute("city", city);
        req.setAttribute("temp", (int) (weather.getMain().getTemp() - 273));
        req.setAttribute("fillTemp", (int) (weather.getMain().getFeels_like() - 273));
        req.setAttribute("pressure", weather.getMain().getPressure());
        req.setAttribute("windSpeed", weather.getWind().getSpeed());
        req.setAttribute("weatherType", weather.getWeather().get(0).getDescription());

        return new ControllerResultDto("weatherToShow");
    }
}
