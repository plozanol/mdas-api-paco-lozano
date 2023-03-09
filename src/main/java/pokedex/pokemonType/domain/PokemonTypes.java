package pokedex.pokemonType.domain;

import pokedex.pokemonType.domain.exceptions.PokemonWithoutTypesException;

import java.util.Arrays;

public class PokemonTypes {
    private PokemonType[] types;

    public PokemonTypes(PokemonType... types) throws PokemonWithoutTypesException {
        this.types = types;
        guardNumberPokemonTypes();
    }

    private void guardNumberPokemonTypes() throws PokemonWithoutTypesException {
        if (types.length < 1) {
            throw new PokemonWithoutTypesException();
        }
    }

    public PokemonType[] getTypes() {
        return types;
    }
}
