package trainer.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pokedex.pokemonType.domain.PokemonType;
import pokedex.pokemonType.domain.PokemonTypeCollection;
import pokedex.pokemonType.domain.exceptions.PokemonWithoutTypesException;
import trainers.trainer.domain.FavouritePokemons;
import trainers.trainer.domain.PokemonID;
import trainers.trainer.domain.exceptions.PokemonAlreadyExistInFavouritePokemonsException;
import trainers.trainer.domain.exceptions.PokemonIdOutOfRangeException;
import trainers.trainer.domain.exceptions.PokemonNotExistInFavouritePokemonsException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class FavouritePokemonsTest {
    @Test
    void shouldBeAbleToAddPokemonToAnEmptyCollection() {
        try {
            // GIVEN
            PokemonID pokemonID = new PokemonID(1);
            FavouritePokemons favouritePokemons = new FavouritePokemons();
            // THEN
            assertDoesNotThrow(() -> favouritePokemons.addFavouritePokemon(pokemonID));

        } catch (PokemonIdOutOfRangeException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void shouldThrowException_whenAddingExistingPokemon() {
        try {
            // GIVEN
            PokemonID pokemonID = new PokemonID(1);
            FavouritePokemons favouritePokemons = new FavouritePokemons();
            // THEN
            favouritePokemons.addFavouritePokemon(pokemonID);
            assertThrows(PokemonAlreadyExistInFavouritePokemonsException.class, () -> favouritePokemons.addFavouritePokemon(pokemonID));
        } catch (PokemonIdOutOfRangeException | PokemonAlreadyExistInFavouritePokemonsException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void shouldBeAbleToAddMultiplePokemons() {
        try {
            // GIVEN
            PokemonID firstPokemonID = new PokemonID(1);
            PokemonID secondPokemonID = new PokemonID(2);
            FavouritePokemons favouritePokemons = new FavouritePokemons();
            // THEN
            assertDoesNotThrow(() -> favouritePokemons.addFavouritePokemon(firstPokemonID));
            assertDoesNotThrow(() -> favouritePokemons.addFavouritePokemon(secondPokemonID));


        } catch (PokemonIdOutOfRangeException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void shouldBeAbleToDeleteExistingPokemons() {
        try {
            // GIVEN
            PokemonID firstPokemonID = new PokemonID(1);
            FavouritePokemons favouritePokemons = new FavouritePokemons();
            // THEN
            assertDoesNotThrow(() -> favouritePokemons.addFavouritePokemon(firstPokemonID));
            assertDoesNotThrow(() -> favouritePokemons.removeFavouritePokemon(firstPokemonID));


        } catch (PokemonIdOutOfRangeException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void shouldThrowAnException_onDeleteNonExistingPokemon() {
        try {
            // GIVEN
            PokemonID pokemonID = new PokemonID(1);
            FavouritePokemons favouritePokemons = new FavouritePokemons();
            // THEN
            assertThrows(PokemonNotExistInFavouritePokemonsException.class, () -> favouritePokemons.removeFavouritePokemon(pokemonID));
        } catch (PokemonIdOutOfRangeException e) {
            throw new RuntimeException(e);
        }
    }
}
