package fitness.amanagement.system;

public class Notification {
    private int notificationId;
    private String message;
    private String recipient; 
    private boolean readStatus;

    public Notification(int notificationId, String message, String recipient) {
        this.notificationId = notificationId;
        this.message = message;
        this.recipient = recipient;
        this.readStatus = false;
    }

    public void markAsRead() {
        this.readStatus = true;
        System.out.println("Notification marked as read.");
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public boolean isReadStatus() {
        return readStatus;
    }

    public void setReadStatus(boolean readStatus) {
        this.readStatus = readStatus;
    }
}