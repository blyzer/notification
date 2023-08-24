package com.gila.notification.dto;

import com.gila.notification.entity.MessageCategory;
import com.gila.notification.entity.NotificationType;
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
