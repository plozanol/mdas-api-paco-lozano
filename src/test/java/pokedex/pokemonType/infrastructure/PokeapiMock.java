package pokedex.pokemonType.infrastructure;

import org.mockserver.client.server.MockServerClient;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class PokeapiMock {
    private final MockServerClient client;

    public PokeapiMock() {
        client = startClientAndServer(9080);
        }

    public void addGloomResponse() {
            client.when(
                    request()
                            .withMethod("GET")
                            .withPath("/pokeapiMock/gloom")
                    )
                .respond(
                        response()
                                .withStatusCode(200)
                                .withBody(gloomFakeResponse())
                );
    }

    private static String gloomFakeResponse() {
        return "{\"types\": [\n" +
                "    {\n" +
                "      \"slot\": 1,\n" +
                "      \"type\": {\n" +
                "        \"name\": \"grass\",\n" +
                "        \"url\": \"https://pokeapi.co/api/v2/type/12/\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"slot\": 2,\n" +
                "      \"type\": {\n" +
                "        \"name\": \"poison\",\n" +
                "        \"url\": \"https://pokeapi.co/api/v2/type/4/\"\n" +
                "      }\n" +
                "    }\n" +
                "  ],}";
    }
}
