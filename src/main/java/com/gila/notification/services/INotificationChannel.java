package com.gila.notification.services;

import com.gila.notification.dtos.NotificationDTO;
import com.gila.notification.dtos.UserDTO;
import com.gila.notification.entities.MessageCategory;
import com.gila.notification.entities.NotificationType;

public interface INotificationChannel {
    NotificationDTO sendNotification(MessageCategory category, String message, NotificationType notificationType, UserDTO user);
}
