package com.gila.notification.dtos;

import com.gila.notification.entities.MessageCategory;
import com.gila.notification.entities.NotificationType;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private List<MessageCategory> subscribedCategories;

    private List<NotificationType> notificationChannels;
}