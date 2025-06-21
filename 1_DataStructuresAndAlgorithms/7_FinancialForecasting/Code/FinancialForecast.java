import java.util.Scanner;

public class FinancialForecast {

    // Recursive method to calculate future value
    public static double futureValue(double p, double r, int t) {
        if (t == 0) {
            return p;
        }
        return futureValue(p, r, t - 1) * (1 + r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial amount: ");
        double initialAmount = sc.nextDouble();

        System.out.print("Enter annual growth rate (in %): ");
        double growthRatePercent = sc.nextDouble();
        double growthRate = growthRatePercent / 100.0;

        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        sc.close();
        System.out.printf("Future value after %d years: %.2f\n", years, futureValue(initialAmount, growthRate, years));
    }
}
