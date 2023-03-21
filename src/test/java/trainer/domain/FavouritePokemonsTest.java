package trainer.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pokedex.pokemonType.domain.PokemonType;
import pokedex.pokemonType.domain.PokemonTypeCollection;
import trainers.trainer.domain.FavouritePokemons;
import trainers.trainer.domain.PokemonID;
import trainers.trainer.domain.exceptions.PokemonAlredyExistInFavouritePokemons;
import trainers.trainer.domain.exceptions.PokemonIdOutOfRangeException;
import trainers.trainer.domain.exceptions.PokemonNotExistInFavouritePokemons;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
        // GIVEN

        // THEN
    }

    @Test
    void shouldBeAbleToAddMultiplePokemons() {
        // GIVEN

        // THEN
    }

    @Test
    void shouldBeAbleToDeleteExistingPokemons() {
        // GIVEN

        // THEN
    }

    @Test
    void shouldThrowAnExceptionOnDeleteNonExistingPokemon() {
        // GIVEN

        // THEN
    }
}
