package trainers.trainer.infrastructure;

import trainers.trainer.domain.Trainer;
import trainers.trainer.domain.TrainerID;
import trainers.trainer.domain.TrainerRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTrainerRepository implements TrainerRepository {
    private static final Map<String,Trainer> memoryOfTrainers = new HashMap<>();
    @Override
    public boolean exist(TrainerID ID) {
        return memoryOfTrainers.containsKey(ID.ID());
    }

    @Override
    public Trainer get(TrainerID ID) {
        return memoryOfTrainers.get(ID.ID());
    }

    @Override
    public void create(Trainer trainer) {
        memoryOfTrainers.put(trainer.ID().ID(),trainer);
    }

    @Override
    public void update(Trainer trainer) {
        memoryOfTrainers.put(trainer.ID().ID(),trainer);
    }
}
