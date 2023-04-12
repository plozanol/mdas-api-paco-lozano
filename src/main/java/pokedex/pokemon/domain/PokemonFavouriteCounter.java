package pokedex.pokemon.domain;

public class PokemonFavouriteCounter {
    private final int favouriteCounter;

    public PokemonFavouriteCounter(int favouriteCounter) {
        this.favouriteCounter = favouriteCounter;
    }

    public int favouriteCounter() {
        return favouriteCounter;
    }

}
