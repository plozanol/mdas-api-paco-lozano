package pokemonType.domain;

import org.junit.jupiter.api.Test;
import pokedex.pokemonType.domain.PokemonType;
import pokedex.pokemonType.domain.PokemonTypeCollection;
import pokedex.pokemonType.domain.exceptions.PokemonWithoutTypesException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonTypeCollectionTest {
    @Test
    void shouldThrowPokemonWithoutTypesException_whenTypesIsEmptyArray() {
        // GIVEN
        PokemonType[] emptyPokemonTypes = new ArrayList<PokemonType>().toArray(new PokemonType[0]);

        // THEN
        assertThrows(PokemonWithoutTypesException.class, () -> new PokemonTypeCollection(new PokemonType[] {}));
        assertThrows(PokemonWithoutTypesException.class, () -> new PokemonTypeCollection(emptyPokemonTypes));

    }

    @Test
    void canCreateAPokemonTypeWithOneType() {
        // GIVEN
        PokemonType[] emptyPokemonTypes = new PokemonType[]{new PokemonType("hi")};

        // THEN
        assertDoesNotThrow(() -> new PokemonTypeCollection(emptyPokemonTypes));
    }
}
