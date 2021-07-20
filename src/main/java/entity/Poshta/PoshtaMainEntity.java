package entity.Poshta;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PoshtaMainEntity {

    @JsonProperty("calledMethod")
    private String calledM;

    @JsonProperty("methodProperties")
    private MethodProperties methodProperties;

    @JsonProperty("modelName")
    private String modelN;

    @JsonCreator
    public PoshtaMainEntity(@JsonProperty("modelName") String modelN,
                            @JsonProperty("calledMethod") String calledM,
                            @JsonProperty("methodProperties") MethodProperties methodProperties) {
        this.calledM = calledM;
        this.methodProperties = methodProperties;
        this.modelN = modelN;
    }

    public String getCalledM() {
        return calledM;
    }

    public void setCalledM(String calledM) {
        this.calledM = calledM;
    }

    public MethodProperties getMethodProperties() {
        return methodProperties;
    }

    public void setMethodProperties(MethodProperties methodProperties) {
        this.methodProperties = methodProperties;
    }

    public String getModelN() {
        return modelN;
    }

    public void setModelN(String modelN) {
        this.modelN = modelN;
    }
}
