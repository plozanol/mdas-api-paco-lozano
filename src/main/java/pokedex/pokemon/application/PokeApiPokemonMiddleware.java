package pokedex.pokemon.application;

import org.json.JSONException;
import pokedex.pokemon.domain.Pokemon;
import pokedex.pokemon.domain.PokemonID;
import pokedex.pokemon.infrastructure.InMemoryPokemonRepository;
import pokedex.pokemon.infrastructure.PokeApiPokemonRepository;
import pokedex.pokemon.infrastructure.PokemonMiddleware;

public class PokeApiPokemonMiddleware extends PokemonMiddleware {

    private final PokeApiPokemonRepository pokeApiPokemonRepository;

    private final InMemoryPokemonRepository inMemoryPokemonRepository;


    public PokeApiPokemonMiddleware(PokeApiPokemonRepository pokeApiPokemonRepository, InMemoryPokemonRepository inMemoryPokemonRepository) {
        this.pokeApiPokemonRepository = pokeApiPokemonRepository;
        this.inMemoryPokemonRepository = inMemoryPokemonRepository;
    }

    @Override
    public Pokemon execute(Integer pokemonID) throws JSONException {
        System.out.println("pokemon PokeApi search");
        Pokemon pokemon = pokeApiPokemonRepository.get(new PokemonID(pokemonID));
        inMemoryPokemonRepository.create(pokemon);
        return pokemon;
    }
}