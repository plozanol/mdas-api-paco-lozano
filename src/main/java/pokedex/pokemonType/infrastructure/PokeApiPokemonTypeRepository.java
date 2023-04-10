package pokedex.pokemonType.infrastructure;

import org.json.JSONObject;
import pokedex.pokemonType.domain.PokemonName;
import pokedex.pokemonType.domain.PokemonType;
import pokedex.pokemonType.domain.PokemonTypeCollection;
import pokedex.pokemonType.domain.PokemonTypeRepository;
import pokedex.pokemonType.domain.exceptions.EmptyPokemonNameParameterException;
import pokedex.pokemonType.domain.exceptions.PokemonNotFoundException;
import pokedex.pokemonType.domain.exceptions.PokemonTypeRepositoryConnectionException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class PokeApiPokemonTypeRepository implements PokemonTypeRepository {

    private String apiUrl = "https://pokeapi.co/api/v2/pokemon/";

    PokeApiPokemonTypeRepository() {}
    PokeApiPokemonTypeRepository(String apiUrl){
        this.apiUrl = apiUrl;
    }

    public PokemonTypeCollection get(PokemonName name) {
        guardPokemonNameIsNotEmpty(name.toString());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s", apiUrl, name.toString())))
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new PokemonTypeRepositoryConnectionException("An error has ocurred conecting to pokeapi");
        }
        guardPokemonNameExists(response);
        JSONObject obj = new JSONObject(response.body());

        var typesArray = obj.getJSONArray("types");
        List<PokemonType> pokemonTypes = new ArrayList<PokemonType>();
        for (int i = 0; i < typesArray.length(); i++) {
            String type = typesArray.getJSONObject(i).getJSONObject("type").getString("name");
            pokemonTypes.add(new PokemonType(type));
        }

        PokemonType[] result = pokemonTypes.toArray(new PokemonType[0]);
        return new PokemonTypeCollection(result);
    }

    private void guardPokemonNameExists(HttpResponse<String> response) {
        if (response.statusCode() == 404)
            throw new PokemonNotFoundException();
    }

    private void guardPokemonNameIsNotEmpty(String name) {
        if (name.isEmpty()) {
            throw new EmptyPokemonNameParameterException();
        }
    }

}
