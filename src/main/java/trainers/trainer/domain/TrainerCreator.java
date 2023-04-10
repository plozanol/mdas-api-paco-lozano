package trainers.trainer.domain;

import trainers.trainer.domain.exceptions.TrainerAlreadyCreatedException;

public class TrainerCreator {
    private final TrainerRepository trainerRepository;
    public TrainerCreator(TrainerRepository trainerRepository){
        this.trainerRepository = trainerRepository;
    }

    public void execute(TrainerID ID) {
        guardNotExist(ID);
        Trainer trainer = new Trainer(ID);
        trainerRepository.create(trainer);
    }

    private void guardNotExist(TrainerID id) {
        if(trainerRepository.exist(id)){
            throw new TrainerAlreadyCreatedException();
        }
    }
}
