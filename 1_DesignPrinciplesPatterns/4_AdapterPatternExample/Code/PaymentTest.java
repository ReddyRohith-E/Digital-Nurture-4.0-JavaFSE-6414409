public class PaymentTest {
    public static void main(String[] args) {
        PaymentProcessor p = new PhonePayAdapter(new PhonePayGateway());
        PaymentProcessor g = new GPayAdapter(new GPayGateway());

        p.processPayment(100);
        g.processPayment(200);
    }
}
