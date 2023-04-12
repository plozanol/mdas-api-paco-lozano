package pokedex.pokemon.infrastructure;

import org.json.JSONException;
import pokedex.pokemon.domain.Pokemon;

public abstract class PokemonMiddleware {

    private PokemonMiddleware next;

    public static PokemonMiddleware link(PokemonMiddleware first, PokemonMiddleware... chain) {
        PokemonMiddleware head = first;
        for (PokemonMiddleware nextInChain: chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract Pokemon execute(Integer pokemonID) throws JSONException;

    protected Pokemon checkNext(Integer pokemonID) throws JSONException {
        if (next == null) {
            return null;
        }
        return next.execute(pokemonID);
    }
}