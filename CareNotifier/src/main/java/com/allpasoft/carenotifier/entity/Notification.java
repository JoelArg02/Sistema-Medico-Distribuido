package com.allpasoft.carenotifier.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Notification {
    @Id
    private String notificationId;
    private String eventType;
    private String recipient;
    private String status;
    private String priority;
    private Instant timestamp;

    public static Notification create(String eventType, String recipient, String priority) {
        Notification n = new Notification();
        n.notificationId = UUID.randomUUID().toString();
        n.eventType = eventType;
        n.recipient = recipient;
        n.priority = priority;
        n.status = "PENDING";
        n.timestamp = Instant.now();
        return n;
    }
}
