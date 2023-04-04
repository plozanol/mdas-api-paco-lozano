package trainers.trainer.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pokedex.pokemonDetails.infrastructure.exceptions.NotNumericPokemonIdException;
import trainers.trainer.application.AddFavouritePokemon;
import trainers.trainer.domain.exceptions.PokemonAlreadyExistInFavouritePokemonsException;
import trainers.trainer.domain.exceptions.PokemonIdOutOfRangeException;
import trainers.trainer.domain.exceptions.TrainerDontExistException;

@RestController
public class AddFavouritePokemonToTrainerWithHttp {
    @GetMapping("AddFavouritePokemonToTrainer")
    public ResponseEntity<String> AddFavouritePokemonToTrainer(@RequestHeader("user_id") String trainerID, @RequestParam(name="pokemonId") String stringPokemonId) {
        blankIdGuard(trainerID);
        var pokemonID = parsePokemonId(stringPokemonId);
        var trainerRepository = new InMemoryTrainerRepository();
        var addFavouritePokemon = new AddFavouritePokemon(trainerRepository);

        try {
            addFavouritePokemon.execute(trainerID,pokemonID);
        } catch (TrainerDontExistException e) {
            return ResponseEntity.badRequest().body("TrainerDontExistException");
        } catch (PokemonAlreadyExistInFavouritePokemonsException e) {
            return ResponseEntity.badRequest().body("PokemonAlreadyExistInFavouritePokemons");
        } catch (PokemonIdOutOfRangeException e) {
            return ResponseEntity.badRequest().body("PokemonIdOutOfRangeException");
        }

        return ResponseEntity.ok().body("ok");
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


