package se.nackademin.java20.lab1.regeringen;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RestRegeringClientTest {

    @Test
    void canFetchAnforanden() {
        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = new String("https://data.riksdagen.se/");
        RegeringClient restRegeringClient = new RestRegeringClient(restTemplate, baseUrl);

        List<Anforande> anforandes = restRegeringClient.fetchAnforanden();
        Assertions.assertEquals(anforandes.size(), 10);
    }


    private final String json = "{\"djur\":\"katt\"}";

    public static class Animal {
        private String djur;

        public void setDjur(String djur) {
            this.djur = djur;
        }

        public String getDjur() {
            return djur;
        }
    }

    @Test
    void deserialize() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Animal animal = objectMapper.readValue(json, Animal.class);

        Assertions.assertEquals(animal.getDjur(), "katt");
    }

    @Test
    void serialize() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Animal katt = new Animal();
        katt.setDjur("katt");

        String jsonObject = objectMapper.writeValueAsString(katt);
        System.out.println(jsonObject);
        Assertions.assertEquals(json, jsonObject);
    }

    @Test
    void rest() {
        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8080/risk/dan", String.class);
        // Status code 200 OK
        // Body json, html, text, ...

        System.out.println(forEntity.getStatusCode());
        System.out.println(forEntity.getBody());
    }

}