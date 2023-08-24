package com.gila.notification.dto;

import com.gila.notification.entity.MessageCategory;
import com.gila.notification.entity.NotificationType;
import lombok.Data;
import java.util.List;

@Data
public class NotificationDTO {
    private String message;
    private MessageCategory category;
    private List<String> subscribers;
    private NotificationType type;
}
