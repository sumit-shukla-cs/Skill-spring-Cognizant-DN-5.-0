public class Exercise04_AdapterPaymentDemo {
    public static void main(String[] args) {
        PaymentProcessorPort stripePayment = new StripeGatewayAdapter(new StripeGateway());
        PaymentProcessorPort paypalPayment = new PayPalGatewayAdapter(new PayPalGateway());

        stripePayment.pay(1250.50);
        paypalPayment.pay(799.00);
    }
}

interface PaymentProcessorPort {
    void pay(double amount);
}

final class StripeGateway {
    public void sendStripePayment(double amountInCents) {
        System.out.println("Stripe gateway charging: " + amountInCents + " cents");
    }
}

final class PayPalGateway {
    public void submitPaypalPayment(String invoiceId, double amount) {
        System.out.println("PayPal gateway processing invoice " + invoiceId + " for $" + amount);
    }
}

final class StripeGatewayAdapter implements PaymentProcessorPort {
    private final StripeGateway stripeGateway;

    StripeGatewayAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void pay(double amount) {
        stripeGateway.sendStripePayment(amount * 100);
    }
}

final class PayPalGatewayAdapter implements PaymentProcessorPort {
    private final PayPalGateway payPalGateway;

    PayPalGatewayAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void pay(double amount) {
        payPalGateway.submitPaypalPayment("INV-1001", amount);
    }
}