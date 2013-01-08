package brooklyn.entity.messaging;

import brooklyn.entity.Entity;
import brooklyn.event.basic.BasicAttributeSensor;

/**
 * Marker interface identifying message brokers.
 */
public interface MessageBroker extends Entity {
    BasicAttributeSensor<String> BROKER_URL = new BasicAttributeSensor<String>(String.class, "broker.url", "Broker Connection URL");

    /** Setup the URL for external connections to the broker. */
    void setBrokerUrl();
}
