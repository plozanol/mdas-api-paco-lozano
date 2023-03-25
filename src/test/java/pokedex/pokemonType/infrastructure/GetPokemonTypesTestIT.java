package pokedex.pokemonType.infrastructure;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;
import pokedex.pokemonType.application.GetPokemonTypes;
import pokedex.pokemonType.domain.PokemonName;
import pokedex.pokemonType.domain.PokemonTypeCollection;
import pokedex.pokemonType.domain.PokemonTypeRepository;
import trainers.trainer.domain.exceptions.TrainerDontExistException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class GetPokemonTypesTestIT {


    @Test
    void shouldReturnCorrectPokemonTypes() {
        // GIVEN
        var mock = new PokeapiMock();
        mock.addGloomResponse();

        var pokemonTypeRepository = new PokeApiPokemonTypeRepository("localhost:1080/pokeapiMock/");

        GetPokemonTypes getPokemonTypes = new GetPokemonTypes(pokemonTypeRepository);

        // WHEN
        var pokemonTypeCollection = getPokemonTypes.execute("gloom");

        // THEN
        assertDoesNotThrow(() ->getPokemonTypes.execute("gloom"));
    }
}