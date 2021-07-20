package entity.Poshta;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PoshtaResponseFinal {

    @JsonProperty("data")
    private List<PoshtaResponse> data;

    public List<PoshtaResponse> getData() {
        return data;
    }

    public void setData(List<PoshtaResponse> data) {
        this.data = data;
    }

    @JsonCreator
    public PoshtaResponseFinal(@JsonProperty("data")List<PoshtaResponse> data) {
        this.data = data;
    }
}
