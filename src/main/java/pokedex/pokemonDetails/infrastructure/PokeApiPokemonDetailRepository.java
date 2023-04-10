package pokedex.pokemonDetails.infrastructure;

import org.json.JSONObject;
import pokedex.pokemonDetails.domain.*;
import pokedex.pokemonDetails.domain.exceptions.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PokeApiPokemonDetailRepository implements PokemonDetailRepository {

    private String apiUrl = "https://pokeapi.co/api/v2/pokemon/";

     public PokeApiPokemonDetailRepository() {}

    public PokeApiPokemonDetailRepository(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public PokemonDetail getById(PokemonID pokemonID) {

        HttpResponse<String> response;
        try {
            response = apiCall(pokemonID);
        } catch (IOException | InterruptedException e) {
            throw new PokemonDetailRepositoryConnectionException("An error has ocurred conecting to pokeapi");
        }
        guardPokemonNameExists(response);
        JSONObject obj = new JSONObject(response.body());
        PokemonID ID = new PokemonID(obj.getInt("id"));
        PokemonName name = new PokemonName(obj.getString("name"));
        PokemonWeight weight = new PokemonWeight(obj.getDouble("weight"));
        PokemonHeight height = new PokemonHeight(obj.getDouble("height"));
        return new PokemonDetail(ID, name, height, weight);
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
}
