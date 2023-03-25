package pokedex.pokemonType.infrastructure;

import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.Cookie;
import org.mockserver.model.Delay;
import org.mockserver.model.Header;
import org.mockserver.model.Parameter;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.matchers.Times.exactly;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.StringBody.exact;

public class PokeapiMock {
    private final MockServerClient client;

    public PokeapiMock() {
        //client = new MockServerClient("127.0.0.1", 1080);
        client = startClientAndServer(1080);    }

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
                        //.withDelay(new Delay(SECONDS, 1))
                );
    }

    private static String gloomFakeResponse() {
        return "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"stench\",\n" +
                "  \"is_main_series\": true,\n" +
                "  \"generation\": {\n" +
                "    \"name\": \"generation-iii\",\n" +
                "    \"url\": \"https://pokeapi.co/api/v2/generation/3/\"\n" +
                "  },\n" +
                "  \"names\": [\n" +
                "    {\n" +
                "      \"name\": \"Stench\",\n" +
                "      \"language\": {\n" +
                "        \"name\": \"en\",\n" +
                "        \"url\": \"https://pokeapi.co/api/v2/language/9/\"\n" +
                "      }\n" +
                "    }\n" +
                "  ],\n" +
                "  \"effect_entries\": [\n" +
                "    {\n" +
                "      \"effect\": \"This Pokémon's damaging moves have a 10% chance to make the target [flinch]{mechanic:flinch} with each hit if they do not already cause flinching as a secondary effect.\\n\\nThis ability does not stack with a held item.\\n\\nOverworld: The wild encounter rate is halved while this Pokémon is first in the party.\",\n" +
                "      \"short_effect\": \"Has a 10% chance of making target Pokémon [flinch]{mechanic:flinch} with each hit.\",\n" +
                "      \"language\": {\n" +
                "        \"name\": \"en\",\n" +
                "        \"url\": \"https://pokeapi.co/api/v2/language/9/\"\n" +
                "      }\n" +
                "    }\n" +
                "  ],\n" +
                "  \"effect_changes\": [\n" +
                "    {\n" +
                "      \"version_group\": {\n" +
                "        \"name\": \"black-white\",\n" +
                "        \"url\": \"https://pokeapi.co/api/v2/version-group/11/\"\n" +
                "      },\n" +
                "      \"effect_entries\": [\n" +
                "        {\n" +
                "          \"effect\": \"Has no effect in battle.\",\n" +
                "          \"language\": {\n" +
                "            \"name\": \"en\",\n" +
                "            \"url\": \"https://pokeapi.co/api/v2/language/9/\"\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"flavor_text_entries\": [\n" +
                "    {\n" +
                "      \"flavor_text\": \"è‡\u00ADã\u0081\u008Fã\u0081¦ã€€ç›¸æ‰‹ã\u0081Œ\\nã\u0081²ã‚‹ã‚€ã€€ã\u0081“ã\u0081¨ã\u0081Œã\u0081‚ã‚‹ã€‚\",\n" +
                "      \"language\": {\n" +
                "        \"name\": \"ja-kanji\",\n" +
                "        \"url\": \"https://pokeapi.co/api/v2/language/11/\"\n" +
                "      },\n" +
                "      \"version_group\": {\n" +
                "        \"name\": \"x-y\",\n" +
                "        \"url\": \"https://pokeapi.co/api/v2/version-group/15/\"\n" +
                "      }\n" +
                "    }\n" +
                "  ],\n" +
                "  \"pokemon\": [\n" +
                "    {\n" +
                "      \"is_hidden\": true,\n" +
                "      \"slot\": 3,\n" +
                "      \"pokemon\": {\n" +
                "        \"name\": \"gloom\",\n" +
                "        \"url\": \"https://pokeapi.co/api/v2/pokemon/44/\"\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }
}
