package trainer.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import trainers.trainer.domain.AddFavouritePokemon;
import trainers.trainer.domain.PokemonID;
import trainers.trainer.domain.TrainerID;
import trainers.trainer.domain.TrainerRepository;
import trainers.trainer.domain.exceptions.PokemonIdOutOfRangeException;
import trainers.trainer.domain.exceptions.TrainerDontExist;
import org.mockito.Mock;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AddFavouritePokemonTest {

    @Mock
    private TrainerRepository trainerRepository;

    /*@Test
    void shouldThrowException_ifTrainerDoesNotExist() {

        // GIVEN
        AddFavouritePokemon addFavouritePokemon = new AddFavouritePokemon(trainerRepository);
        TrainerID ID = new TrainerID("1234");
        PokemonID pokemonID = new PokemonID(1);

        // THEN
        try {
            assertThrows(TrainerDontExist.class, () -> addFavouritePokemon.execute(ID, pokemonID));
        } catch (PokemonIdOutOfRangeException e) {
            throw new RuntimeException(e);
        }
    }*/
}
