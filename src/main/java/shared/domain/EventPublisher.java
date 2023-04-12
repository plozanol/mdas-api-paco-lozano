package shared.domain;

import java.util.Set;

public interface EventPublisher {
    void publish(DomainEvent event);
    void publish(Set<DomainEvent> events);
}
