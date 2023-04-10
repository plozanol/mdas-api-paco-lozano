package trainers.trainer.application;

import trainers.trainer.domain.TrainerCreator;
import trainers.trainer.domain.TrainerID;
import trainers.trainer.domain.TrainerRepository;

public class CreateTrainer {
    private final TrainerRepository trainerRepository;

    public CreateTrainer(TrainerRepository trainerRepository){
        this.trainerRepository = trainerRepository;
    }

    public void execute(String ID) {
        new TrainerCreator(trainerRepository).execute(new TrainerID(ID));
    }
}
