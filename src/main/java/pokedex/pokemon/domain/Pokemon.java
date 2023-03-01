package pokedex.pokemon.domain;

import java.util.List;

public class Pokemon {
    private String name;
    private List<String> types;
    public Pokemon(String name, List<String> types){
        this.name = name;
        this.types = types;
    }

}
