package trainers.trainer.domain;

import trainers.trainer.domain.exceptions.PokemonAlredyExistInFavouritePokemons;
import trainers.trainer.domain.exceptions.PokemonNotExistInFavouritePokemons;

public class Trainer {
    private final TrainerID ID;
    private final FavouritePokemons favoritePokemons;

    public Trainer(TrainerID ID) {
        this.ID = ID;
        this.favoritePokemons = new FavouritePokemons();
    }

    public TrainerID ID() {
        return ID;
    }

    public void addFavouritePokemon(PokemonID pokemonID) throws PokemonAlredyExistInFavouritePokemons {
        favoritePokemons.addFavouritePokemon(pokemonID);
    }

    public void removeFavouritePokemon(PokemonID pokemonID) throws PokemonNotExistInFavouritePokemons {
        favoritePokemons.removeFavouritePokemon(pokemonID);
    }
}
