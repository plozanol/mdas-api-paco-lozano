package pokedex.pokemonDetails.domain;

import pokedex.pokemonDetails.domain.exceptions.PokemonNegativeHeightException;

public class PokemonHeight {
    private final double height;

    public PokemonHeight(double height) {
        pokemonNegativeHeightGuard(height);
        this.height = height;
    }

    public double height() {
        return height;
    }

    private void pokemonNegativeHeightGuard(double height) {
        if (height < 0) {
            throw new PokemonNegativeHeightException();
        }
    }
}

