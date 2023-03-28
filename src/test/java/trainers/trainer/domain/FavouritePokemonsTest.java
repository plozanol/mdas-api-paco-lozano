package trainers.trainer.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import trainers.trainer.domain.exceptions.PokemonAlreadyExistInFavouritePokemonsException;
import trainers.trainer.domain.exceptions.PokemonIdOutOfRangeException;
import trainers.trainer.domain.exceptions.PokemonNotExistInFavouritePokemonsException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FavouritePokemonsTest {
    @Test
    void shouldBeAbleToAddPokemonToAnEmptyCollection() {
        // GIVEN
        try {
            PokemonID pokemonID = new PokemonID(1);
            FavouritePokemons favouritePokemons = new FavouritePokemons();

            // THEN
            assertDoesNotThrow(() -> favouritePokemons.addFavouritePokemon(pokemonID));
        } catch (PokemonIdOutOfRangeException e) {
            fail();
        }

    }

    @Test
    void shouldThrowException_whenAddingExistingPokemon() {
        // GIVEN
        try {
            PokemonID pokemonID = new PokemonID(1);
            FavouritePokemons favouritePokemons = new FavouritePokemons();

            // THEN
            favouritePokemons.addFavouritePokemon(pokemonID);
            assertThrows(PokemonAlreadyExistInFavouritePokemonsException.class, () -> favouritePokemons.addFavouritePokemon(pokemonID));
        } catch (PokemonIdOutOfRangeException | PokemonAlreadyExistInFavouritePokemonsException e) {
            fail();
        }

    }

    @Test
    void shouldBeAbleToAddMultiplePokemons() {
        // GIVEN
        try {
            PokemonID firstPokemonID = new PokemonID(1);

            PokemonID secondPokemonID = new PokemonID(2);
            FavouritePokemons favouritePokemons = new FavouritePokemons();

            // THEN
            assertDoesNotThrow(() -> favouritePokemons.addFavouritePokemon(firstPokemonID));
            assertDoesNotThrow(() -> favouritePokemons.addFavouritePokemon(secondPokemonID));
        } catch (PokemonIdOutOfRangeException e) {
            fail();
        }
    }

    @Test
    void shouldBeAbleToDeleteExistingPokemons() {
        // GIVEN
        try {
            PokemonID firstPokemonID = new PokemonID(1);

            FavouritePokemons favouritePokemons = new FavouritePokemons();

            // THEN
            assertDoesNotThrow(() -> favouritePokemons.addFavouritePokemon(firstPokemonID));
            assertDoesNotThrow(() -> favouritePokemons.removeFavouritePokemon(firstPokemonID));
        } catch (PokemonIdOutOfRangeException e) {
            fail();
        }
    }

    @Test
    void shouldThrowAnException_onDeleteNonExistingPokemon() {
        // GIVEN

        try {
            PokemonID pokemonID = new PokemonID(1);

            FavouritePokemons favouritePokemons = new FavouritePokemons();

            // THEN
            assertThrows(PokemonNotExistInFavouritePokemonsException.class, () -> favouritePokemons.removeFavouritePokemon(pokemonID));
        } catch (PokemonIdOutOfRangeException e) {
            fail();
        }
    }
}
