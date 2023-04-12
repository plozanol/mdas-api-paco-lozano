package trainers.trainer.domain;

import shared.domain.DomainEvent;
import trainers.trainer.domain.exceptions.TrainerDontExistException;

import java.util.HashSet;
import java.util.Set;

public class TrainerAddFavouritePokemon {
    private final TrainerRepository trainerRepository;

    private final Set events = new HashSet<DomainEvent>();

    public TrainerAddFavouritePokemon(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public void execute(TrainerID ID, PokemonID pokemonID) {
        trainerExistGuard(ID);
        Trainer trainer = trainerRepository.get(ID);
        trainer.addFavouritePokemon(pokemonID);
        trainerRepository.update(trainer);
        raise(new FavouritePokemonAddedEvent(pokemonID.toString()));
    }

    private void trainerExistGuard(TrainerID id) {
        if (!trainerRepository.exist(id)) {
            throw new TrainerDontExistException();
        }
    }

    private void raise(DomainEvent event) {
        events.add(event);
    }

    public Set<DomainEvent> pullDomainEvents() {
        var recordedEvents = Set.copyOf(events);
        events.clear();
        return recordedEvents;
    }

}
