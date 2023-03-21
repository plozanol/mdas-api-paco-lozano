package trainers.trainer.domain;

import trainers.trainer.domain.exceptions.PokemonAlredyExistInFavouritePokemons;
import trainers.trainer.domain.exceptions.PokemonNotExistInFavouritePokemons;

import java.util.HashSet;
import java.util.Set;

public class FavouritePokemons {

    public FavouritePokemons() {
        favouritePokemonsIds = new HashSet<>();
    }

    Set<PokemonID> favouritePokemonsIds;

    public void addFavouritePokemon(PokemonID pokemonID) throws PokemonAlredyExistInFavouritePokemons {
        guardPokemonIdDuplicated(pokemonID);
        favouritePokemonsIds.add(pokemonID);
    }

    private void guardPokemonIdDuplicated(PokemonID pokemonID) throws PokemonAlredyExistInFavouritePokemons {
        if (pokemonExist(pokemonID)) {
            throw new PokemonAlredyExistInFavouritePokemons();
        }
    }

    public void removeFavouritePokemon(PokemonID pokemonID) throws PokemonNotExistInFavouritePokemons {
        guardPokemonIdExist(pokemonID);
        favouritePokemonsIds.remove(pokemonID);
    }

    private void guardPokemonIdExist(PokemonID pokemonID) throws PokemonNotExistInFavouritePokemons {
        if (!pokemonExist(pokemonID)) {
            throw new PokemonNotExistInFavouritePokemons();
        }
    }

    private boolean pokemonExist(PokemonID pokemonID) {
        return favouritePokemonsIds.contains(pokemonID);
    }
}
