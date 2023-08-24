package com.gila.notification.repository;

import com.gila.notification.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // Add custom queries if needed
}
