package pokedex.pokemonType.domain;

import pokedex.pokemonType.domain.exceptions.PokemonWithoutTypesException;

public class PokemonTypeCollection {
    private PokemonType[] types;

    public PokemonTypeCollection(PokemonType... types) throws PokemonWithoutTypesException {
        guardNumberPokemonTypes(types);
        this.types = types;
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
