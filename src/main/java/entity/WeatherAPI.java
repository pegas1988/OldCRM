package entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import entity.weatherEntity.Coord;
import entity.weatherEntity.Main;
import entity.weatherEntity.Weather;
import entity.weatherEntity.Wind;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherAPI {

    @JsonProperty("coord")
    private Coord coord;

    @JsonProperty("wind")
    private Wind wind;

    @JsonProperty("main")
    private Main main;

    @JsonProperty("weather")
    private List<Weather> weather;

    @JsonCreator
    public WeatherAPI(@JsonProperty("coord") Coord coord,
                      @JsonProperty("wind") Wind wind,
                      @JsonProperty("main") Main main,
                      @JsonProperty("weather") List<Weather> weather) {
        this.coord = coord;
        this.wind = wind;
        this.main = main;
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

}
