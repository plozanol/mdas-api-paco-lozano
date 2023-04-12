package pokedex.pokemon.domain;

import org.json.JSONException;

public interface PokemonRepository {

    boolean exist(PokemonID pokemonID);

    Pokemon get(PokemonID pokemonID) throws JSONException;
    void create(Pokemon pokemon);
    void update(Pokemon pokemon);

}
