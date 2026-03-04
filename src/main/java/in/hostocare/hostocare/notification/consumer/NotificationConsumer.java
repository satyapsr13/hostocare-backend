package in.hostocare.hostocare.notification.consumer;

import org.springframework.kafka.annotation.KafkaListener;

import in.hostocare.hostocare.common.kafka.KafkaTopics;
import in.hostocare.hostocare.notification.model.NotificationEvent;

public class NotificationConsumer {
    @KafkaListener(topics = KafkaTopics.NOTIFICATION, groupId = "notification-group")
    public void consume(NotificationEvent event) {

        switch (event.getType()) {
            case "EMAIL" -> sendEmail(event);
            case "SMS" -> sendSms(event);
            case "PUSH" -> sendPush(event);
        }
    }

    private void sendEmail(NotificationEvent event) {
        // integrate email provider
        System.out.print("Email Notification: " + event.toString());
    }

    private void sendSms(NotificationEvent event) {
        // integrate SMS provider

        System.out.print("SMS Notification: " + event.toString());
    }

    private void sendPush(NotificationEvent event) {
        // integrate FCM

        System.out.print("Push Notification: " + event.toString());
    }
}
