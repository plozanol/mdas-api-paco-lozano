package pokedex.pokemon.domain;

import pokedex.pokemon.domain.exceptions.PokemonNameNotEmptyException;

public class PokemonName {
    private final String name;

    public PokemonName(String name) {
        pokemonNameNotEmptyGuard(name);
        this.name = name;
    }

    private void pokemonNameNotEmptyGuard(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new PokemonNameNotEmptyException();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
