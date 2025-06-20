public class RecursiveForecastStrategy implements ForecastingStrategy {
    @Override
    public double calculateForecast(double principal, double rate, int timePeriod) {
        if (timePeriod == 0) {
            return principal;
        }
        return calculateForecast(principal * (1 + rate), rate, timePeriod - 1);
    }

    
}