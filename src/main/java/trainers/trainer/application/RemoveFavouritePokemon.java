package trainers.trainer.application;

import trainers.trainer.domain.PokemonID;
import trainers.trainer.domain.TrainerID;
import trainers.trainer.domain.TrainerRepository;
import trainers.trainer.domain.exceptions.PokemonIdOutOfRangeException;
import trainers.trainer.domain.exceptions.PokemonNotExistInFavouritePokemons;
import trainers.trainer.domain.exceptions.TrainerDontExist;

public class RemoveFavouritePokemon {
    public RemoveFavouritePokemon(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    private final TrainerRepository trainerRepository;

    public void execute(String trainerId, int pokemonID) throws PokemonIdOutOfRangeException, TrainerDontExist, PokemonNotExistInFavouritePokemons {
        var addFavouritePokemon = new trainers.trainer.domain.RemoveFavouritePokemon(trainerRepository);
        addFavouritePokemon.execute(new TrainerID(trainerId), new PokemonID(pokemonID));
    }
}
