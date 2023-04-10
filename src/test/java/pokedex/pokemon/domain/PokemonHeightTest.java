package pokedex.pokemon.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pokedex.pokemon.domain.exceptions.PokemonNegativeHeightException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PokemonHeightTest {

    @ParameterizedTest
    @ValueSource(doubles = { -0.3, -20, Double.NEGATIVE_INFINITY })
    void shouldThrowException_whenHeightIsNegative(double height) {
        assertThrows(PokemonNegativeHeightException.class, () -> new PokemonHeight(height));
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0, 10.30414813658, Double.POSITIVE_INFINITY })
    void shouldNotThrowException_whenHeightIsPositive(double height) {
        assertDoesNotThrow(() -> { new PokemonHeight(height); });
    }

}
