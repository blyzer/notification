package com.gila.notification.service;

import com.gila.notification.entity.Notification;

import java.util.List;

public interface INotificationService {
    /**
     * @param notification Notification to send.
     * @return Notification sent.
     */
    Notification sendNotification(Notification notification);

    /**
     * @return Get All Notification.
     */
    List<Notification> getAllNotifications();
}
