package com.gila.notification.dto;

import lombok.Data;
import java.util.List;

@Data
public class UserDTO {

    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private List<String> subscribedCategories;

    private List<String> notificationChannels;
}