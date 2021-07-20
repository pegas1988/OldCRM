package entity.Poshta;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MethodProperties {

    @JsonProperty("Documents")
    private List<Documents> Documents;

    public List<Documents> getDocuments() {
        return Documents;
    }

    public void setDocuments(List<Documents> Documents) {
        this.Documents = Documents;
    }

    @JsonCreator
    public MethodProperties(@JsonProperty("Documents") List<Documents> Documents) {
        this.Documents = Documents;
    }
}
