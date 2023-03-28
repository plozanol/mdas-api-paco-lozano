package pokedex.pokemonDetails.domain;

import pokedex.pokemonDetails.domain.exceptions.PokemonNegativeHeightException;

public class PokemonHeight {
    private final double height;

    public PokemonHeight(double height) throws PokemonNegativeHeightException {
        pokemonNegativeHeightGuard(height);
        this.height = height;
    }

    public double height() {
        return height;
    }

    private void pokemonNegativeHeightGuard(double height) throws PokemonNegativeHeightException {
        if (height < 0) {
            throw new PokemonNegativeHeightException();
        }
    }
}

