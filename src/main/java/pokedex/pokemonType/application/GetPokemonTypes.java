package pokedex.pokemonType.application;

import pokedex.pokemonType.domain.PokemonName;
import pokedex.pokemonType.domain.exceptions.PokemonTypeRepositoryConnectionException;
import pokedex.pokemonType.domain.exceptions.EmptyPokemonNameParameterException;
import pokedex.pokemonType.domain.exceptions.PokemonNotFoundException;
import pokedex.pokemonType.domain.exceptions.PokemonWithoutTypesException;
import pokedex.pokemonType.domain.PokemonTypeRepository;
import pokedex.pokemonType.domain.PokemonTypeCollection;

public class GetPokemonTypes {

    private final PokemonTypeRepository pokemonTypeRepository;

    public GetPokemonTypes(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    public PokemonTypeCollection execute(String pokemonName) throws PokemonWithoutTypesException, EmptyPokemonNameParameterException, PokemonTypeRepositoryConnectionException, PokemonNotFoundException {
        var types = pokemonTypeRepository.get(new PokemonName(pokemonName));
        return types;
    }

}
