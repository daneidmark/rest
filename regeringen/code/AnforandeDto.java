package se.nackademin.java20.lab1.regeringen;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnforandeDto {

    private final String dokId;

    @JsonCreator
    public AnforandeDto(@JsonProperty("dok_id") String dokId) {
        this.dokId = dokId;
    }

    public String getDokId() {
        return dokId;
    }
}
