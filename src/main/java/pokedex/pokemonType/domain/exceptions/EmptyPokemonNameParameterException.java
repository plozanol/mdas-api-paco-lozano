package pokedex.pokemonType.domain.exceptions;

public class EmptyPokemonNameParameterException extends IllegalArgumentException {
    public EmptyPokemonNameParameterException() { super("Empty pokemon name provided to pokemon type repository"); }
}
