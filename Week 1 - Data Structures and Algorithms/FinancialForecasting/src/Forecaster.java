public class Forecaster {
    private final ForecastingStrategy strategy;
    public Forecaster(ForecastingStrategy strategy) {
        this.strategy = strategy;
    }
    public double forecast(double principal, double rate, int timePeriod) {
        return strategy.calculateForecast(principal, rate, timePeriod);
    }
}
