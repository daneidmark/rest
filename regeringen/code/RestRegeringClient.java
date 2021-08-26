package se.nackademin.java20.lab1.regeringen;

import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

public class RestRegeringClient implements RegeringClient {
    private final RestTemplate restTemplate;
    private final String baseUrl;

    private static final String path = "/anforandelista/?utformat=json&anftyp=Nej&sz=10";

    public RestRegeringClient(RestTemplate restTemplate, String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    /**
     *
     *  [Vår app] -> [regeringen]
     */
    @Override
    public List<Anforande> fetchAnforanden() {
        return restTemplate.getForEntity(baseUrl + path, AnforandeResponseDto.class)
                .getBody().getAnforandeLista().getAnforande()
                .stream()
                .map(dto -> new Anforande(dto.getDokId()))
                .collect(Collectors.toList());
    }
}
