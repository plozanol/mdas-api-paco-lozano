package trainers.trainer.domain;

import trainers.trainer.domain.exceptions.PokemonAlreadyExistInFavouritePokemonsException;
import trainers.trainer.domain.exceptions.PokemonNotExistInFavouritePokemonsException;

import java.util.HashSet;
import java.util.Set;

public class FavouritePokemons {

    Set<PokemonID> favouritePokemonsIds;

    public FavouritePokemons() {
        favouritePokemonsIds = new HashSet<>();
    }

    public void addFavouritePokemon(PokemonID pokemonID) {
        guardPokemonIdDuplicated(pokemonID);
        favouritePokemonsIds.add(pokemonID);
    }

    private void guardPokemonIdDuplicated(PokemonID pokemonID) {
        if (pokemonExist(pokemonID)) {
            throw new PokemonAlreadyExistInFavouritePokemonsException();
        }
    }

    public void removeFavouritePokemon(PokemonID pokemonID) {
        guardPokemonIdExist(pokemonID);
        favouritePokemonsIds.remove(pokemonID);
    }

    private void guardPokemonIdExist(PokemonID pokemonID) {
        if (!pokemonExist(pokemonID)) {
            throw new PokemonNotExistInFavouritePokemonsException();
        }
    }

    public boolean pokemonExist(PokemonID pokemonID) {
        return favouritePokemonsIds.contains(pokemonID);
    }
}
