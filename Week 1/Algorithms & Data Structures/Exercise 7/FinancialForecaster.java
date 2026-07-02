public class FinancialForecaster {

    /**
     * Helper method to calculate the average past growth rate.
     */
    public static double calculateAverageRate(double[] pastRates) {
        double sum = 0;
        for (double rate : pastRates) {
            sum += rate;
        }
        return sum / pastRates.length;
    }

    /**
     * Recursive method to predict future value.
     * * @param presentValue The starting amount.
     * @param rate         The average annual growth rate (e.g., 0.05 for 5%).
     * @param years        The number of years to forecast into the future.
     * @return             The predicted future value.
     */
    public static double calculateFutureValue(double presentValue, double rate, int years) {
        // 1. The Base Case: 
        // If years is 0, no more time passes, so the value stays the same.
        if (years == 0) {
            return presentValue;
        }
        
        // 2. The Recursive Step: 
        // Calculate the value for (years - 1) and apply this year's growth.
        return calculateFutureValue(presentValue, rate, years - 1) * (1 + rate);
    }

    public static void main(String[] args) {
        // Past 5 years of growth rates (e.g., 5%, 6%, 4%, 5.5%, 4.5%)
        double[] pastRates = {0.05, 0.06, 0.04, 0.055, 0.045};
        
        double presentValue = 10000.00; // Starting with $10,000
        int forecastYears = 10;         // Forecasting 10 years into the future
        
        // Step A: Determine the rate to use based on past data
        double averageRate = calculateAverageRate(pastRates);
        
        // Step B: Calculate future value using the recursive algorithm
        double predictedValue = calculateFutureValue(presentValue, averageRate, forecastYears);
        
        System.out.println("--- Financial Forecast ---");
        System.out.printf("Present Value: $%,.2f\n", presentValue);
        System.out.printf("Calculated Avg Growth Rate: %.2f%%\n", (averageRate * 100));
        System.out.printf("Forecasted Value in %d years: $%,.2f\n", forecastYears, predictedValue);
    }
}