package shared.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;

class DomainEventMetaData implements Serializable{

    private ZonedDateTime occurredOn;

    public DomainEventMetaData() {
        this.occurredOn = ZonedDateTime.now();
    }
}