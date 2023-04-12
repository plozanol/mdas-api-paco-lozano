package trainers.trainer.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import trainers.trainer.domain.exceptions.TrainerDontExistException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class TrainerRemoveFavouritePokemonTest {
    @Mock
    private TrainerRepository trainerRepository;

    @Test
    void shouldPokemonIdOutOfRangeException_whenTrainerDoesNotExist() {
        // GIVEN
        TrainerRemoveFavouritePokemon trainerRemoveFavouritePokemon = new TrainerRemoveFavouritePokemon(trainerRepository);
        TrainerID ID = new TrainerID("1234");
        PokemonID pokemonID = new PokemonID(1);

        // THEN
        assertThrows(TrainerDontExistException.class, () -> trainerRemoveFavouritePokemon.execute(ID, pokemonID));
    }
}
