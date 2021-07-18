package entity.weatherEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Coord {
    private double lat;
    private double lon;

    public double getLat() {
        return lat;
    }

    public Coord() {
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @JsonCreator
    public Coord(@JsonProperty("lat") double lat, @JsonProperty("lon") double lon) {
        this.lat = lat;
        this.lon = lon;
    }
}
