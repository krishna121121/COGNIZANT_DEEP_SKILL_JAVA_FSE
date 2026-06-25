package DesignPatternsandPrinciples;

interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    void makePayment(double amount) {
        System.out.println("Paid using PayPal: " + amount);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway gateway;

    public PayPalAdapter(PayPalGateway gateway) {
        this.gateway = gateway;
    }

    public void processPayment(double amount) {
        gateway.makePayment(amount);
    }
}

public class Exercise4 {
    public static void main(String[] args) {
        PaymentProcessor payment = new PayPalAdapter(new PayPalGateway());
        payment.processPayment(1000);
    }
}