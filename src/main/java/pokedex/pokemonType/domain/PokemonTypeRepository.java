package pokedex.pokemonType.domain;

import org.json.JSONException;

public interface PokemonTypeRepository {
    PokemonTypeCollection get(PokemonName pokemonName) throws JSONException;
}
