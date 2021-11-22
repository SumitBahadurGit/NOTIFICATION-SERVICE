package com.nepCafe.notification.service;

import com.nepCafe.notification.entities.NotificationEntity;
import com.nepCafe.notification.mapper.NotificationMapper;
import com.nepCafe.notification.repo.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.nepCafe.kafka.client.models.Notification;

@Component
public class NotificationProcessor {

	@Autowired
	private NotificationRepo notificationRepo;
	public void process(Notification notification) {
		NotificationEntity entity = null;
		try {
			entity = notificationRepo.save(NotificationMapper.map(notification));
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(entity != null && entity.getId() != null){
				System.out.println("Successfully saved ");
			} else {
				System.out.println("Error saving entity");
			}

		}

	}
	

}
