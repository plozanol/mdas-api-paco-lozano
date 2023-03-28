package pokedex.pokemonDetails.domain;

import org.junit.jupiter.api.Test;
import pokedex.pokemonDetails.domain.exceptions.PokemonNameNotEmptyException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PokemonNameTest {

    @Test
    void shouldThrowException_whenNameIsEmpty() {
        assertThrows(PokemonNameNotEmptyException.class, () -> new PokemonName(""));
    }
}
