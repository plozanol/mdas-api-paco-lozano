package trainers.trainer.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import trainers.trainer.application.AddFavouritePokemon;
import trainers.trainer.domain.exceptions.PokemonAlredyExistInFavouritePokemons;
import trainers.trainer.domain.exceptions.PokemonIdOutOfRangeException;
import trainers.trainer.domain.exceptions.TrainerDontExist;

@RestController
public class AddFavouritePokemonToTrainerWithHttp {
    @GetMapping("AddFavouritePokemonToTrainer/{pokemonID}")
    public static void AddFavouritePokemonToTrainer(@RequestHeader("user_id") String trainerID, @PathVariable int pokemonID) {
        var trainerRepository = new InMemoryTrainerRepository();
        var addFavouritePokemon = new AddFavouritePokemon(trainerRepository);
        blankIdGuard(trainerID);

        try {
            addFavouritePokemon.execute(trainerID,pokemonID);
        } catch (TrainerDontExist e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"TrainerDontExist");
        } catch (PokemonAlredyExistInFavouritePokemons e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"PokemonAlreadyExistInFavouritePokemons");
        } catch (PokemonIdOutOfRangeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"PokemonIdOutOfRangeException");
        }
    }

    private static void blankIdGuard(String ID) {
        if (ID.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "blankID");
        }
    }
}


