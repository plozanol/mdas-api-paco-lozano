package pokedex.pokemonDetails.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pokedex.pokemonDetails.domain.exceptions.PokemonNegativeWeightException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PokemonWeightTest {

    @ParameterizedTest
    @ValueSource(doubles = { -0.3, -20, Double.NEGATIVE_INFINITY })
    void shouldThrowException_whenWeightIsNegative(double height) {
        assertThrows(PokemonNegativeWeightException.class, () -> new PokemonWeight(height));
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0, 10.30414813658, Double.POSITIVE_INFINITY })
    void shouldNotThrowException_whenWeightIsPositive(double height) {
        assertDoesNotThrow(() -> { new PokemonWeight(height); });
    }

}
