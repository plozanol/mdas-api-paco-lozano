package trainers.trainer.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import trainers.trainer.application.CreateTrainer;
import trainers.trainer.domain.exceptions.TrainerAlreadyCreatedException;

@RestController
public class CreateTrainerWithHttp {
    @GetMapping("CreateTrainer")
    public static void CreateTrainer(@RequestParam String id) {
        var trainerRepoository = new InMemoryTrainerRepository();
        var createTrainer = new CreateTrainer(trainerRepoository);

        blankIdGuard(id);
        try {
            createTrainer.execute(id);
        } catch (TrainerAlreadyCreatedException e) {
            //TODO check HTTP STATUS
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"TrainerAlreadyCreatedException");
        }
    }

    private static void blankIdGuard(String ID) {
        if (ID.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "blankID");
        }
    }
}


