package pokedex.pokemonDetails.domain;

public class PokemonDetail {
    private final PokemonID ID;
    private final PokemonName name;
    private final PokemonHeight height;
    private final PokemonWeight weight;

    public PokemonDetail(PokemonID ID,
                         PokemonName name,
                         PokemonHeight height,
                         PokemonWeight weight) {
        this.ID = ID;
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public PokemonID ID() {
        return ID;
    }

    public PokemonName name() {
        return name;
    }

    public PokemonHeight height() {
        return height;
    }

    public PokemonWeight weight() {
        return weight;
    }
}
