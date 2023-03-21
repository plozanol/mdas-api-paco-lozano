package trainers.trainer.application;

import trainers.trainer.domain.TrainerCreator;
import trainers.trainer.domain.TrainerID;
import trainers.trainer.domain.TrainerRepository;
import trainers.trainer.domain.exceptions.TrainerAlredyCreated;

public class CreateTrainer {
    private final TrainerRepository trainerRepository;

    public CreateTrainer(TrainerRepository trainerRepository){
        this.trainerRepository = trainerRepository;
    }

    public void execute(String ID) throws TrainerAlredyCreated {
        new TrainerCreator(trainerRepository).execute(new TrainerID(ID));
    }
}
