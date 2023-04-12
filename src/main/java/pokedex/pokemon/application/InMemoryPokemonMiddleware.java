package pokedex.pokemon.application;

import org.json.JSONException;
import pokedex.pokemon.domain.Pokemon;
import pokedex.pokemon.domain.PokemonID;
import pokedex.pokemon.domain.PokemonRepository;
import pokedex.pokemon.infrastructure.PokemonMiddleware;

public class InMemoryPokemonMiddleware extends PokemonMiddleware {

    private final PokemonRepository pokemonRepository;

    public InMemoryPokemonMiddleware(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public Pokemon execute(Integer pokemonID) throws JSONException {

        if (pokemonRepository.exist(new PokemonID(pokemonID))) {
            System.out.println("pokemon InMemory search");
            return pokemonRepository.get(new PokemonID(pokemonID));
        }

        return super.checkNext(pokemonID);

    }
}