public class RecursiveForecast {
    public static double calculateFutureValue(double principal, double[] growthrates, int year) {

        if(year == growthrates.length) {
            return principal;
        }

        double updatedPrincipal = principal * (1 + growthrates[year]);
        return calculateFutureValue(updatedPrincipal, growthrates, year + 1);
    }
}
