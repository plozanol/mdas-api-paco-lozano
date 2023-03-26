package pokedex.pokemonType.infrastructure;

import org.junit.jupiter.api.Test;
import pokedex.pokemonType.application.GetPokemonTypes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class GetPokemonTypesTestIT {


    @Test
    void shouldReturnCorrectPokemonTypes() {
        // GIVEN
        var mock = new PokeapiMock();
        mock.addGloomResponse();

        var pokemonTypeRepository = new PokeApiPokemonTypeRepository("http://127.0.0.1:9080/pokeapiMock/");

        GetPokemonTypes getPokemonTypes = new GetPokemonTypes(pokemonTypeRepository);

        // THEN
        assertDoesNotThrow(() ->getPokemonTypes.execute("gloom"));
    }
}