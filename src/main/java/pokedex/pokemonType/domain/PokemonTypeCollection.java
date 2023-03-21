package pokedex.pokemonType.domain;

import pokedex.pokemonType.domain.exceptions.PokemonWithoutTypesException;

public class PokemonTypeCollection {
    private PokemonType[] types;

    public PokemonTypes(PokemonType... types) throws PokemonWithoutTypesException {
        this.types = types;
        guardNumberPokemonTypes();
    }

    private void guardNumberPokemonTypes(PokemonType... types) throws PokemonWithoutTypesException {
        if (types == null || types.length < 1) {
            throw new PokemonWithoutTypesException();
        }
    }

    public PokemonType[] getTypes() {
        return types;
    }
}
