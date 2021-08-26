package se.nackademin.java20.lab1.regeringen;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnforandeResponseDto {
    private final AnforandeListaDto anforandeLista;

    @JsonCreator
    public AnforandeResponseDto(@JsonProperty("anforandelista") AnforandeListaDto anforandeLista) {
        this.anforandeLista = anforandeLista;
    }

    public AnforandeListaDto getAnforandeLista() {
        return anforandeLista;
    }
}
