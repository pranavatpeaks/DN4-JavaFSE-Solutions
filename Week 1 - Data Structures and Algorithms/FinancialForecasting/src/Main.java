import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter principal amount: ");
        double principal = scanner.nextDouble();
        System.out.print("Enter annual interest rate (as a decimal): ");
        double rate = scanner.nextDouble();
        System.out.print("Enter number of years: ");
        int years = scanner.nextInt();
        scanner.close();


        ForecastingStrategy strategy = new RecursiveForecastStrategy();
        Forecaster forecaster = new Forecaster(strategy);
        double futureValue = forecaster.forecast(principal, rate, years);

        System.out.printf("Future Value (Recursive): %.2f\n", futureValue);

        // Swap strategy easily (Open/Closed, Liskov)
        strategy = new IterativeForecastStrategy();
        forecaster = new Forecaster(strategy);
        futureValue = forecaster.forecast(principal, rate, years);

        System.out.printf("Future Value (Iterative): %.2f\n", futureValue);
    }
}