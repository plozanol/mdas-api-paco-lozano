package trainers.trainer.domain;

import trainers.trainer.domain.exceptions.PokemonNotExistInFavouritePokemonsException;
import trainers.trainer.domain.exceptions.TrainerDontExistException;

public class RemoveFavouritePokemon {
    private final TrainerRepository trainerRepository;

    public RemoveFavouritePokemon(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public void execute(TrainerID ID, PokemonID pokemonID) throws TrainerDontExistException, PokemonNotExistInFavouritePokemonsException {
        trainerExistGuard(ID);
        Trainer trainer = trainerRepository.get(ID);
        trainer.removeFavouritePokemon(pokemonID);
        trainerRepository.update(trainer);
    }

    private void trainerExistGuard(TrainerID id) throws TrainerDontExistException {
        if (!trainerRepository.exist(id)) {
            throw new TrainerDontExistException();
        }
    }
}
