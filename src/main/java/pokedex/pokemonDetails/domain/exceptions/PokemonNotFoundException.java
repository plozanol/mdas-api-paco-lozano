package pokedex.pokemonDetails.domain.exceptions;

public class PokemonNotFoundException extends IllegalArgumentException {
    public PokemonNotFoundException() { super("Pokemon name not found"); }
}
