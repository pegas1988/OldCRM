package controller;

import annotation.CheckString;
import controller.constant.ControllerConstant;
import entity.WeatherAPI;
import service.WeatherMainClassAPI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WeatherController implements Controller {

    private WeatherMainClassAPI weatherMainClassAPI = new WeatherMainClassAPI();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        @CheckString
        String city = req.getParameter(ControllerConstant.CONTROLLER_CITY);
        WeatherAPI weather = weatherMainClassAPI.myAPI(city);

        req.setAttribute(ControllerConstant.CONTROLLER_CITY, city);
        req.setAttribute(ControllerConstant.CONTROLLER_TEMP, (int) (weather.getMain().getTemp() - 273));
        req.setAttribute(ControllerConstant.CONTROLLER_FILL_TEMP, (int) (weather.getMain().getFeels_like() - 273));
        req.setAttribute(ControllerConstant.CONTROLLER_PRESSURE, weather.getMain().getPressure());
        req.setAttribute(ControllerConstant.CONTROLLER_WIND_SPEED, weather.getWind().getSpeed());
        req.setAttribute(ControllerConstant.CONTROLLER_WEATHER_TYPE, weather.getWeather().get(0).getDescription());

        return new ControllerResultDto("weatherToShow");
    }
}
