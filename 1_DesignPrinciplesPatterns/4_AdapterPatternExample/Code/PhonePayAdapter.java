public class PhonePayAdapter implements PaymentProcessor {
    private PhonePayGateway Gateway;

    public PhonePayAdapter(PhonePayGateway Gateway) {
        this.Gateway = Gateway;
    }

    @Override
    public void processPayment(double amount) {
        Gateway.sendPayment(amount);
    }
}
