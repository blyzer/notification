package com.gila.notification.services;

import com.gila.notification.dtos.NotificationDTO;

import java.util.List;

public interface INotificationService {
    /**
     * @param notification Notification to send.
     * @return Notification sent.
     */
    NotificationDTO sendNotification(NotificationDTO notification);

    /**
     * @return Get All Notification.
     */
    List<NotificationDTO> getAllNotifications();
}
