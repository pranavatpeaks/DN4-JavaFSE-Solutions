import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial principal amount: ");
        double principal = scanner.nextDouble();
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();
        double[] growthRates = new double[years];

        for (int i = 0; i < years; i++) {
            System.out.print("Enter the growth rate for year " + (i + 1) + ": ");
            growthRates[i] = scanner.nextDouble() / 100;
        }

        double futureValue = RecursiveForecast.calculateFutureValue(principal, growthRates, 0);
        System.out.printf("The future value after %d years is: %.2f%n", years, futureValue);
        scanner.close();
    }
}