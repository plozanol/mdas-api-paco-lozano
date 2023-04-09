package trainers.trainer.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import trainers.trainer.application.CreateTrainer;
import trainers.trainer.domain.exceptions.PokemonIdOutOfRangeException;
import trainers.trainer.domain.exceptions.TrainerAlreadyCreatedException;

@RestController
public class CreateTrainerWithHttp {
    @GetMapping("create-trainer")
    public static void CreateTrainer(@RequestParam String id) {
        var trainerRepoository = new InMemoryTrainerRepository();
        var createTrainer = new CreateTrainer(trainerRepoository);
        blankIdGuard(id);
        createTrainer.execute(id);
    }

    @ExceptionHandler(TrainerAlreadyCreatedException.class)
    public ResponseEntity<String> handleTrainerAlreadyCreatedException(TrainerAlreadyCreatedException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("TrainerAlreadyCreatedException");
    }

    private static void blankIdGuard(String ID) {
        if (ID.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "blankID");
        }
    }
}


