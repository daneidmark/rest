## Hur man integrerar tjänster

### 1. Titta på APIet
https://data.riksdagen.se/anforandelista/?utformat=json&anftyp=Nej&sz=10

### 2. Skapa en integration

Vi är bara intresserade av subset av datat
```
{
    anforandelista: {
        anforanden: [{
            dok_id
        }]
    }
}
```
0. Vi skapar vårt domän objekt Anforande

1. Vi skapar upp våra DTOer utifrån in.
Börja med Anforanden, sen Anforandelista och tillsist hela json-objektet.

2. Vi skapar vår klient, plockar in RestTemplate och basUrl i konstruktorn så vi kan konfigurera dem utifrån

### 3: Skriv ett test och se att allt funkar

Skapa ett test och se att vi får tillbaka det som är tänkt

### 4: Men nu kör vi mot riktiga tjänsten? Låt oss mocka den

Wiremock to the rescue. 

Skapa en WireMockServer
* starta den i before
* Stäng ned i after

Byt ut baseUrl mot wiremock

regeringMockServer.stubFor(get(urlEqualTo(RegeringClient.path)).willReturn(aResponse()
.withStatus(HttpStatus.OK.value())
.withHeader("content-type", APPLICATION_JSON.toString())
.withBody(body)));
