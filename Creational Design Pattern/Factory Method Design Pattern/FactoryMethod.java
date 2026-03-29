// 1) Define the Product Interface
interface Notification{
    public void send(String message);
}

// 2) Define Concrete Products
class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending push notification: " + message);
    }
}

class SlackNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Slack message: " + message);
    }
}

// 3) Define an Abstract Creator
interface NotificationCreator{
    public Notification createNotification();
}

//4) Define Concrete Creators
class EmailNotificationCreator implements NotificationCreator {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSNotificationCreator implements NotificationCreator {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}

class PushNotificationCreator implements NotificationCreator {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}

class SlackNotificationCreator implements NotificationCreator {
    @Override
    public Notification createNotification() {
        return new SlackNotification();
    }
}

//5) Client Code
public class FactoryMethod {
    public static void main(String []args){
        NotificationCreator notify;

        //Send EMAIL
        notify = new EmailNotificationCreator();
        Notification email = notify.createNotification();
        email.send("Welcome to our platform");

        // Send SMS
        notify = new SMSNotificationCreator();
        Notification sms = notify.createNotification();
        sms.send("Your OTP is 123456");

        // Send Push Notification
        notify = new PushNotificationCreator();
        Notification push = notify.createNotification();
        push.send("You have a new follower!");

        // Send Slack Message
        notify = new SlackNotificationCreator();
        Notification slack = notify.createNotification();
        slack.send("Standup in 10 minutes!");
    }
}
