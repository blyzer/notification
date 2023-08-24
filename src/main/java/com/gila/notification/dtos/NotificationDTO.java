package com.gila.notification.dtos;

import com.gila.notification.entities.MessageCategory;
import com.gila.notification.entities.NotificationType;
import lombok.Data;
import java.util.List;

@Data
public class NotificationDTO {
    private String message;
    private MessageCategory category;
    private List<UserDTO> subscribers;
    private NotificationType type;
}
