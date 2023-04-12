package trainers.trainer.application;

import org.springframework.stereotype.Service;
import shared.domain.EventPublisher;
import trainers.trainer.domain.PokemonID;
import trainers.trainer.domain.TrainerAddFavouritePokemon;
import trainers.trainer.domain.TrainerID;
import trainers.trainer.domain.TrainerRepository;

@Service
public class AddFavouritePokemon {
    private final TrainerRepository trainerRepository;

    private final TrainerAddFavouritePokemon trainerAddFavouritePokemon;

    private final EventPublisher eventPublisher;

    public AddFavouritePokemon(TrainerRepository trainerRepository, EventPublisher eventPublisher) {
        this.trainerRepository = trainerRepository;
        this.trainerAddFavouritePokemon = new TrainerAddFavouritePokemon(trainerRepository);
        this.eventPublisher = eventPublisher;
    }

    public void execute(String trainerId, int pokemonID) {
        trainerAddFavouritePokemon.execute(new TrainerID(trainerId), new PokemonID(pokemonID));
        eventPublisher.publish(trainerAddFavouritePokemon.pullDomainEvents());
    }
}
