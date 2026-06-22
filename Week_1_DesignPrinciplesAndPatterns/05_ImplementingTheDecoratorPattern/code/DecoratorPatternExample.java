public class DecoratorPatternExample {

    interface Notifier {
        void send(String message);
    }

    static class EmailNotifier implements Notifier {
        public void send(String message) {
            System.out.println("Sending Email: " + message);
        }
    }

    static abstract class NotifierDecorator implements Notifier {
        protected Notifier notifier;

        public NotifierDecorator(Notifier notifier) {
            this.notifier = notifier;
        }

        public void send(String message) {
            notifier.send(message);
        }
    }

    static class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send(String message) {
            super.send(message);
            System.out.println("Sending SMS: " + message);
        }
    }

    static class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send(String message) {
            super.send(message);
            System.out.println("Sending Slack Message: " + message);
        }
    }

    public static void main(String[] args) {
        Notifier emailOnly = new EmailNotifier();
        Notifier emailAndSMS = new SMSNotifierDecorator(new EmailNotifier());
        Notifier emailSMSAndSlack = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));

        System.out.println("== Basic Email Notification ==");
        emailOnly.send("Welcome to the platform!");

        System.out.println("\n== Email + SMS Notification ==");
        emailAndSMS.send("Your order has been shipped!");

        System.out.println("\n== Email + SMS + Slack Notification ==");
        emailSMSAndSlack.send("Server is down! Immediate action required.");
    }
}
