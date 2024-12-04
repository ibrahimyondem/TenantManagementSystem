public class NotificationManager {
    private Notification[] notifications;
    private int notificationMax;
    private int notificationNum;

    public NotificationManager(int notificationMax) {
        this.notificationMax = notificationMax;
        this.notifications = new Notification[notificationMax];
        this.notificationNum = 0;
    }

    public boolean addNotification(String type, String message) {
        try{
            if(notificationNum < notificationMax) {
                Notification notification = new Notification(type, message);
                notifications[notificationNum] = notification;
                notificationNum++;
                System.out.println("Notification added: " + notification);
                return true;
            }
            System.out.println("Notification Limit Reached!");
            return false;
        }catch(Exception e){
            System.err.println("ERROR: " + e.getMessage());
            return false;
        }
    }

    public void getAllNotifications() {
        if(notificationNum == 0){
            System.out.println("There are no notifications!\n");
            return;
        }

        System.out.println("---------- ALL NOTIFICATIONS ----------");
        System.out.println("Total Notifications: " + notificationNum + "\n");
       for(int i = 0; i < notificationNum; i++) {
            System.out.println(notifications[i].toString());
        }
    }

    public boolean getNotificationsByType(String type){
        if(notificationNum == 0){
            System.out.println("There are no notifications!\n");
            return false;
        }
        String lowerType = type.toLowerCase();
        boolean found = false;
        for(int i = 0; i < notificationNum; i++) {
            Notification notification = notifications[i];
            if(notification != null && notification.getType().toLowerCase().equals(lowerType)){
                System.out.println("NOTIFICATION TYPE: " + notification.getType());
                System.out.println(notification.toString());
                found = true;
            }
        }
        if(!found){
            System.out.println("There aren't any " + type + " notifications\n");
            return false;
        }
        return false;
    }

    public boolean removeNotification(int notificationID) {
        if(notificationNum == 0){
            System.out.println("\nThere are no notifications to delete!");
        }
        for(int i = 0; i <notificationNum; i++){
            if(notifications[i].getNotificationID() == notificationID){
                for(int j = i; j < notificationNum-1; j++){
                    notifications[j] = notifications[j+1];
                }
                notifications[notificationNum-1] = null;
                System.out.println("\nNotification: " + notifications[i].getNotificationID() + "has been removed");
                notificationNum--;
                return true;
            }
        }
        System.out.println("Notification with ID: " + notificationID + " not found\n");
        return false;
    }
}
