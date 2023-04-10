package pokedex.pokemon.domain.exceptions;

public class PokemonNotFoundException extends IllegalArgumentException {
    public PokemonNotFoundException() { super("Pokemon name not found"); }
}
