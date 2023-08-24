package com.gila.notification.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class FlywayConfig {
    private final Environment env;

    @Autowired
    public FlywayConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public FlywayConfigurationCustomizer flywayConfigurationCustomizer() {
        boolean baselineOnMigrate = Boolean.parseBoolean(env.getProperty("spring.kafka.bootstrap-servers"));
        return configuration -> {
            configuration.baselineOnMigrate(baselineOnMigrate); // Set baseline on migrate
            configuration.baselineVersion("1.0"); // Set baseline version
        };
    }
}
