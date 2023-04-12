package pokedex.pokemon.infrastructure;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import pokedex.pokemon.application.InMemoryPokemonMiddleware;
import pokedex.pokemon.application.PokeApiPokemonMiddleware;
import pokedex.pokemon.domain.Pokemon;

@Controller
public class GetPokemonController {

    private final PokemonMiddleware middleware;

    private final InMemoryPokemonRepository inMemoryPokemonRepository;

    private final PokeApiPokemonRepository pokeApiPokemonRepository;

    public GetPokemonController(InMemoryPokemonRepository inMemoryPokemonRepository, PokeApiPokemonRepository pokeApiPokemonRepository) {
        this.inMemoryPokemonRepository = inMemoryPokemonRepository;
        this.pokeApiPokemonRepository = pokeApiPokemonRepository;

        middleware = PokemonMiddleware.link(
                new InMemoryPokemonMiddleware(this.inMemoryPokemonRepository),
                new PokeApiPokemonMiddleware(this.pokeApiPokemonRepository, this.inMemoryPokemonRepository)
        );
    }

    public Pokemon execute(Integer pokemonID) throws JSONException {
        return middleware.execute(pokemonID);
    }
}