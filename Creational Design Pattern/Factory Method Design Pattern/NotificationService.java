class EmailNotification{
    public void send(String message){
        System.out.println("Sending Email Notification" + message);
    }
}
class SMSNotification{
    public void send(String message){
        System.out.println("Sending SMS Notification" + message);
    }
}
class PUSHNotification{
    public void send(String message){
        System.out.println("Sending PUSH Notification" + message);
    }
}
public class NotificationService {
    public void sendNotification(String type, String message){
        if(type.equals("EMAIL")){
            EmailNotification email = new EmailNotification();
            email.send(message);
        }else if(type.equals("SMS")){
            SMSNotification sms = new SMSNotification();
            sms.send(message);
        }else if(type.equals("PUSH")){
            PUSHNotification push = new PUSHNotification();
            push.send(message);
        }
    }
}
