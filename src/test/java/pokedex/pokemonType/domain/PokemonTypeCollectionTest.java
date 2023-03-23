package pokedex.pokemonType.domain;

import org.junit.jupiter.api.Test;
import pokedex.pokemonType.domain.exceptions.PokemonWithoutTypesException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PokemonTypeCollectionTest {
    @Test
    void shouldThrowPokemonWithoutTypesException_whenTypesIsEmptyArray() {
        assertThrows(PokemonWithoutTypesException.class, () -> new PokemonTypeCollection(new PokemonType[0]));
    }

    @Test
    void canCreateAPokemonTypeWithOneType() {
        // GIVEN
        PokemonType[] pokemonTypes = new PokemonType[]{new PokemonType("hi")};

        // THEN
        assertDoesNotThrow(() -> new PokemonTypeCollection(pokemonTypes));
    }
}
