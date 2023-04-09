package pokedex.pokemonDetails.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pokedex.pokemonDetails.application.GetPokemonDetails;
import pokedex.pokemonDetails.domain.PokemonDetail;
import pokedex.pokemonDetails.domain.exceptions.*;
import shared.infrastructure.exceptions.NotNumericPokemonIdException;
import trainers.trainer.domain.exceptions.TrainerAlreadyCreatedException;

@RestController
public class GetPokemonDetailsWithHttp {
    @GetMapping("/get-pokemon-details-by-id")
    public static String getPokemonDetailsByID(@RequestParam(name="pokemonId") String stringPokemonId) {
        var pokemonID = parsePokemonId(stringPokemonId);
        var getPokemonDetails = new GetPokemonDetails(new PokeApiPokemonDetailRepository());
        PokemonDetail pokemonTypeCollection = getPokemonDetails.execute(pokemonID);
        return transformToJSON(pokemonTypeCollection);
    }

    @ExceptionHandler({
                PokemonNameNotEmptyException.class,
                PokemonNegativeHeightException.class,
                PokemonIdOutOfRangeException.class,
                PokemonNegativeWeightException.class
    })
    public ResponseEntity<String> handleInvalidPokemonDataExceptions(TrainerAlreadyCreatedException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("InvalidPokemonData");
    }

    @ExceptionHandler(PokemonDetailRepositoryConnectionException.class)
    public ResponseEntity<String> handlePokemonDetailRepositoryConnectionException(PokemonDetailRepositoryConnectionException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("ConnectionError");
    }

    @ExceptionHandler(TrainerAlreadyCreatedException.class)
    public ResponseEntity<String> handleTrainerAlreadyCreatedException(TrainerAlreadyCreatedException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
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

    private static String transformToJSON(PokemonDetail pokemonTypeCollection) {
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


