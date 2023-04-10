package pokedex.pokemonType.domain;

import pokedex.pokemonType.domain.exceptions.PokemonWithoutTypesException;

public class PokemonTypeCollection {
    private PokemonType[] types;

    public PokemonTypeCollection(PokemonType... types) {
        guardNumberPokemonTypes(types);
        this.types = types;
    }

    private void guardNumberPokemonTypes(PokemonType... types) {
        if (types == null || types.length < 1) {
            throw new PokemonWithoutTypesException();
        }
    }

    public PokemonType[] getTypes() {
        return types;
    }
}
