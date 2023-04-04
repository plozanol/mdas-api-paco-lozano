package trainers.trainer.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import shared.infrastructure.exceptions.NotNumericPokemonIdException;
import trainers.trainer.application.RemoveFavouritePokemon;
import trainers.trainer.domain.exceptions.PokemonIdOutOfRangeException;
import trainers.trainer.domain.exceptions.PokemonNotExistInFavouritePokemonsException;
import trainers.trainer.domain.exceptions.TrainerDontExistException;

@RestController
public class RemoveFavouritePokemonToTrainerWithHttp {
    @GetMapping("remove-favourite-pokemon-to-trainer")
    public static void RemoveFavouritePokemonToTrainer(@RequestHeader("user_id") String trainerID, @RequestParam(name="pokemonId") String stringPokemonId) {
        blankIdGuard(trainerID);
        var pokemonID = parsePokemonId(stringPokemonId);
        var trainerRepository = new InMemoryTrainerRepository();
        var removeFavouritePokemon = new RemoveFavouritePokemon(trainerRepository);

        try {
            removeFavouritePokemon.execute(trainerID,pokemonID);
        } catch (TrainerDontExistException e) {
            //TODO check HTTP STATUS
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"TrainerDontExistException");
        } catch (PokemonIdOutOfRangeException e) {
            //TODO check HTTP STATUS
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"PokemonIdOutOfRangeException");
        } catch (PokemonNotExistInFavouritePokemonsException e) {
            //TODO check HTTP STATUS
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"PokemonNotExistInFavouritePokemonsException");
        }
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


