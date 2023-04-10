package pokedex.pokemonDetails.domain;

import pokedex.pokemonDetails.domain.exceptions.PokemonIdOutOfRangeException;

public class PokemonID {
    private final int ID;

    public PokemonID(int ID) {
        pokemonOutOfRangeGuard(ID);
        this.ID = ID;
    }

    private void pokemonOutOfRangeGuard(int id) {
        if (id < 1 || id > 898) {
            throw new PokemonIdOutOfRangeException();
        }
    }

    public int ID() {
        return ID;
    }

    @Override
    public int hashCode() {
        return ID;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        var pokemonIdObj = (PokemonID) obj;
        return ID == pokemonIdObj.ID;
    }
}
