package trainers.trainer.domain;

import trainers.trainer.shared.DomainEvent;

public class FavouritePokemonAddedEvent extends DomainEvent {
    private PokemonID pokemonID;

    public FavouritePokemonAddedEvent(PokemonID pokemonID) {
        super(pokemonID.ID());
        this.pokemonID = pokemonID;
    }

    @Override
    public String type() {
        return "favouritePokemon.added";
    }
}
