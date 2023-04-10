package pokedex.pokemonDetails.domain;

import pokedex.pokemonDetails.domain.exceptions.*;

public interface PokemonDetailRepository {
    PokemonDetail getById(PokemonID pokemonID);
}
