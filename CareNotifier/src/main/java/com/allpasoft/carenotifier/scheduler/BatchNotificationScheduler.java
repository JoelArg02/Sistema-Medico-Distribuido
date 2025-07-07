package com.allpasoft.carenotifier.scheduler;

import com.allpasoft.carenotifier.service.NotificationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchNotificationScheduler {

    private final NotificationService service;

    public BatchNotificationScheduler(NotificationService service) {
        this.service = service;
    }

    @Scheduled(cron = "0 */30 * * * *")
    public void enviarLotesBajaPrioridad() {
        service.sendBatchLowPriority();
    }
}
