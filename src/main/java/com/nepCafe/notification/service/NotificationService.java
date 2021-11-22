package com.nepCafe.notification.service;

import com.nepCafe.notification.entities.NotificationEntity;
import com.nepCafe.notification.mapper.NotificationMapper;
import com.nepCafe.notification.models.NotificationResponse;
import com.nepCafe.notification.repo.NotificationRepo;
import org.nepCafe.kafka.client.models.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    public NotificationResponse findByUserId(String userId, String action) {
        NotificationResponse response = new NotificationResponse();
        try{
            List<NotificationEntity> entities = null;
            if(ObjectUtils.isEmpty(action)) {
                entities = notificationRepo.findByUserId(userId);
            } else {
                entities = notificationRepo.findByUserIdAndAction(userId, action);
            }

            if(!ObjectUtils.isEmpty(entities)) {

                List<Notification> notifications = entities
                        .stream()
                        .map(e -> NotificationMapper.map(e))
                        .collect(Collectors.toList());
                response.setNotifications(notifications);
            } else {
                response.setMessage("No notifications.");
            }
        } catch (Exception ex) {
            response.setErrorMessage("Error getting notifications");
        }

        return response;
    }
}
