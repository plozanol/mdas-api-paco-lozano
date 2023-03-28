package pokedex.pokemonDetails.domain.exceptions;

public class PokemonNotFoundException extends Exception {
    public PokemonNotFoundException() { super("Pokemon name not found"); }
}
