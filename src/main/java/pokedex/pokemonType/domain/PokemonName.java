package pokedex.pokemonType.domain;


public class PokemonName {
    private final String name;
    public PokemonName(String type){
        this.name = type;
    }

    @Override
    public String toString() {
        return name;
    }
}
