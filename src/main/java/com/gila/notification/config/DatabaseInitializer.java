package com.gila.notification.config;

import com.gila.notification.entities.MessageCategory;
import com.gila.notification.entities.NotificationType;
import com.gila.notification.entities.User;
import com.gila.notification.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DatabaseInitializer {

    @Bean
    public CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            User user1 = new User(null, "John Doe", "john@example.com", "1234567890",
                    Arrays.asList(MessageCategory.SPORTS, MessageCategory.FINANCE),
                    Arrays.asList(NotificationType.SMS, NotificationType.EMAIL));

            User user2 = new User(null, "Jane Smith", "jane@example.com", "9876543210",
                    Arrays.asList(MessageCategory.MOVIES, MessageCategory.FINANCE),
                    Arrays.asList(NotificationType.EMAIL, NotificationType.PUSH_NOTIFICATION));

            userRepository.saveAll(Arrays.asList(user1, user2));
        };
    }
}
