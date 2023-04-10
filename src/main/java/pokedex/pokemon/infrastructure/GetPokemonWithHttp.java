package pokedex.pokemon.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pokedex.pokemon.application.GetPokemon;
import pokedex.pokemon.domain.Pokemon;
import pokedex.pokemon.domain.exceptions.PokemonNotFoundException;
import pokedex.pokemon.domain.exceptions.PokemonRepositoryConnectionException;
import shared.infrastructure.exceptions.NotNumericPokemonIdException;
import trainers.trainer.domain.exceptions.TrainerAlreadyCreatedException;

@RestController
public class GetPokemonWithHttp {
    @GetMapping("/get-pokemon-details-by-id")
    public static String getPokemonDetailsByID(@RequestParam(name="pokemonId") String stringPokemonId) {
        var pokemonID = parsePokemonId(stringPokemonId);
        var getPokemonDetails = new GetPokemon(new PokeApiPokemonRepository());
        Pokemon pokemonTypeCollection = getPokemonDetails.execute(pokemonID);
        return transformToJSON(pokemonTypeCollection);
    }

    @ExceptionHandler(PokemonNotFoundException.class)
    public ResponseEntity<String> handlePokemonNotFoundException(PokemonNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("ConnectionError");
    }

    @ExceptionHandler(PokemonRepositoryConnectionException.class)
    public ResponseEntity<String> handlePokemonDetailRepositoryConnectionException(PokemonRepositoryConnectionException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("ConnectionError");
    }

    @ExceptionHandler(TrainerAlreadyCreatedException.class)
    public ResponseEntity<String> handleTrainerAlreadyCreatedException(TrainerAlreadyCreatedException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("TrainerAlreadyCreatedException");
    }

    private static int parsePokemonId(String stringPokemonId) {
        int pokemonId = 0;
        try {
            pokemonId = Integer.parseInt(stringPokemonId);
        } catch (NumberFormatException e) {
            throw new NotNumericPokemonIdException();
        }
        return pokemonId;
    }

    private static String transformToJSON(Pokemon pokemonTypeCollection) {
        return String.format("""
                    {
                        "id":"%d",
                        "name":"%s",
                        "height":"%G",
                        "weight":"%G"
                    }
                    """,
                pokemonTypeCollection.ID().ID(),
                pokemonTypeCollection.name().toString(),
                pokemonTypeCollection.height().height(),
                pokemonTypeCollection.weight().weight()
        );
    }
}


