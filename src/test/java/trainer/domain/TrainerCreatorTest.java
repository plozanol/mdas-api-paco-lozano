package trainer.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pokedex.pokemonType.domain.PokemonName;
import pokedex.pokemonType.domain.PokemonTypeCollection;
import trainers.trainer.domain.Trainer;
import trainers.trainer.domain.TrainerCreator;
import trainers.trainer.domain.TrainerID;
import trainers.trainer.domain.TrainerRepository;
import trainers.trainer.domain.exceptions.TrainerAlreadyCreatedException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TrainerCreatorTest {

    @Mock
    private TrainerRepository trainerRepository;

    @Test
    void trainerShouldBeSavedOnExecute() {
        // GIVEN
        TrainerID trainerID = new TrainerID("some-id");
        TrainerCreator trainerCreator = new TrainerCreator(trainerRepository);
        doNothing().when(trainerRepository).create(any(Trainer.class));

        // WHEN
        trainerCreator.execute(trainerID);

        // THEN
        verify(trainerRepository, times(1)).create(any(Trainer.class));
    }
    
    @Test
    void shouldThrowAnException_ifTrainerAlreadyExists() {
        // GIVEN
        TrainerID trainerID = new TrainerID("some-id");
        TrainerCreator trainerCreator = new TrainerCreator(trainerRepository);
        when(trainerRepository.exist(any(TrainerID.class))).thenReturn(true);

        // THEN
        assertThrows(TrainerAlreadyCreatedException.class, () -> trainerCreator.execute(trainerID));
    }
}
