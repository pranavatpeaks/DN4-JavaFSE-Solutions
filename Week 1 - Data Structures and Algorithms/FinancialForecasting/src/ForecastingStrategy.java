public interface ForecastingStrategy {
    double calculateForecast(double principal, double rate, int timePeriod);
}
