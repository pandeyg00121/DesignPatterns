// 1. Define the interface
interface Notification {
    void send(String message);
}

// 2. All three classes must implement it
class EMAILNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

class SmsNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}

class PushNotification implements Notification {   // ← was likely missing "implements Notification"
    @Override
    public void send(String message) {
        System.out.println("Push: " + message);
    }
}

public class SimpleNoticationFactory {
    public static Notification createNotification(String type) {
        return switch (type) {
            case "EMAIL" -> new EMAILNotification();
            case "SMS" -> new SmsNotification();
            case "PUSH" -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown type");
        };
    }
}

class NotificationService2 {
    public void sendNotification(String type, String message) {
        Notification notification = SimpleNoticationFactory.createNotification(type);
        notification.send(message);
    }
}