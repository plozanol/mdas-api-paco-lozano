package pokemonType.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pokedex.pokemonType.application.GetPokemonTypes;
import pokedex.pokemonType.domain.PokemonName;
import pokedex.pokemonType.domain.PokemonTypeRepository;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetPokemonTypesTest {

    @Mock
    private PokemonTypeRepository pokemonTypeRepository;

    @Test
    void shouldReturnCorrectPokemonTypes() {
        // GIVEN
        /*GetPokemonTypes getPokemonTypes = new GetPokemonTypes(pokemonTypeRepository);
        when(pokemonTypeRepository.get(new PokemonName("")).thenReturn(""));

        // WHEN
        getPokemonTypes.execute("");

        // THEN
        Mockito.verify(pokemonTypeRepository).get(new PokemonName(""));*/
    }
}
