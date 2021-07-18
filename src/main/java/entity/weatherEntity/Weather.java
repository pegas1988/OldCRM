package entity.weatherEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Weather {
    public Weather() {
    }

    private String description;
    private String main;
    private Long id;
    private String icon;

    @JsonCreator
    public Weather(@JsonProperty("description") String description,
                   @JsonProperty("main") String main,
                   @JsonProperty("id") Long id,
                   @JsonProperty("icon") String icon) {
        this.description = description;
        this.main = main;
        this.id = id;
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

//    @JsonCreator
//    public Weather(@JsonProperty("description") String description, @JsonProperty("main") String main) {
//        this.description = description;
//        this.main = main;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }
}
