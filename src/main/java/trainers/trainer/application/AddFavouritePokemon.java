package trainers.trainer.application;

import trainers.trainer.domain.PokemonID;
import trainers.trainer.domain.TrainerID;
import trainers.trainer.domain.TrainerRepository;

public class AddFavouritePokemon {
    private final TrainerRepository trainerRepository;

    public AddFavouritePokemon(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public void execute(String trainerId, int pokemonID) {
        var addFavouritePokemon = new trainers.trainer.domain.AddFavouritePokemon(trainerRepository);
        addFavouritePokemon.execute(new TrainerID(trainerId), new PokemonID(pokemonID));
    }
}
