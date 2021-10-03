package entity.Poshta;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * This class:
 * - annotated with jackson annotations to map json request/response
 * - describe entity method properties
 * - sub entity
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MethodProperties {

    @JsonProperty("Documents")
    private List<Documents> Documents;

    @JsonCreator
    public MethodProperties(@JsonProperty("Documents") List<Documents> Documents) {
        this.Documents = Documents;
    }
}
