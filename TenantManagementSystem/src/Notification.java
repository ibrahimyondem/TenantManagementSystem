import java.time.LocalDate;

public class Notification {
    private int notificationID;
    private static int notificationCounter = 499;
    private String type;
    private String message;
    private LocalDate date;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
        this.notificationID = ++notificationCounter;
        this.date = LocalDate.now();
    }

    public int getNotificationID() {
        return notificationID;
    }
    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("---------- Notification ----------\n");
        sb.append("Notification ID: [" + notificationID + "]\n" +
                    "Notification Type [" + type + "]\n" +
                    "Notification Date: " + date + "\n" +
                    "Notification Message: " + message + "\n");
                return sb.toString();
    }
}
