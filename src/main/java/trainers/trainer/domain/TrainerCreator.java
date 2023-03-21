package trainers.trainer.domain;

import trainers.trainer.domain.exceptions.TrainerAlreadyCreatedException;

public class TrainerCreator {
    private final TrainerRepository trainerRepository;
    public TrainerCreator(TrainerRepository trainerRepository){
        this.trainerRepository = trainerRepository;
    }

    public void execute(TrainerID ID) throws TrainerAlreadyCreatedException {
        guardNotExist(ID);
        Trainer trainer = new Trainer(ID);
        trainerRepository.create(trainer);
    }

    private void guardNotExist(TrainerID id) throws TrainerAlreadyCreatedException {
        if(trainerRepository.exist(id)){
            throw new TrainerAlreadyCreatedException();
        }
    }
}
