package pokedex.pokemon.application;

import org.json.JSONException;
import org.springframework.stereotype.Service;
import pokedex.pokemon.domain.Pokemon;
import pokedex.pokemon.domain.PokemonID;
import pokedex.pokemon.infrastructure.InMemoryPokemonRepository;
import pokedex.pokemon.infrastructure.PokeApiPokemonRepository;

@Service
public class CalculateFavouriteCounterUseCase {

    private final InMemoryPokemonRepository inMemoryPokemonRepository;

    private final PokeApiPokemonRepository pokeApiPokemonRepository;

    public CalculateFavouriteCounterUseCase(InMemoryPokemonRepository inMemoryPokemonRepository, PokeApiPokemonRepository pokeApiPokemonRepository) {
        this.inMemoryPokemonRepository = inMemoryPokemonRepository;
        this.pokeApiPokemonRepository = pokeApiPokemonRepository;
    }

    public void execute(String routingKey, String stringPokemonId) throws JSONException {

        int pokemonId = -1;
        try {
            pokemonId = Integer.parseInt(stringPokemonId);
        } catch (NumberFormatException e) {
            System.out.println("wrong pokemonId received");
        }
        if(pokemonId < 0) return;

        Pokemon pokemon = inMemoryPokemonRepository.get(new PokemonID(pokemonId));
        if(pokemon == null) {
            PokeApiPokemonMiddleware pokemonMiddleware = new PokeApiPokemonMiddleware(this.pokeApiPokemonRepository, this.inMemoryPokemonRepository);
            pokemonMiddleware.execute(pokemonId);
        };

        if("favourite.pokemon.added".equalsIgnoreCase(routingKey)) {
            Pokemon pokemonWithIncrementedFavourite = new Pokemon(pokemon, pokemon.favouriteCounter().favouriteCounter()+1);
            inMemoryPokemonRepository.update(pokemonWithIncrementedFavourite);
            return;
        }

        if("favourite.pokemon.removed".equalsIgnoreCase(routingKey)) {
            Pokemon pokemonWithDecrementedFavourite = new Pokemon(pokemon, pokemon.favouriteCounter().favouriteCounter()-1);
            inMemoryPokemonRepository.update(pokemonWithDecrementedFavourite);
            return;
        }
    }

}
