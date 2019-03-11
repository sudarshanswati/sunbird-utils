package org.sunbird.common.message.broker.inf;

import org.sunbird.common.message.broker.model.EventMessage;
import org.sunbird.common.message.consumer.Consumer;

public interface MessageBroker {
  public void send(String topic, EventMessage eventMessage);

  public EventMessage recieve(String topic);

  void subscribe(String topic, Consumer consumer);
}
