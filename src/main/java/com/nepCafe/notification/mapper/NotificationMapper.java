package com.nepCafe.notification.mapper;

import com.nepCafe.notification.entities.NotificationEntity;
import org.nepCafe.kafka.client.models.Notification;
public class NotificationMapper {

    public static NotificationEntity map(Notification notification) {
        NotificationEntity entity = new NotificationEntity();
        entity.setAction(notification.getAction());
        entity.setMessage(notification.getMessage());
        entity.setCreated(notification.getCreated());
        entity.setDismissable(notification.isDismissable());
        entity.setPriority(notification.getPriority());
        entity.setResolved(notification.isResolved());
        entity.setId(notification.getId());
        entity.setUserId(notification.getUserId());
        entity.setTaskId(notification.getTaskId());
        return entity;
    }

    public static Notification map(NotificationEntity entity) {
        Notification notification = new Notification();
        notification.setAction(entity.getAction());
        notification.setMessage(entity.getMessage());
        notification.setCreated(entity.getCreated());
        notification.setDismissable(entity.isDismissable());
        notification.setPriority(entity.getPriority());
        notification.setResolved(entity.isResolved());
        notification.setId(entity.getId());
        notification.setUserId(entity.getUserId());
        notification.setTaskId(entity.getTaskId());
        return notification;
    }
}
