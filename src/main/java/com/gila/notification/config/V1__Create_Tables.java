package com.gila.notification.config;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.jdbc.core.JdbcTemplate;

public class V1__Create_Tables extends BaseJavaMigration {
    @Override
    public void migrate(Context context) {
        // Get a JdbcTemplate instance from the Flyway context
        JdbcTemplate jdbcTemplate = new JdbcTemplate(context.getConfiguration().getDataSource());

        // Create the User table
        jdbcTemplate.execute("CREATE TABLE user (" +
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL, " +
                "email VARCHAR(255) NOT NULL, " +
                "phone_number VARCHAR(20), " +
                "subscribed_categories TEXT[], " +
                "notification_channels TEXT[]" +
                ")");

        // Create the Notification table
        jdbcTemplate.execute("CREATE TABLE notification (" +
                "id SERIAL PRIMARY KEY, " +
                "category VARCHAR(50) NOT NULL, " +
                "message TEXT NOT NULL, " +
                "type VARCHAR(50) NOT NULL, " +
                "subscribers TEXT[], " +
                "sent_time TIMESTAMP" +
                ")");
    }
}
