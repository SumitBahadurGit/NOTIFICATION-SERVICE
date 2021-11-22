package com.nepCafe.notification.controller;

import com.nepCafe.notification.models.NotificationResponse;
import com.nepCafe.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/find/{id}/user")
    public NotificationResponse findByUserId(@PathVariable String id,
                                             @RequestParam String action) {

        return notificationService.findByUserId(id, action);
    }

}
