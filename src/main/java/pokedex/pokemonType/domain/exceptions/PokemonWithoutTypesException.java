package pokedex.pokemonType.domain.exceptions;

public class PokemonWithoutTypesException extends IllegalArgumentException {
    public PokemonWithoutTypesException(){
        super("A pokemon should have more types");
    }
}
