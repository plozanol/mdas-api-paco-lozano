package trainers.trainer.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import trainers.trainer.domain.exceptions.PokemonAlreadyExistInFavouritePokemonsException;
import trainers.trainer.domain.exceptions.PokemonIdOutOfRangeException;
import trainers.trainer.domain.exceptions.PokemonNotExistInFavouritePokemonsException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class FavouritePokemonsTest {
    @Test
    void shouldBeAbleToAddPokemonToAnEmptyCollection() throws PokemonIdOutOfRangeException {
        // GIVEN
        PokemonID pokemonID = new PokemonID(1);
        FavouritePokemons favouritePokemons = new FavouritePokemons();

        // THEN
        assertDoesNotThrow(() -> favouritePokemons.addFavouritePokemon(pokemonID));
    }

    @Test
    void shouldThrowException_whenAddingExistingPokemon() throws PokemonIdOutOfRangeException, PokemonAlreadyExistInFavouritePokemonsException {
        // GIVEN
        PokemonID pokemonID = new PokemonID(1);
        FavouritePokemons favouritePokemons = new FavouritePokemons();

        // THEN
        favouritePokemons.addFavouritePokemon(pokemonID);
        assertThrows(PokemonAlreadyExistInFavouritePokemonsException.class, () -> favouritePokemons.addFavouritePokemon(pokemonID));
    }

    @Test
    void shouldBeAbleToAddMultiplePokemons() throws PokemonIdOutOfRangeException {
        // GIVEN
        PokemonID firstPokemonID = new PokemonID(1);
        PokemonID secondPokemonID = new PokemonID(2);
        FavouritePokemons favouritePokemons = new FavouritePokemons();

        // THEN
        assertDoesNotThrow(() -> favouritePokemons.addFavouritePokemon(firstPokemonID));
        assertDoesNotThrow(() -> favouritePokemons.addFavouritePokemon(secondPokemonID));
    }

    @Test
    void shouldBeAbleToDeleteExistingPokemons() throws PokemonIdOutOfRangeException {
        // GIVEN
        PokemonID firstPokemonID = new PokemonID(1);
        FavouritePokemons favouritePokemons = new FavouritePokemons();

        // THEN
        assertDoesNotThrow(() -> favouritePokemons.addFavouritePokemon(firstPokemonID));
        assertDoesNotThrow(() -> favouritePokemons.removeFavouritePokemon(firstPokemonID));
    }

    @Test
    void shouldThrowAnException_onDeleteNonExistingPokemon() throws PokemonIdOutOfRangeException {
        // GIVEN
        PokemonID pokemonID = new PokemonID(1);
        FavouritePokemons favouritePokemons = new FavouritePokemons();

        // THEN
        assertThrows(PokemonNotExistInFavouritePokemonsException.class, () -> favouritePokemons.removeFavouritePokemon(pokemonID));
    }
}
