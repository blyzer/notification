package com.gila.notification.service;

import com.gila.notification.entity.Notification;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class NotificationServiceImpl implements INotificationService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public NotificationServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @Override
    public Notification sendNotification(Notification notification) {
        // Assuming 'topic-name' is the Kafka topic to send notifications
        String topic = "topic-name";
        String message = buildNotificationMessage(notification);

        // Send the notification message to the Kafka topic
        kafkaTemplate.send(topic, message);

        // Return the sent notification
        return notification;
    }

    private String buildNotificationMessage(Notification notification) {
        // Build the notification message in the desired format
        // This could be a JSON representation of the notification
        // For example: return "{\"category\":\"" + notification.getCategory() + "\",\"message\":\"" + notification.getMessage() + "\"}";
        return "Category: " + notification.getCategory() + ", Message: " + notification.getMessage();
    }

    @Override
    public List<Notification> getAllNotifications() {
        return null;
    }
}
