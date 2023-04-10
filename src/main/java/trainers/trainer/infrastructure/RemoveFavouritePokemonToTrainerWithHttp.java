package trainers.trainer.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import shared.infrastructure.exceptions.NotNumericPokemonIdException;
import trainers.trainer.application.RemoveFavouritePokemon;
import trainers.trainer.domain.exceptions.PokemonIdOutOfRangeException;
import trainers.trainer.domain.exceptions.PokemonNotExistInFavouritePokemonsException;
import trainers.trainer.domain.exceptions.TrainerDontExistException;

@RestController
public class RemoveFavouritePokemonToTrainerWithHttp {
    @DeleteMapping("/trainer/favourite-pokemon/{id}")
    public static void removeFavouritePokemonToTrainer(@RequestHeader("user_id") String trainerID, @PathVariable String id) {
        blankIdGuard(trainerID);
        var pokemonID = parsePokemonId(id);
        var trainerRepository = new InMemoryTrainerRepository();
        var removeFavouritePokemon = new RemoveFavouritePokemon(trainerRepository);
        removeFavouritePokemon.execute(trainerID,pokemonID);
    }

    @ExceptionHandler(TrainerDontExistException.class)
    public ResponseEntity<String> handleTrainerDontExistException(TrainerDontExistException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("TrainerDontExistException");
    }

    @ExceptionHandler(PokemonIdOutOfRangeException.class)
    public ResponseEntity<String> handlePokemonIdOutOfRangeException(PokemonIdOutOfRangeException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("PokemonIdOutOfRangeException");
    }

    @ExceptionHandler(PokemonNotExistInFavouritePokemonsException.class)
    public ResponseEntity<String> handlePokemonNotExistInFavouritePokemonsException(PokemonNotExistInFavouritePokemonsException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("PokemonNotExistInFavouritePokemonsException");
    }

    private static void blankIdGuard(String ID) {
        if (ID.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "blankID");
        }
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
}


