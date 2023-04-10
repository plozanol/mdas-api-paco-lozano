package pokedex.pokemon.domain.exceptions;

public class PokemonRepositoryConnectionException extends IllegalArgumentException {
    public PokemonRepositoryConnectionException(String s) { super(s); }
}
