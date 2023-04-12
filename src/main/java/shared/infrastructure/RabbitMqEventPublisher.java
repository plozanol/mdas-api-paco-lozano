package shared.infrastructure;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import shared.domain.DomainEvent;
import shared.domain.EventPublisher;

import java.util.Set;

@Component
public class RabbitMqEventPublisher implements EventPublisher {

    @Value("${rabbitmq.exchange.name}")
    private String EXCHANGE;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    MessageConverter messageConverter;

    private void sendEvent(DomainEvent event) {
        rabbitTemplate.setMessageConverter(messageConverter);
        rabbitTemplate.convertAndSend(EXCHANGE, event.routingKey(), event.aggregateId());
    }

    @Override
    public void publish(DomainEvent event) {
        sendEvent(event);
    }

    @Override
    public void publish(Set<DomainEvent> events) {
        for(DomainEvent event : events) {
            sendEvent(event);
        }
    }
}
