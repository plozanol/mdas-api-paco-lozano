package trainers.trainer.domain;

import trainers.trainer.domain.exceptions.PokemonAlredyExistInFavouritePokemons;
import trainers.trainer.domain.exceptions.TrainerDontExist;

public class AddFavouritePokemon {
    private final TrainerRepository trainerRepository;

    public AddFavouritePokemon(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public void execute(TrainerID ID, PokemonID pokemonID) throws TrainerDontExist, PokemonAlredyExistInFavouritePokemons {
        trainerExistGuard(ID);
        Trainer trainer = trainerRepository.get(ID);
        trainer.addFavouritePokemon(pokemonID);
        trainerRepository.update(trainer);
    }

    private void trainerExistGuard(TrainerID id) throws TrainerDontExist {
        if (!trainerRepository.exist(id)) {
            throw new TrainerDontExist();
        }
    }
}
