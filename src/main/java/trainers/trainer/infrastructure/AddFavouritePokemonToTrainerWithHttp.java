package trainers.trainer.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import shared.infrastructure.exceptions.NotNumericPokemonIdException;
import trainers.trainer.application.AddFavouritePokemon;
import trainers.trainer.domain.exceptions.PokemonAlreadyExistInFavouritePokemonsException;
import trainers.trainer.domain.exceptions.PokemonIdOutOfRangeException;
import trainers.trainer.domain.exceptions.TrainerDontExistException;

@RestController
public class AddFavouritePokemonToTrainerWithHttp {

    private final AddFavouritePokemon addFavouritePokemon;

    public AddFavouritePokemonToTrainerWithHttp(AddFavouritePokemon addFavouritePokemon) {
        this.addFavouritePokemon = addFavouritePokemon;
    }

    @PatchMapping("/trainer/favourite-pokemon/{id}")
    public ResponseEntity<String> addFavouritePokemonToTrainer(@RequestHeader("user_id") String trainerID, @PathVariable String id) {
        blankIdGuard(trainerID);
        var pokemonID = parsePokemonId(id);
        addFavouritePokemon.execute(trainerID,pokemonID);
        return ResponseEntity.ok().body("ok");
    }

    @ExceptionHandler(TrainerDontExistException.class)
    public ResponseEntity<String> handleTrainerDontExistException(TrainerDontExistException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("TrainerDontExistException");
    }

    @ExceptionHandler(PokemonAlreadyExistInFavouritePokemonsException.class)
    public ResponseEntity<String> handlePokemonAlreadyExistInFavouritePokemonsException(PokemonAlreadyExistInFavouritePokemonsException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("PokemonAlreadyExistInFavouritePokemons");
    }

    @ExceptionHandler(PokemonIdOutOfRangeException.class)
    public ResponseEntity<String> handlePokemonIdOutOfRangeException(PokemonIdOutOfRangeException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("PokemonIdOutOfRangeException");
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


