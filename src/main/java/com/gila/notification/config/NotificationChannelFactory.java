package com.gila.notification.config;

import com.gila.notification.entities.NotificationType;
import com.gila.notification.services.EmailNotificationChannel;
import com.gila.notification.services.INotificationChannel;
import com.gila.notification.services.PushNotificationChannel;
import com.gila.notification.services.SmsNotificationChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationChannelFactory {
    private final SmsNotificationChannel smsNotificationChannel;
    private final EmailNotificationChannel emailNotificationChannel;
    private final PushNotificationChannel pushNotificationChannel;

    @Autowired
    public NotificationChannelFactory(
            SmsNotificationChannel smsNotificationChannel,
            EmailNotificationChannel emailNotificationChannel,
            PushNotificationChannel pushNotificationChannel) {
        this.smsNotificationChannel = smsNotificationChannel;
        this.emailNotificationChannel = emailNotificationChannel;
        this.pushNotificationChannel = pushNotificationChannel;
    }

    public INotificationChannel getNotificationChannel(NotificationType notificationType) {
        return switch (notificationType) {
            case SMS -> smsNotificationChannel;
            case EMAIL -> emailNotificationChannel;
            case PUSH_NOTIFICATION -> pushNotificationChannel;
        };
    }
}
