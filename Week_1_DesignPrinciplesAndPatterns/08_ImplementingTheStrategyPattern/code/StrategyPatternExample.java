public class StrategyPatternExample {

    interface PaymentStrategy {
        void pay(double amount);
    }

    static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;

        public CreditCardPayment(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using Credit Card ending with " + cardNumber.substring(cardNumber.length() - 4));
        }
    }

    static class PayPalPayment implements PaymentStrategy {
        private String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using PayPal account: " + email);
        }
    }

    static class PaymentContext {
        private PaymentStrategy strategy;

        public void setPaymentStrategy(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        public void makePayment(double amount) {
            if (strategy == null) {
                System.out.println("No payment strategy selected.");
            } else {
                strategy.pay(amount);
            }
        }
    }

    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9012-3456");
        PaymentStrategy payPal = new PayPalPayment("user@example.com");

        System.out.println("== Using Credit Card ==");
        context.setPaymentStrategy(creditCard);
        context.makePayment(2500.00);

        System.out.println("\n== Using PayPal ==");
        context.setPaymentStrategy(payPal);
        context.makePayment(1800.50);
    }
}
