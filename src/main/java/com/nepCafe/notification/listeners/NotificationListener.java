package com.nepCafe.notification.listeners;

import com.nepCafe.notification.service.NotificationProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.nepCafe.kafka.client.models.Notification;


@Component
@KafkaListener(topics = "NOTIFICATIONS", groupId = "NID")
public class NotificationListener  {

	@Autowired
	NotificationProcessor notificationProcessor;

	@KafkaHandler
	public void onMessage(Notification message) {

		System.out.println("Message Received\n");
		System.out.println(message.toString());
		notificationProcessor.process(message);
	}


}


