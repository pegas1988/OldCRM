package entity.Poshta;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PoshtaResponse {

    @JsonProperty("DateCreated")
    private String DateCreated;

    @JsonProperty("DocumentWeight")
    private String DocumentWeight;

    @JsonProperty("DocumentCost")
    private String DocumentCost;

    @JsonProperty("RecipientFullName")
    private String RecipientFullName;

    @JsonProperty("ScheduledDeliveryDate")
    private String ScheduledDeliveryDate;

    @JsonProperty("CityRecipient")
    private String CityRecipient;

    public String getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(String dateCreated) {
        DateCreated = dateCreated;
    }

    public String getDocumentWeight() {
        return DocumentWeight;
    }

    public void setDocumentWeight(String documentWeight) {
        DocumentWeight = documentWeight;
    }

    public String getDocumentCost() {
        return DocumentCost;
    }

    public void setDocumentCost(String documentCost) {
        DocumentCost = documentCost;
    }

    public String getRecipientFullName() {
        return RecipientFullName;
    }

    public void setRecipientFullName(String recipientFullName) {
        RecipientFullName = recipientFullName;
    }

    public String getScheduledDeliveryDate() {
        return ScheduledDeliveryDate;
    }

    public void setScheduledDeliveryDate(String scheduledDeliveryDate) {
        ScheduledDeliveryDate = scheduledDeliveryDate;
    }

    public String getCityRecipient() {
        return CityRecipient;
    }

    public void setCityRecipient(String cityRecipient) {
        CityRecipient = cityRecipient;
    }

    @JsonCreator
    public PoshtaResponse(@JsonProperty("DateCreated")String dateCreated,
                          @JsonProperty("DocumentWeight")String documentWeight,
                          @JsonProperty("DocumentCost")String documentCost,
                          @JsonProperty("RecipientFullName")String recipientFullName,
                          @JsonProperty("ScheduledDeliveryDate")String scheduledDeliveryDate,
                          @JsonProperty("CityRecipient")String cityRecipient) {
        DateCreated = dateCreated;
        DocumentWeight = documentWeight;
        DocumentCost = documentCost;
        RecipientFullName = recipientFullName;
        ScheduledDeliveryDate = scheduledDeliveryDate;
        CityRecipient = cityRecipient;
    }
}
