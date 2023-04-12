package pokedex.pokemon.infrastructure;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pokedex.pokemon.domain.Pokemon;
import pokedex.pokemon.domain.exceptions.PokemonNotFoundException;
import pokedex.pokemon.domain.exceptions.PokemonRepositoryConnectionException;
import shared.infrastructure.exceptions.NotNumericPokemonIdException;
import trainers.trainer.domain.exceptions.TrainerAlreadyCreatedException;

@RestController
public class GetPokemonWithHttp {

    private GetPokemonController getPokemonController;

    public GetPokemonWithHttp(GetPokemonController getPokemonController) {
        this.getPokemonController = getPokemonController;
    }

    @GetMapping("/get-pokemon-details-by-id")
    public String getPokemonDetailsByID(@RequestParam(name="pokemonId") String stringPokemonId) throws JSONException {
        var pokemonID = parsePokemonId(stringPokemonId);
        Pokemon pokemon = getPokemonController.execute(pokemonID);
        return transformToJSON(pokemon);
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

    private static String transformToJSON(Pokemon pokemon) {
        return String.format("""
                    {
                        "id":"%d",
                        "name":"%s",
                        "height":"%G",
                        "weight":"%G",
                        "favouriteCounter":"%d"
                    }
                    """,
                pokemon.ID().ID(),
                pokemon.name().toString(),
                pokemon.height().height(),
                pokemon.weight().weight(),
                pokemon.favouriteCounter().favouriteCounter()
        );
    }
}


