package se.nackademin.java20.lab1.regeringen;

import org.junit.jupiter.api.Test;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AnforandeDtoTest {
    private static final String json = "{\n" +
            "        \"dok_hangar_id\": \"5102781\",\n" +
            "        \"dok_id\": \"H809153\",\n" +
            "        \"dok_titel\": \"Protokoll 2020/21:153 Fredagen den 9 juli\",\n" +
            "        \"dok_rm\": \"2020/21\",\n" +
            "        \"dok_nummer\": \"153\",\n" +
            "        \"dok_datum\": \"2021-07-09\",\n" +
            "        \"avsnittsrubrik\": \"Avtackning\",\n" +
            "        \"underrubrik\": \"\",\n" +
            "        \"kammaraktivitet\": \"\",\n" +
            "        \"anforande_id\": \"cc1604d7-aae0-eb11-9153-901b0eac4c78\",\n" +
            "        \"anforande_nummer\": \"2\",\n" +
            "        \"talare\": \"TALMANNEN\",\n" +
            "        \"parti\": \"TALMANNEN\",\n" +
            "        \"anforandetext\": \"\",\n" +
            "        \"intressent_id\": \"\",\n" +
            "        \"rel_dok_id\": \"\",\n" +
            "        \"replik\": \"N\",\n" +
            "        \"systemdatum\": \"2021-07-09 13:43:46\",\n" +
            "        \"systemnyckel\": \"518129\",\n" +
            "        \"anforande_url_xml\": \"http://data.riksdagen.se/anforande/H809153-2\",\n" +
            "        \"anforande_url_html\": \"http://data.riksdagen.se/anforande/H809153-2/html\",\n" +
            "        \"protokoll_url_www\": \"http://www.riksdagen.se/sv/Dokument-Lagar/Kammaren/Protokoll/Riksdagens-snabbprotokoll_H809153/#anf2\"\n" +
            "      }";

    @Test
    void canSerialize() throws IOException {
        AnforandeDto anforandeDto = new ObjectMapper().readValue(json, AnforandeDto.class);
        Assertions.assertEquals(anforandeDto.getDokId(), "H809153");
    }
}