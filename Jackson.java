import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import se.nackademin.java20.lab1.regeringen.RestRegeringClientTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Jackson {
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
        RestRegeringClientTest.Animal animal = objectMapper.readValue(json, RestRegeringClientTest.Animal.class);

        assertEquals(animal.getDjur(), "katt");
    }

    @Test
    void serialize() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        RestRegeringClientTest.Animal katt = new RestRegeringClientTest.Animal();
        katt.setDjur("katt");

        String jsonObject = objectMapper.writeValueAsString(katt);
        System.out.println(jsonObject);
        assertEquals(json, jsonObject);
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
