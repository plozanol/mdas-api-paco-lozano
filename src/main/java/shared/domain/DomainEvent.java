package shared.domain;

import java.io.Serializable;

public abstract class DomainEvent implements Serializable {

    protected String aggregateId;
    private DomainEventMetaData domainEventMetaData;

    public DomainEvent(String aggregateId) {
        this.aggregateId = aggregateId;
        this.domainEventMetaData = new DomainEventMetaData();
    }

    public abstract String routingKey();

    public String aggregateId() {
        return aggregateId;
    }
}