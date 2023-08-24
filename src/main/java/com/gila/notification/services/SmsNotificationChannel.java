package com.gila.notification.services;

import com.gila.notification.dtos.NotificationDTO;
import com.gila.notification.dtos.UserDTO;
import com.gila.notification.entities.MessageCategory;
import com.gila.notification.entities.NotificationType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SmsNotificationChannel implements INotificationChannel {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public SmsNotificationChannel(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public NotificationDTO sendNotification(MessageCategory category, String message, NotificationType notificationType, UserDTO user) {
        // Create a new notification and save it to the database
        List<UserDTO> users = new ArrayList<>();
        users.add(user);
        NotificationDTO notification = new NotificationDTO();
        notification.setCategory(category);
        notification.setMessage(message);
        notification.setType(notificationType);
        notification.setSubscribers(users);
        // Send the notification message to the Kafka topic
        kafkaTemplate.send(category.toString(), message);
        // Implement SMS notification logic here
        System.out.println("Sending SMS to user: " + user.getName() +
                " with message: " + notification.getMessage());
        return notification;
    }
}
