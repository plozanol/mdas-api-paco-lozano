package pokedex.pokemon.domain;

public class Pokemon {
    private final PokemonID ID;
    private final PokemonName name;
    private final PokemonHeight height;
    private final PokemonWeight weight;

    private final PokemonFavouriteCounter favouriteCounter;

    public Pokemon(PokemonID ID,
                   PokemonName name,
                   PokemonHeight height,
                   PokemonWeight weight) {
        this.ID = ID;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.favouriteCounter = new PokemonFavouriteCounter(0);
    }

    public Pokemon(Pokemon pokemon, int counter) {
        this.ID = pokemon.ID;
        this.name = pokemon.name;
        this.height = pokemon.height;
        this.weight = pokemon.weight;
        this.favouriteCounter = new PokemonFavouriteCounter(counter);
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

    public PokemonFavouriteCounter favouriteCounter() {
        return favouriteCounter;
    }

}
