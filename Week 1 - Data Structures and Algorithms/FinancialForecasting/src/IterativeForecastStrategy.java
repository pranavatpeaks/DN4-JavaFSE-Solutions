public  class IterativeForecastStrategy implements ForecastingStrategy {
    @Override
    public double calculateForecast(double principal, double rate, int timePeriod) {
        for (int i = 0; i < timePeriod; i++) {
            principal *= (1 + rate);
        }
        return principal;
    }
    
}
