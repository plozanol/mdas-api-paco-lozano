package trainer.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import trainers.trainer.domain.PokemonID;
import trainers.trainer.domain.exceptions.PokemonIdOutOfRangeException;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonIDTest {

    @ParameterizedTest
    @ValueSource(ints = { -1, 0, 899 })
    void shouldThrowException_ifPokemonIDOutOfRange(int id) {
        assertThrows(PokemonIdOutOfRangeException.class, () -> new PokemonID(id));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 200, 898 })
    void shouldNotThrowException_ifPokemonIDInsideRange(int id) {
        assertThrows(PokemonIdOutOfRangeException.class, () -> new PokemonID(id));
    }

}
