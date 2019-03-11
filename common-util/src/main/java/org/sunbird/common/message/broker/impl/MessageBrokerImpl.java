package org.sunbird.common.message.broker.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import org.sunbird.common.message.broker.inf.MessageBroker;
import org.sunbird.common.message.broker.model.EventMessage;
import org.sunbird.common.message.consumer.Consumer;
import org.sunbird.common.models.util.JsonKey;
import org.sunbird.common.models.util.LoggerEnum;
import org.sunbird.common.models.util.ProjectLogger;

public class MessageBrokerImpl implements MessageBroker {

  private static Map<String, BlockingQueue<EventMessage>> queueMap = new ConcurrentHashMap<>();
  static Map<String, List<Consumer>> subscribers = new HashMap<>();

  static {
    queueMap.put(JsonKey.DATABASE_OPERATION, new ArrayBlockingQueue<>(50));
    queueMap.put(JsonKey.INFORMATIONAL, new ArrayBlockingQueue<>(50));
  }

  public MessageBrokerImpl() {

    ProjectLogger.log("Messagebrokerimpl :Constructor called ", LoggerEnum.INFO);
  }

  @Override
  public void send(String topic, EventMessage eventMessage) {
    BlockingQueue<EventMessage> queue = queueMap.get(topic);
    if (queue == null) {
      ProjectLogger.log(
          "Messagebrokerimpl :Send :NO topic Found For parameter :" + topic, LoggerEnum.INFO);
    } else {
      queue.add(eventMessage);
      notify(topic);
      ProjectLogger.log(
          "Messagebrokerimpl: Send : Queue size for Topic :"
              + topic
              + " : is **** : "
              + queue.size(),
          LoggerEnum.INFO);
    }
  }

  private void notify(String topic) {
    ProjectLogger.log("Messagebrokerimpl: Send : Queue size for Topic :" + topic, LoggerEnum.INFO);
    if (subscribers.containsKey(topic)) {
      List<Consumer> consumers = subscribers.get(topic);
      ProjectLogger.log(
          "Messagebrokerimpl: Send : Queue size for Topic consumer :" + topic, LoggerEnum.INFO);
      consumers.forEach(
          consumer -> {
            consumer.consume();
          });
    }
  }

  @Override
  public EventMessage recieve(String topic) {
    BlockingQueue<EventMessage> queue = queueMap.get(topic);
    if (queue != null) {
      ProjectLogger.log(
          "Messagebrokerimpl: Send : Queue size for Topic :"
              + topic
              + " : is before removing **** : "
              + queue.size(),
          LoggerEnum.INFO);
      return queue.poll();
    }
    ProjectLogger.log(
        "Messagebrokerimpl: Send : NO topic Found For parameter :" + topic, LoggerEnum.INFO);
    return null;
  }

  @Override
  public void subscribe(String topic, Consumer consumer) {
    ProjectLogger.log("ESConsumer:performJob: ESConsumer  thread topic" + topic, LoggerEnum.INFO);
    List<Consumer> consumers;
    if (subscribers.containsKey(topic)) {
      consumers = subscribers.get(topic);
    } else {
      consumers = new ArrayList<>();
    }
    consumers.add(consumer);
    subscribers.put(topic, consumers);
    ProjectLogger.log(
        "ESConsumer:performJob: ESConsumer  thread subscriber size" + subscribers.size(),
        LoggerEnum.INFO);
  }
}
