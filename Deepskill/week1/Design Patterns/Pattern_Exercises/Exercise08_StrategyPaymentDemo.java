public class Exercise08_StrategyPaymentDemo {
    public static void main(String[] args) {
        CheckoutContext checkout = new CheckoutContext();

        checkout.setPaymentMethod(new CreditCardPaymentStrategy("4111-xxxx-xxxx-1234"));
        checkout.pay(2499.00);

        checkout.setPaymentMethod(new PayPalPaymentStrategy("customer@example.com"));
        checkout.pay(1599.00);
    }
}

interface PaymentMethodStrategy {
    void pay(double amount);
}

final class CreditCardPaymentStrategy implements PaymentMethodStrategy {
    private final String cardNumber;

    CreditCardPaymentStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using credit card " + cardNumber);
    }
}

final class PayPalPaymentStrategy implements PaymentMethodStrategy {
    private final String accountEmail;

    PayPalPaymentStrategy(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal account " + accountEmail);
    }
}

final class CheckoutContext {
    private PaymentMethodStrategy paymentMethod;

    public void setPaymentMethod(PaymentMethodStrategy paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void pay(double amount) {
        if (paymentMethod == null) {
            throw new IllegalStateException("Payment method is not set");
        }
        paymentMethod.pay(amount);
    }
}