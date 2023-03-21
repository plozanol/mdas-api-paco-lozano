package trainers.trainer.application;

import trainers.trainer.domain.PokemonID;
import trainers.trainer.domain.TrainerID;
import trainers.trainer.domain.TrainerRepository;
import trainers.trainer.domain.exceptions.PokemonAlreadyExistInFavouritePokemonsException;
import trainers.trainer.domain.exceptions.PokemonIdOutOfRangeException;
import trainers.trainer.domain.exceptions.TrainerDontExistException;

public class AddFavouritePokemon {
    public AddFavouritePokemon(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    private final TrainerRepository trainerRepository;

    public void execute(String trainerId, int pokemonID) throws PokemonIdOutOfRangeException, TrainerDontExistException, PokemonAlreadyExistInFavouritePokemonsException {
        var addFavouritePokemon = new trainers.trainer.domain.AddFavouritePokemon(trainerRepository);
        addFavouritePokemon.execute(new TrainerID(trainerId), new PokemonID(pokemonID));
    }
}
