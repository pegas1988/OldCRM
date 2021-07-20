package entity.Poshta;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTtnCode() {
        return ttnCode;
    }

    public void setTtnCode(String ttnCode) {
        this.ttnCode = ttnCode;
    }
}