package pokedex.pokemonType.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pokedex.pokemonType.domain.PokemonName;
import pokedex.pokemonType.domain.PokemonTypeCollection;
import pokedex.pokemonType.domain.PokemonTypeRepository;
import pokedex.pokemonType.domain.exceptions.EmptyPokemonNameParameterException;
import pokedex.pokemonType.domain.exceptions.PokemonNotFoundException;
import pokedex.pokemonType.domain.exceptions.PokemonTypeRepositoryConnectionException;
import pokedex.pokemonType.domain.exceptions.PokemonWithoutTypesException;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetPokemonTypesTest {

    @Mock
    private PokemonTypeRepository pokemonTypeRepository;

    @Test
    void shouldReturnCorrectPokemonTypes(){
        // GIVEN
        try {
            GetPokemonTypes getPokemonTypes = new GetPokemonTypes(pokemonTypeRepository);
            when(pokemonTypeRepository.get(any(PokemonName.class))).thenReturn(any(PokemonTypeCollection.class));
            // WHEN
            getPokemonTypes.execute("");

            // THEN
            Mockito.verify(pokemonTypeRepository).get(any(PokemonName.class));
        } catch (PokemonWithoutTypesException | PokemonTypeRepositoryConnectionException |
                 EmptyPokemonNameParameterException | PokemonNotFoundException e) {
            fail();
        }


    }
}
