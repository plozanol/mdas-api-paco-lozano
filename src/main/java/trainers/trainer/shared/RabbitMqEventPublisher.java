package trainers.trainer.shared;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class RabbitMqEventPublisher implements EventPublisher{
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Override
    public void publish(DomainEvent event) {

    }

    @Override
    public void publish(Set<DomainEvent> events) {
        //events.forEach();
    }

}
