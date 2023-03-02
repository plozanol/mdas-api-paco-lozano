package pokedex.pokemon.domain;


public class PokemonType {
    private String type;
    public PokemonType(String type){
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
