package trainers.trainer.domain;

import shared.domain.DomainEvent;

public class FavouritePokemonAddedEvent extends DomainEvent {

    private static final String FAVOURITE_POKEMON_EVENT_TYPE = "favourite.pokemon.added";

    public FavouritePokemonAddedEvent(String aggregateId) {
        super(aggregateId);
    }

    @Override
    public String routingKey() {
        return FAVOURITE_POKEMON_EVENT_TYPE;
    }

    public String aggregateId() {
        return super.aggregateId;
    }

}
