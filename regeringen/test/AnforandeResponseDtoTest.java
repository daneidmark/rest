package se.nackademin.java20.lab1.regeringen;

import org.junit.jupiter.api.Test;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AnforandeResponseDtoTest {
    private static final String json = "{\n" +
            "  \"anforandelista\": {\n" +
            "    \"@antal\": \"10\",\n" +
            "    \"anforande\": [\n" +
            "      {\n" +
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
            "      },\n" +
            "      {\n" +
            "        \"dok_hangar_id\": \"5102781\",\n" +
            "        \"dok_id\": \"H809153\",\n" +
            "        \"dok_titel\": \"Protokoll 2020/21:153 Fredagen den 9 juli\",\n" +
            "        \"dok_rm\": \"2020/21\",\n" +
            "        \"dok_nummer\": \"153\",\n" +
            "        \"dok_datum\": \"2021-07-09\",\n" +
            "        \"avsnittsrubrik\": \"Anmälan om utsedda statsråd\",\n" +
            "        \"underrubrik\": \"\",\n" +
            "        \"kammaraktivitet\": \"\",\n" +
            "        \"anforande_id\": \"c61604d7-aae0-eb11-9153-901b0eac4c78\",\n" +
            "        \"anforande_nummer\": \"1\",\n" +
            "        \"talare\": \"Statsministern Stefan Löfven (S)\",\n" +
            "        \"parti\": \"S\",\n" +
            "        \"anforandetext\": \"\",\n" +
            "        \"intressent_id\": \"0218878014918\",\n" +
            "        \"rel_dok_id\": \"\",\n" +
            "        \"replik\": \"N\",\n" +
            "        \"systemdatum\": \"2021-07-09 13:43:39\",\n" +
            "        \"systemnyckel\": \"518128\",\n" +
            "        \"anforande_url_xml\": \"http://data.riksdagen.se/anforande/H809153-1\",\n" +
            "        \"anforande_url_html\": \"http://data.riksdagen.se/anforande/H809153-1/html\",\n" +
            "        \"protokoll_url_www\": \"http://www.riksdagen.se/sv/Dokument-Lagar/Kammaren/Protokoll/Riksdagens-snabbprotokoll_H809153/#anf1\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"dok_hangar_id\": \"5102740\",\n" +
            "        \"dok_id\": \"H809152\",\n" +
            "        \"dok_titel\": \"Protokoll 2020/21:152 Onsdagen den 7 juli\",\n" +
            "        \"dok_rm\": \"2020/21\",\n" +
            "        \"dok_nummer\": \"152\",\n" +
            "        \"dok_datum\": \"2021-07-07\",\n" +
            "        \"avsnittsrubrik\": \"Prövning av förslag till statsminister\",\n" +
            "        \"underrubrik\": \"\",\n" +
            "        \"kammaraktivitet\": \"\",\n" +
            "        \"anforande_id\": \"74255a22-37df-eb11-9153-901b0eac4c78\",\n" +
            "        \"anforande_nummer\": \"11\",\n" +
            "        \"talare\": \"TALMANNEN\",\n" +
            "        \"parti\": \"TALMANNEN\",\n" +
            "        \"anforandetext\": \"\",\n" +
            "        \"intressent_id\": \"\",\n" +
            "        \"rel_dok_id\": \"\",\n" +
            "        \"replik\": \"N\",\n" +
            "        \"systemdatum\": \"2021-07-07 17:22:56\",\n" +
            "        \"systemnyckel\": \"518127\",\n" +
            "        \"anforande_url_xml\": \"http://data.riksdagen.se/anforande/H809152-11\",\n" +
            "        \"anforande_url_html\": \"http://data.riksdagen.se/anforande/H809152-11/html\",\n" +
            "        \"protokoll_url_www\": \"http://www.riksdagen.se/sv/Dokument-Lagar/Kammaren/Protokoll/Riksdagens-snabbprotokoll_H809152/#anf11\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"dok_hangar_id\": \"5102740\",\n" +
            "        \"dok_id\": \"H809152\",\n" +
            "        \"dok_titel\": \"Protokoll 2020/21:152 Onsdagen den 7 juli\",\n" +
            "        \"dok_rm\": \"2020/21\",\n" +
            "        \"dok_nummer\": \"152\",\n" +
            "        \"dok_datum\": \"2021-07-07\",\n" +
            "        \"avsnittsrubrik\": \"Prövning av förslag till statsminister\",\n" +
            "        \"underrubrik\": \"\",\n" +
            "        \"kammaraktivitet\": \"\",\n" +
            "        \"anforande_id\": \"73255a22-37df-eb11-9153-901b0eac4c78\",\n" +
            "        \"anforande_nummer\": \"10\",\n" +
            "        \"talare\": \"Karolina Skog (MP)\",\n" +
            "        \"parti\": \"MP\",\n" +
            "        \"anforandetext\": \"\",\n" +
            "        \"intressent_id\": \"0334816698724\",\n" +
            "        \"rel_dok_id\": \"\",\n" +
            "        \"replik\": \"N\",\n" +
            "        \"systemdatum\": \"2021-07-07 17:22:56\",\n" +
            "        \"systemnyckel\": \"518126\",\n" +
            "        \"anforande_url_xml\": \"http://data.riksdagen.se/anforande/H809152-10\",\n" +
            "        \"anforande_url_html\": \"http://data.riksdagen.se/anforande/H809152-10/html\",\n" +
            "        \"protokoll_url_www\": \"http://www.riksdagen.se/sv/Dokument-Lagar/Kammaren/Protokoll/Riksdagens-snabbprotokoll_H809152/#anf10\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"dok_hangar_id\": \"5102740\",\n" +
            "        \"dok_id\": \"H809152\",\n" +
            "        \"dok_titel\": \"Protokoll 2020/21:152 Onsdagen den 7 juli\",\n" +
            "        \"dok_rm\": \"2020/21\",\n" +
            "        \"dok_nummer\": \"152\",\n" +
            "        \"dok_datum\": \"2021-07-07\",\n" +
            "        \"avsnittsrubrik\": \"Prövning av förslag till statsminister\",\n" +
            "        \"underrubrik\": \"\",\n" +
            "        \"kammaraktivitet\": \"\",\n" +
            "        \"anforande_id\": \"72255a22-37df-eb11-9153-901b0eac4c78\",\n" +
            "        \"anforande_nummer\": \"9\",\n" +
            "        \"talare\": \"Nooshi Dadgostar (V)\",\n" +
            "        \"parti\": \"V\",\n" +
            "        \"anforandetext\": \"\",\n" +
            "        \"intressent_id\": \"0721509806321\",\n" +
            "        \"rel_dok_id\": \"\",\n" +
            "        \"replik\": \"N\",\n" +
            "        \"systemdatum\": \"2021-07-07 17:22:56\",\n" +
            "        \"systemnyckel\": \"518125\",\n" +
            "        \"anforande_url_xml\": \"http://data.riksdagen.se/anforande/H809152-9\",\n" +
            "        \"anforande_url_html\": \"http://data.riksdagen.se/anforande/H809152-9/html\",\n" +
            "        \"protokoll_url_www\": \"http://www.riksdagen.se/sv/Dokument-Lagar/Kammaren/Protokoll/Riksdagens-snabbprotokoll_H809152/#anf9\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"dok_hangar_id\": \"5102740\",\n" +
            "        \"dok_id\": \"H809152\",\n" +
            "        \"dok_titel\": \"Protokoll 2020/21:152 Onsdagen den 7 juli\",\n" +
            "        \"dok_rm\": \"2020/21\",\n" +
            "        \"dok_nummer\": \"152\",\n" +
            "        \"dok_datum\": \"2021-07-07\",\n" +
            "        \"avsnittsrubrik\": \"Prövning av förslag till statsminister\",\n" +
            "        \"underrubrik\": \"\",\n" +
            "        \"kammaraktivitet\": \"\",\n" +
            "        \"anforande_id\": \"71255a22-37df-eb11-9153-901b0eac4c78\",\n" +
            "        \"anforande_nummer\": \"8\",\n" +
            "        \"talare\": \"Annie Lööf (C)\",\n" +
            "        \"parti\": \"C\",\n" +
            "        \"anforandetext\": \"\",\n" +
            "        \"intressent_id\": \"0862868280923\",\n" +
            "        \"rel_dok_id\": \"\",\n" +
            "        \"replik\": \"N\",\n" +
            "        \"systemdatum\": \"2021-07-07 17:22:56\",\n" +
            "        \"systemnyckel\": \"518124\",\n" +
            "        \"anforande_url_xml\": \"http://data.riksdagen.se/anforande/H809152-8\",\n" +
            "        \"anforande_url_html\": \"http://data.riksdagen.se/anforande/H809152-8/html\",\n" +
            "        \"protokoll_url_www\": \"http://www.riksdagen.se/sv/Dokument-Lagar/Kammaren/Protokoll/Riksdagens-snabbprotokoll_H809152/#anf8\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"dok_hangar_id\": \"5102740\",\n" +
            "        \"dok_id\": \"H809152\",\n" +
            "        \"dok_titel\": \"Protokoll 2020/21:152 Onsdagen den 7 juli\",\n" +
            "        \"dok_rm\": \"2020/21\",\n" +
            "        \"dok_nummer\": \"152\",\n" +
            "        \"dok_datum\": \"2021-07-07\",\n" +
            "        \"avsnittsrubrik\": \"Prövning av förslag till statsminister\",\n" +
            "        \"underrubrik\": \"\",\n" +
            "        \"kammaraktivitet\": \"\",\n" +
            "        \"anforande_id\": \"70255a22-37df-eb11-9153-901b0eac4c78\",\n" +
            "        \"anforande_nummer\": \"7\",\n" +
            "        \"talare\": \"Ulf Kristersson (M)\",\n" +
            "        \"parti\": \"M\",\n" +
            "        \"anforandetext\": \"\",\n" +
            "        \"intressent_id\": \"0222691314314\",\n" +
            "        \"rel_dok_id\": \"\",\n" +
            "        \"replik\": \"N\",\n" +
            "        \"systemdatum\": \"2021-07-07 17:22:56\",\n" +
            "        \"systemnyckel\": \"518123\",\n" +
            "        \"anforande_url_xml\": \"http://data.riksdagen.se/anforande/H809152-7\",\n" +
            "        \"anforande_url_html\": \"http://data.riksdagen.se/anforande/H809152-7/html\",\n" +
            "        \"protokoll_url_www\": \"http://www.riksdagen.se/sv/Dokument-Lagar/Kammaren/Protokoll/Riksdagens-snabbprotokoll_H809152/#anf7\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"dok_hangar_id\": \"5102740\",\n" +
            "        \"dok_id\": \"H809152\",\n" +
            "        \"dok_titel\": \"Protokoll 2020/21:152 Onsdagen den 7 juli\",\n" +
            "        \"dok_rm\": \"2020/21\",\n" +
            "        \"dok_nummer\": \"152\",\n" +
            "        \"dok_datum\": \"2021-07-07\",\n" +
            "        \"avsnittsrubrik\": \"Prövning av förslag till statsminister\",\n" +
            "        \"underrubrik\": \"\",\n" +
            "        \"kammaraktivitet\": \"\",\n" +
            "        \"anforande_id\": \"6f255a22-37df-eb11-9153-901b0eac4c78\",\n" +
            "        \"anforande_nummer\": \"6\",\n" +
            "        \"talare\": \"Ebba Busch (KD)\",\n" +
            "        \"parti\": \"KD\",\n" +
            "        \"anforandetext\": \"\",\n" +
            "        \"intressent_id\": \"0512510717328\",\n" +
            "        \"rel_dok_id\": \"\",\n" +
            "        \"replik\": \"N\",\n" +
            "        \"systemdatum\": \"2021-07-07 17:22:56\",\n" +
            "        \"systemnyckel\": \"518122\",\n" +
            "        \"anforande_url_xml\": \"http://data.riksdagen.se/anforande/H809152-6\",\n" +
            "        \"anforande_url_html\": \"http://data.riksdagen.se/anforande/H809152-6/html\",\n" +
            "        \"protokoll_url_www\": \"http://www.riksdagen.se/sv/Dokument-Lagar/Kammaren/Protokoll/Riksdagens-snabbprotokoll_H809152/#anf6\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"dok_hangar_id\": \"5102740\",\n" +
            "        \"dok_id\": \"H809152\",\n" +
            "        \"dok_titel\": \"Protokoll 2020/21:152 Onsdagen den 7 juli\",\n" +
            "        \"dok_rm\": \"2020/21\",\n" +
            "        \"dok_nummer\": \"152\",\n" +
            "        \"dok_datum\": \"2021-07-07\",\n" +
            "        \"avsnittsrubrik\": \"Prövning av förslag till statsminister\",\n" +
            "        \"underrubrik\": \"\",\n" +
            "        \"kammaraktivitet\": \"\",\n" +
            "        \"anforande_id\": \"6e255a22-37df-eb11-9153-901b0eac4c78\",\n" +
            "        \"anforande_nummer\": \"5\",\n" +
            "        \"talare\": \"Amineh Kakabaveh (-)\",\n" +
            "        \"parti\": \"-\",\n" +
            "        \"anforandetext\": \"\",\n" +
            "        \"intressent_id\": \"0545353563812\",\n" +
            "        \"rel_dok_id\": \"\",\n" +
            "        \"replik\": \"N\",\n" +
            "        \"systemdatum\": \"2021-07-07 17:22:56\",\n" +
            "        \"systemnyckel\": \"518121\",\n" +
            "        \"anforande_url_xml\": \"http://data.riksdagen.se/anforande/H809152-5\",\n" +
            "        \"anforande_url_html\": \"http://data.riksdagen.se/anforande/H809152-5/html\",\n" +
            "        \"protokoll_url_www\": \"http://www.riksdagen.se/sv/Dokument-Lagar/Kammaren/Protokoll/Riksdagens-snabbprotokoll_H809152/#anf5\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"dok_hangar_id\": \"5102740\",\n" +
            "        \"dok_id\": \"H809152\",\n" +
            "        \"dok_titel\": \"Protokoll 2020/21:152 Onsdagen den 7 juli\",\n" +
            "        \"dok_rm\": \"2020/21\",\n" +
            "        \"dok_nummer\": \"152\",\n" +
            "        \"dok_datum\": \"2021-07-07\",\n" +
            "        \"avsnittsrubrik\": \"Prövning av förslag till statsminister\",\n" +
            "        \"underrubrik\": \"\",\n" +
            "        \"kammaraktivitet\": \"\",\n" +
            "        \"anforande_id\": \"6d255a22-37df-eb11-9153-901b0eac4c78\",\n" +
            "        \"anforande_nummer\": \"4\",\n" +
            "        \"talare\": \"Jimmie Åkesson (SD)\",\n" +
            "        \"parti\": \"SD\",\n" +
            "        \"anforandetext\": \"\",\n" +
            "        \"intressent_id\": \"051207517226\",\n" +
            "        \"rel_dok_id\": \"\",\n" +
            "        \"replik\": \"N\",\n" +
            "        \"systemdatum\": \"2021-07-07 17:22:56\",\n" +
            "        \"systemnyckel\": \"518120\",\n" +
            "        \"anforande_url_xml\": \"http://data.riksdagen.se/anforande/H809152-4\",\n" +
            "        \"anforande_url_html\": \"http://data.riksdagen.se/anforande/H809152-4/html\",\n" +
            "        \"protokoll_url_www\": \"http://www.riksdagen.se/sv/Dokument-Lagar/Kammaren/Protokoll/Riksdagens-snabbprotokoll_H809152/#anf4\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";

    @Test
    void canDeserializeJson() throws IOException {
        AnforandeResponseDto anforandeResponseDto = new ObjectMapper().readValue(json, AnforandeResponseDto.class);
        Assertions.assertEquals(anforandeResponseDto.getAnforandeLista().getAnforande().size(), 10);
    }
}