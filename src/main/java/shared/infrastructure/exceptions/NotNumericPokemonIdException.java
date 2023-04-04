package shared.infrastructure.exceptions;

public class NotNumericPokemonIdException extends IllegalArgumentException {

    public NotNumericPokemonIdException() { super("Not a valid numeric pokemonId format"); }

}
