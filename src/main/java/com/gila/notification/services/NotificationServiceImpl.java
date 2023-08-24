package com.gila.notification.services;

import com.gila.notification.config.NotificationChannelFactory;
import com.gila.notification.dtos.NotificationDTO;
import com.gila.notification.dtos.UserDTO;
import com.gila.notification.entities.MessageCategory;
import com.gila.notification.entities.Notification;
import com.gila.notification.entities.NotificationType;
import com.gila.notification.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements INotificationService {
    private final NotificationRepository notificationRepository;
    private ModelMapper modelMapper;
    private final NotificationChannelFactory notificationChannelFactory;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository,
                                   ModelMapper modelMapper,  NotificationChannelFactory notificationChannelFactory) {
        this.notificationRepository = notificationRepository;
        this.modelMapper = modelMapper;
        this.notificationChannelFactory = notificationChannelFactory;
    }

    @Override
    public NotificationDTO sendNotification(NotificationDTO notificationDTO) {
        notificationDTO.getSubscribers().forEach(user ->
                user.getNotificationChannels().forEach(channel ->
                        sendNotificationToChannel(notificationDTO, user, channel)
                )
        );

        // Return the original notificationDTO
        return notificationDTO;
    }


    private void sendNotificationToChannel(NotificationDTO notificationDTO, UserDTO user, NotificationType notificationType) {
        MessageCategory category = notificationDTO.getCategory();
        String message = notificationDTO.getMessage();

        NotificationDTO mappedNotification = notificationChannelFactory
                .getNotificationChannel(notificationType)
                .sendNotification(category, message, notificationType, user);

        Notification notification = modelMapper.map(mappedNotification, Notification.class);
        notification.setSentTime(LocalDateTime.now());
        notificationRepository.save(notification);
    }

    @Override
    public List<NotificationDTO> getAllNotifications() {
        List<Notification> notifications = notificationRepository.findAll();
        return notifications.stream()
                .map(notification -> modelMapper.map(notification, NotificationDTO.class))
                .collect(Collectors.toList());
    }
}
