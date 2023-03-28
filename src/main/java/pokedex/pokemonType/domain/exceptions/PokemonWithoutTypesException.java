package pokedex.pokemonType.domain.exceptions;

public class PokemonWithoutTypesException extends Exception {
    public PokemonWithoutTypesException(){
        super("A pokemon should have more types");
    }
}
