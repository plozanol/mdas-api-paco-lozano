package pokedex.pokemonType.domain;

import pokedex.pokemonType.domain.exceptions.EmptyPokemonNameParameterException;
import pokedex.pokemonType.domain.exceptions.PokemonNotFoundException;
import pokedex.pokemonType.domain.exceptions.PokemonTypeRepositoryConnectionException;
import pokedex.pokemonType.domain.exceptions.PokemonWithoutTypesException;

public interface PokemonTypeRepository {
    PokemonTypeCollection get(PokemonName pokemonName);
}
