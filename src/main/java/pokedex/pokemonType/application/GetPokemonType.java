package pokedex.pokemonType.application;

import pokedex.pokemonType.domain.PokemonName;
import pokedex.pokemonType.domain.PokemonTypeRepositoryConnectionException;
import pokedex.pokemonType.domain.exceptions.EmptyPokemonNameParameterException;
import pokedex.pokemonType.domain.exceptions.PokemonNotFoundException;
import pokedex.pokemonType.domain.exceptions.PokemonWithoutTypesException;
import pokedex.pokemonType.domain.PokemonTypeRepository;
import pokedex.pokemonType.domain.PokemonTypes;

public class GetPokemonType {

    private final PokemonTypeRepository pokemonTypeRepository;

    public GetPokemonType(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    public PokemonTypes execute(String pokemonName) throws PokemonWithoutTypesException, EmptyPokemonNameParameterException, PokemonTypeRepositoryConnectionException, PokemonNotFoundException {
        var types = pokemonTypeRepository.get(new PokemonName(pokemonName));
        return types;
    }

}
