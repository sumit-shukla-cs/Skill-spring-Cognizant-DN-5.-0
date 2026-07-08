public class Exercise05_DecoratorNotificationDemo {
    public static void main(String[] args) {
        NotificationSender notification = new BasicNotification();
        notification = new EmailNotificationDecorator(notification);
        notification = new SmsNotificationDecorator(notification);

        notification.send("Your order has been shipped");
    }
}

interface NotificationSender {
    void send(String message);
}

final class BasicNotification implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Base notification: " + message);
    }
}

abstract class NotificationDecorator implements NotificationSender {
    protected final NotificationSender wrappedNotification;

    protected NotificationDecorator(NotificationSender wrappedNotification) {
        this.wrappedNotification = wrappedNotification;
    }
}

final class EmailNotificationDecorator extends NotificationDecorator {
    EmailNotificationDecorator(NotificationSender wrappedNotification) {
        super(wrappedNotification);
    }

    @Override
    public void send(String message) {
        wrappedNotification.send(message);
        System.out.println("Email channel added for: " + message);
    }
}

final class SmsNotificationDecorator extends NotificationDecorator {
    SmsNotificationDecorator(NotificationSender wrappedNotification) {
        super(wrappedNotification);
    }

    @Override
    public void send(String message) {
        wrappedNotification.send(message);
        System.out.println("SMS channel added for: " + message);
    }
}