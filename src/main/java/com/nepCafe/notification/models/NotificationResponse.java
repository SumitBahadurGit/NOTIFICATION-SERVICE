package com.nepCafe.notification.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.nepCafe.kafka.client.models.Notification;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationResponse {

    private List<Notification> notifications;
    private String message;
    private String errorMessage;

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
