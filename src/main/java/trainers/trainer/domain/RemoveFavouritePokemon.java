package trainers.trainer.domain;

import trainers.trainer.domain.exceptions.TrainerDontExistException;

public class RemoveFavouritePokemon {
    private final TrainerRepository trainerRepository;

    public RemoveFavouritePokemon(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public void execute(TrainerID ID, PokemonID pokemonID) {
        trainerExistGuard(ID);
        Trainer trainer = trainerRepository.get(ID);
        trainer.removeFavouritePokemon(pokemonID);
        trainerRepository.update(trainer);
    }

    private void trainerExistGuard(TrainerID id) {
        if (!trainerRepository.exist(id)) {
            throw new TrainerDontExistException();
        }
    }
}
