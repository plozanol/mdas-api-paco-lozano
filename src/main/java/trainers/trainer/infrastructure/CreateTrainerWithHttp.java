package trainers.trainer.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import trainers.trainer.application.CreateTrainer;
import trainers.trainer.domain.exceptions.TrainerAlredyCreated;

@RestController
public class CreateTrainerWithHttp {
    @GetMapping("CreateTrainer/{ID}")
    public static void CreateTrainer(@PathVariable String ID) {
        var trainerRepoository = new InMemoryTrainerRepository();
        var createTrainer = new CreateTrainer(trainerRepoository);

        blankIdGuard(ID);
        try {
            createTrainer.execute(ID);
        } catch (TrainerAlredyCreated e) {
            //TODO check HTTP STATUS
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"TrainerAlredyCreated");
        }
    }

    private static void blankIdGuard(String ID) {
        if (ID.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "blankID");
        }
    }
}


