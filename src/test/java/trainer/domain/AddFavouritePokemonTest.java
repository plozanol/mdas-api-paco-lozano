package trainer.domain;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import trainers.trainer.domain.TrainerRepository;
import org.mockito.Mock;

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
            assertThrows(TrainerDontExistException.class, () -> addFavouritePokemon.execute(ID, pokemonID));
        } catch (PokemonIdOutOfRangeException e) {
            throw new RuntimeException(e);
        }
    }*/
}
