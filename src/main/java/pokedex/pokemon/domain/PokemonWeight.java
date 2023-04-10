package pokedex.pokemon.domain;

import pokedex.pokemon.domain.exceptions.PokemonNegativeWeightException;

public class PokemonWeight {
    private final double weight;

    public PokemonWeight(double weight) {
        pokemonNegativeWeightGuard(weight);
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    private void pokemonNegativeWeightGuard(double weight) {
        if (weight < 0) {
            throw new PokemonNegativeWeightException();
        }
    }
}
