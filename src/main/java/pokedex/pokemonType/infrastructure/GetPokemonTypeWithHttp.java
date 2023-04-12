package pokedex.pokemonType.infrastructure;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pokedex.pokemonType.application.GetPokemonTypes;
import pokedex.pokemonType.domain.PokemonType;
import pokedex.pokemonType.domain.PokemonTypeCollection;
import pokedex.pokemonType.domain.exceptions.EmptyPokemonNameParameterException;
import pokedex.pokemonType.domain.exceptions.PokemonNotFoundException;
import pokedex.pokemonType.domain.exceptions.PokemonTypeRepositoryConnectionException;
import pokedex.pokemonType.domain.exceptions.PokemonWithoutTypesException;

@RestController
public class GetPokemonTypeWithHttp {
    @GetMapping("/get-pokemon-types-by-name")
    public static String getPokemonTypesByName(@RequestParam String pokemonName) throws JSONException {
        var getPokemonType = new GetPokemonTypes(new PokeApiPokemonTypeRepository());
        if (pokemonName.isBlank()) {
            System.out.println("No correct input");
        }
        PokemonTypeCollection pokemonTypeCollection = getPokemonType.execute(pokemonName);
        return transformToJSON(pokemonTypeCollection);
    }

    @ExceptionHandler(PokemonNotFoundException.class)
    public ResponseEntity<String> handlePokemonNotFoundException(PokemonNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(EmptyPokemonNameParameterException.class)
    public ResponseEntity<String> handleEmptyPokemonNameParameterException(EmptyPokemonNameParameterException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }

    @ExceptionHandler(PokemonWithoutTypesException.class)
    public ResponseEntity<String> handlePokemonWithoutTypesException(PokemonWithoutTypesException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    @ExceptionHandler(PokemonTypeRepositoryConnectionException.class)
    public ResponseEntity<String> handlePokemonTypeRepositoryConnectionException(PokemonTypeRepositoryConnectionException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    private static String transformToJSON(PokemonTypeCollection pokemonTypeCollection) {
        var result =  new StringBuilder("[");
        for (PokemonType type : pokemonTypeCollection.getTypes()) {
            result.append(String.format("\"%s\",", type));
        }
        result.deleteCharAt(result.length()-1);
        result.append("]");
        return result.toString();
    }
}


