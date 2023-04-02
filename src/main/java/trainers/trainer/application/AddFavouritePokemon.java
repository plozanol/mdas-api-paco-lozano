package trainers.trainer.application;

import trainers.trainer.domain.PokemonID;
import trainers.trainer.domain.TrainerID;
import trainers.trainer.domain.TrainerRepository;
import trainers.trainer.domain.exceptions.PokemonAlreadyExistInFavouritePokemonsException;
import trainers.trainer.domain.exceptions.PokemonIdOutOfRangeException;
import trainers.trainer.domain.exceptions.TrainerDontExistException;
import trainers.trainer.shared.EventPublisher;

public class AddFavouritePokemon {
    private final TrainerRepository trainerRepository;
    private EventPublisher publisher;

    public AddFavouritePokemon(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public void execute(String trainerId, int pokemonID) throws PokemonIdOutOfRangeException, TrainerDontExistException, PokemonAlreadyExistInFavouritePokemonsException {
        var addFavouritePokemon = new trainers.trainer.domain.AddFavouritePokemon(trainerRepository);
        addFavouritePokemon.execute(new TrainerID(trainerId), new PokemonID(pokemonID));
        this.publisher.publish(addFavouritePokemon.pullDomainEvent());
    }
}
