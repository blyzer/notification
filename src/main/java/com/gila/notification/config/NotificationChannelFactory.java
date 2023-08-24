package com.gila.notification.config;

import com.gila.notification.entities.NotificationType;
import com.gila.notification.services.EmailNotificationChannel;
import com.gila.notification.services.INotificationChannel;
import com.gila.notification.services.PushNotificationChannel;
import com.gila.notification.services.SmsNotificationChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationChannelFactory {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public NotificationChannelFactory(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public INotificationChannel getNotificationChannel(NotificationType channel) {
        return switch (channel) {
            case SMS -> new SmsNotificationChannel(kafkaTemplate);
            case EMAIL -> new EmailNotificationChannel(kafkaTemplate);
            case PUSH_NOTIFICATION -> new PushNotificationChannel(kafkaTemplate);
            default -> throw new IllegalArgumentException("Invalid notification channel: " + channel);
        };
    }
}
