package pokedex.pokemon.infrastructure;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import pokedex.pokemon.domain.*;
import pokedex.pokemon.domain.exceptions.PokemonNotFoundException;
import pokedex.pokemon.domain.exceptions.PokemonRepositoryConnectionException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Repository
public class PokeApiPokemonRepository implements PokemonRepository {

    private String apiUrl = "https://pokeapi.co/api/v2/pokemon/";

    public PokeApiPokemonRepository() {}

    public PokeApiPokemonRepository(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public Pokemon get(PokemonID pokemonID) throws JSONException {

        HttpResponse<String> response;
        try {
            response = apiCall(pokemonID);
        } catch (IOException | InterruptedException e) {
            throw new PokemonRepositoryConnectionException("An error has ocurred conecting to pokeapi");
        }
        guardPokemonNameExists(response);
        JSONObject obj = new JSONObject(response.body());
        PokemonID ID = new PokemonID(obj.getInt("id"));
        PokemonName name = new PokemonName(obj.getString("name"));
        PokemonWeight weight = new PokemonWeight(obj.getDouble("weight"));
        PokemonHeight height = new PokemonHeight(obj.getDouble("height"));
        return new Pokemon(ID, name, height, weight);
    }

    private HttpResponse<String> apiCall(PokemonID pokemonID) throws IOException, InterruptedException {
        HttpResponse<String> response;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s", apiUrl, pokemonID.ID())))
                .build();
        response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        return response;
    }

    private void guardPokemonNameExists(HttpResponse<String> response) {
        if (response.statusCode() == 404)
            throw new PokemonNotFoundException();
    }

    @Override
    public void create(Pokemon pokemon) {

    }

    @Override
    public void update(Pokemon pokemon) {

    }

    @Override
    public boolean exist(PokemonID pokemonID) {
        return false;
    }
}
