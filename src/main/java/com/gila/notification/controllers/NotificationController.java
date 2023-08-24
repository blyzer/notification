package com.gila.notification.controllers;

import com.gila.notification.dtos.NotificationDTO;
import com.gila.notification.services.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationServiceImpl notificationService;

    @Autowired
    public NotificationController(NotificationServiceImpl notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send")
    public ResponseEntity<NotificationDTO> sendNotification(@RequestBody NotificationDTO notificationDTO) {
        NotificationDTO sentNotification = notificationService.sendNotification(notificationDTO);
        return new ResponseEntity<>(sentNotification, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<NotificationDTO>> getAllNotifications() {
        List<NotificationDTO> allNotifications = notificationService.getAllNotifications();
        return new ResponseEntity<>(allNotifications, HttpStatus.OK);
    }
}
