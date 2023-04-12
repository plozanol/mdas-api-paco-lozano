package trainers.trainer.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import trainers.trainer.domain.exceptions.PokemonIdOutOfRangeException;
import trainers.trainer.domain.exceptions.TrainerDontExistException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
public class TrainerAddFavouritePokemonTest {

    @Mock
    private TrainerRepository trainerRepository;

    @Test
    void shouldThrowException_ifTrainerDoesNotExist() {

        // GIVEN
        TrainerAddFavouritePokemon trainerAddFavouritePokemon = new TrainerAddFavouritePokemon(trainerRepository);
        TrainerID ID = new TrainerID("1234");
        try {
            PokemonID pokemonID = new PokemonID(1);
            // THEN
            assertThrows(TrainerDontExistException.class, () -> trainerAddFavouritePokemon.execute(ID, pokemonID));
        } catch (PokemonIdOutOfRangeException e) {
            fail();
        }


    }
}
