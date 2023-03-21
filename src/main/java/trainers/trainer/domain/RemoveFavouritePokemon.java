package trainers.trainer.domain;

import trainers.trainer.domain.exceptions.PokemonNotExistInFavouritePokemons;
import trainers.trainer.domain.exceptions.TrainerDontExist;

public class RemoveFavouritePokemon {
    private final TrainerRepository trainerRepository;

    public RemoveFavouritePokemon(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public void execute(TrainerID ID, PokemonID pokemonID) throws TrainerDontExist, PokemonNotExistInFavouritePokemons {
        trainerExistGuard(ID);
        Trainer trainer = trainerRepository.get(ID);
        trainer.removeFavouritePokemon(pokemonID);
        trainerRepository.update(trainer);
    }

    private void trainerExistGuard(TrainerID id) throws TrainerDontExist {
        if (!trainerRepository.exist(id)) {
            throw new TrainerDontExist();
        }
    }
}
