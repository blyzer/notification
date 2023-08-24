package com.gila.notification.dtos;

import com.gila.notification.entities.MessageCategory;
import com.gila.notification.entities.NotificationType;
import lombok.Data;
import java.time.LocalDateTime;


@Data
public class LogDTO {
    private String message;
    private MessageCategory category;
    private String subscriber;
    private NotificationType type;
    private LocalDateTime timestamp;
}
