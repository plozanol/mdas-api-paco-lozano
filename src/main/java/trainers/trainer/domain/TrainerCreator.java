package trainers.trainer.domain;

import trainers.trainer.domain.exceptions.TrainerAlredyCreated;

public class TrainerCreator {
    private final TrainerRepository trainerRepository;
    public TrainerCreator(TrainerRepository trainerRepository){
        this.trainerRepository = trainerRepository;
    }

    public void execute(TrainerID ID) throws TrainerAlredyCreated {
        guardNotExist(ID);
        Trainer trainer = new Trainer(ID);
        trainerRepository.create(trainer);
    }

    private void guardNotExist(TrainerID id) throws TrainerAlredyCreated {
        if(trainerRepository.exist(id)){
            throw new TrainerAlredyCreated();
        }
    }
}
