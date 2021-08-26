package se.nackademin.java20.lab1.regeringen;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnforandeListaDto {
    private final List<AnforandeDto> anforande;

    @JsonCreator
    public AnforandeListaDto(@JsonProperty("anforande") List<AnforandeDto> anforande) {
        this.anforande = anforande;
    }

    public List<AnforandeDto> getAnforande() {
        return anforande;
    }
}
