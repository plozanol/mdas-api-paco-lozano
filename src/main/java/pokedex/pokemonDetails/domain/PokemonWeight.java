package pokedex.pokemonDetails.domain;

import pokedex.pokemonDetails.domain.exceptions.PokemonNegativeWeightException;

public class PokemonWeight {
    private final double weight;

    public PokemonWeight(double weight) throws PokemonNegativeWeightException {
        pokemonNegativeWeightGuard(weight);
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    private void pokemonNegativeWeightGuard(double weight) throws PokemonNegativeWeightException {
        if (weight < 0) {
            throw new PokemonNegativeWeightException();
        }
    }
}
