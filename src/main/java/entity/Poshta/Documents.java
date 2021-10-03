package entity.Poshta;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class:
 * - annotated with jackson annotations to map json request/response
 * - describe entity document
 * - sub entity
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Documents {

    @JsonProperty("Phone")
    private String phoneNumber;

    @JsonProperty("DocumentNumber")
    private String ttnCode;

    @JsonCreator
    public Documents(
            @JsonProperty("DocumentNumber") String ttnCode,
            @JsonProperty("Phone") String phoneNumber
    ) {
        this.phoneNumber = phoneNumber;
        this.ttnCode = ttnCode;
    }

    public Documents() {
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setTtnCode(String ttnCode) {
        this.ttnCode = ttnCode;
    }
}