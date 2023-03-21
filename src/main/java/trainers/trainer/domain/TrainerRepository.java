package trainers.trainer.domain;

public interface TrainerRepository {
    boolean exist(TrainerID ID);
    Trainer get(TrainerID ID);
    void create(Trainer trainer);
    void update(Trainer trainer);
}
