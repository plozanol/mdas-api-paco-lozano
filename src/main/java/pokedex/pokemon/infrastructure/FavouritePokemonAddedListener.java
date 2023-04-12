package pokedex.pokemon.infrastructure;

import org.json.JSONException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import pokedex.pokemon.application.CalculateFavouriteCounterUseCase;

import java.nio.charset.StandardCharsets;

@Component
public class FavouritePokemonAddedListener {

    private final CalculateFavouriteCounterUseCase calculateFavouriteCounterUseCase;

    public FavouritePokemonAddedListener(CalculateFavouriteCounterUseCase calculateFavouriteCounterUseCase) {
        this.calculateFavouriteCounterUseCase = calculateFavouriteCounterUseCase;
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name}"} , messageConverter = "Jackson2JsonMessageConverter")
    void onMessage(Message message) throws JSONException {
        System.out.println("received message from Rabbit");
        if(message.getBody().length < 3) {
            System.out.println("wrong pokemonId received from Rabbit");
            return;
        }
        String stringPokemonId = new String(message.getBody(), StandardCharsets.UTF_8).substring(1,message.getBody().length-1);
        String routingKey = message.getMessageProperties().getReceivedRoutingKey();
        calculateFavouriteCounterUseCase.execute(routingKey, stringPokemonId);
    }
}
