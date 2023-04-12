package trainers.trainer.application;

import trainers.trainer.domain.PokemonID;
import trainers.trainer.domain.TrainerID;
import trainers.trainer.domain.TrainerRemoveFavouritePokemon;
import trainers.trainer.domain.TrainerRepository;

public class RemoveFavouritePokemon {
    public RemoveFavouritePokemon(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    private final TrainerRepository trainerRepository;

    public void execute(String trainerId, int pokemonID) {
        var addFavouritePokemon = new TrainerRemoveFavouritePokemon(trainerRepository);
        addFavouritePokemon.execute(new TrainerID(trainerId), new PokemonID(pokemonID));
    }
}
