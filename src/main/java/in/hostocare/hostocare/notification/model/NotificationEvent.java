package in.hostocare.hostocare.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationEvent {
    private String userId;
    private String type; // EMAIL, SMS, PUSH
    private String title;
    private String message;

    @Override
    public String toString() {
        return "Notification Event: UserId-> " + userId + ", type-> " + type + ", title-> " + title + ", message-> "
                + message;
    }
}