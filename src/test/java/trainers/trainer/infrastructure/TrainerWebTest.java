package trainers.trainer.infrastructure;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.reactive.server.WebTestClient;
import springboot.MdasSpringbootAplication;
import trainers.trainer.domain.PokemonID;
import trainers.trainer.domain.Trainer;
import trainers.trainer.domain.TrainerID;
import trainers.trainer.domain.TrainerRepository;
import trainers.trainer.domain.exceptions.PokemonIdOutOfRangeException;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(classes = MdasSpringbootAplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TrainerWebTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private TrainerRepository trainerRepository;

    @Test
    void shouldCreateTrainer_AndAddFavouritePokemon_AndRemoveFavouritePokemon() {
        // GIVEN
        final int POKEMON_ID = 111;
        final String TRAINER_ID = "999";

        this.webTestClient
                .post()
                .uri("/trainer/" + TRAINER_ID)
                .header(HttpHeaders.ACCEPT, APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

        this.webTestClient
                .patch()
                .uri("/trainer/favourite-pokemon/" + POKEMON_ID)
                .header("user_id", TRAINER_ID)
                .header(HttpHeaders.ACCEPT, APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

        Trainer trainer = trainerRepository.get(new TrainerID(TRAINER_ID));

        assertTrue(trainer.hasFavouritePokemon(new PokemonID(POKEMON_ID)));

        this.webTestClient
                .delete()
                .uri("/trainer/favourite-pokemon/" + POKEMON_ID)
                .header("user_id", TRAINER_ID)
                .header(HttpHeaders.ACCEPT, APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

        assertFalse(trainer.hasFavouritePokemon(new PokemonID(POKEMON_ID)));
    }

    @Test
    void shouldReturnTrainerDontExistException_whenUserIdDoesNotExist() {
        this.webTestClient
                .patch()
                .uri("/trainer/favourite-pokemon/1")
                .header("user_id", "99")
                .header(HttpHeaders.ACCEPT, APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus()
                .is4xxClientError()
                .expectBody(String.class).isEqualTo("TrainerDontExistException");
    }
}