package trainers.trainer.domain;

import trainers.trainer.domain.exceptions.PokemonAlreadyExistInFavouritePokemonsException;
import trainers.trainer.domain.exceptions.TrainerDontExistException;

public class AddFavouritePokemon {
    private final TrainerRepository trainerRepository;

    public AddFavouritePokemon(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public void execute(TrainerID ID, PokemonID pokemonID) throws TrainerDontExistException, PokemonAlreadyExistInFavouritePokemonsException {
        trainerExistGuard(ID);
        Trainer trainer = trainerRepository.get(ID);
        trainer.addFavouritePokemon(pokemonID);
        trainerRepository.update(trainer);
    }

    private void trainerExistGuard(TrainerID id) throws TrainerDontExistException {
        if (!trainerRepository.exist(id)) {
            throw new TrainerDontExistException();
        }
    }
}
