public class AdapterPatternExample {

    interface PaymentProcessor {
        void processPayment(double amount);
    }

    // Adaptee 1
    static class PayPalGateway {
        public void sendPayment(double amount) {
            System.out.println("Processing PayPal payment of $" + amount);
        }
    }

    // Adaptee 2
    static class StripeGateway {
        public void makeStripePayment(double amount) {
            System.out.println("Processing Stripe payment of $" + amount);
        }
    }

    // Adaptee 3
    static class RazorpayGateway {
        public void payWithRazor(double amount) {
            System.out.println("Processing Razorpay payment of ₹" + amount);
        }
    }

    // Adapter for PayPal
    static class PayPalAdapter implements PaymentProcessor {
        private PayPalGateway payPal;

        public PayPalAdapter(PayPalGateway payPal) {
            this.payPal = payPal;
        }

        public void processPayment(double amount) {
            payPal.sendPayment(amount);
        }
    }

    // Adapter for Stripe
    static class StripeAdapter implements PaymentProcessor {
        private StripeGateway stripe;

        public StripeAdapter(StripeGateway stripe) {
            this.stripe = stripe;
        }

        public void processPayment(double amount) {
            stripe.makeStripePayment(amount);
        }
    }

    // Adapter for Razorpay
    static class RazorpayAdapter implements PaymentProcessor {
        private RazorpayGateway razor;

        public RazorpayAdapter(RazorpayGateway razor) {
            this.razor = razor;
        }

        public void processPayment(double amount) {
            razor.payWithRazor(amount);
        }
    }

    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        PaymentProcessor razorpayProcessor = new RazorpayAdapter(new RazorpayGateway());

        System.out.println("---- Payment Test ----");
        paypalProcessor.processPayment(2500.00);
        stripeProcessor.processPayment(4999.50);
        razorpayProcessor.processPayment(1200.00);
    }
}
