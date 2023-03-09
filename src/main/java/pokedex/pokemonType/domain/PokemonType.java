package pokedex.pokemonType.domain;


public class PokemonType {
    private final String type;
    public PokemonType(String type){
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
