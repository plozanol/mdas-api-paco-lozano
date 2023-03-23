package trainers.trainer.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import trainers.trainer.domain.exceptions.PokemonIdOutOfRangeException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PokemonIDTest {

    @ParameterizedTest
    @ValueSource(ints = { 0, 899 })
    void shouldThrowException_ifPokemonIDOutOfRange(int id) {
        assertThrows(PokemonIdOutOfRangeException.class, () -> new PokemonID(id));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 200, 898 })
    void shouldNotThrowException_ifPokemonIDInsideRange(int id) {
        assertDoesNotThrow(() -> new PokemonID(id));
    }

}
