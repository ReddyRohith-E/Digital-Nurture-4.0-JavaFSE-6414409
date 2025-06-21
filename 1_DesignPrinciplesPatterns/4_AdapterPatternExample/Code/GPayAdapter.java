public class GPayAdapter implements PaymentProcessor {
    private GPayGateway Gateway;

    public GPayAdapter(GPayGateway Gateway) {
        this.Gateway = Gateway;
    }

    @Override
    public void processPayment(double amount) {
        Gateway.makePayment(amount);
    }
}
