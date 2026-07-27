public class Main {

    // RECURSIVE method to calculate future value
    // Formula: Future Value = Present Value x (1 + growth rate)^years
    // Base case: if years = 0, return current value as is
    // Recursive case: multiply current value by growth rate, reduce years by 1
    static double calculateFutureValue(double currentValue, double growthRate, int years) {

        // BASE CASE — stop recursion here
        if (years == 0) {
            return currentValue;
        }

        // RECURSIVE CASE — call itself with one less year
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    // ITERATIVE method — same calculation but using a loop
    // Included for comparison with recursive approach
    static double calculateFutureValueIterative(double currentValue, double growthRate, int years) {
        double result = currentValue;
        for (int i = 0; i < years; i++) {
            result = result * (1 + growthRate);
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println("=== Financial Forecasting Tool ===");
        System.out.println();

        // Scenario 1: Simple investment growth
        double initialInvestment = 100000.00; // Rs. 1 Lakh
        double annualGrowthRate  = 0.08;      // 8% per year
        int forecastYears        = 5;

        System.out.println("--- Scenario 1: Investment Growth ---");
        System.out.println("Initial Investment : Rs." + initialInvestment);
        System.out.println("Annual Growth Rate : " + (annualGrowthRate * 100) + "%");
        System.out.println("Forecast Period    : " + forecastYears + " years");
        System.out.println();

        // Show year by year breakdown using recursion
        System.out.println("Year by Year Forecast:");
        for (int year = 1; year <= forecastYears; year++) {
            double value = calculateFutureValue(initialInvestment, annualGrowthRate, year);
            System.out.printf("Year %d : Rs.%.2f%n", year, value);
        }

        System.out.println();
        double finalValue = calculateFutureValue(initialInvestment, annualGrowthRate, forecastYears);
        System.out.printf("Final Value after %d years (Recursive)  : Rs.%.2f%n", forecastYears, finalValue);

        double finalValueIter = calculateFutureValueIterative(initialInvestment, annualGrowthRate, forecastYears);
        System.out.printf("Final Value after %d years (Iterative)  : Rs.%.2f%n", forecastYears, finalValueIter);

        System.out.println();
        System.out.println("Both methods give same result — proves recursion is correct.");

        System.out.println();

        // Scenario 2: Company revenue forecasting
        double currentRevenue   = 500000.00; // Rs. 5 Lakhs
        double revenueGrowth    = 0.12;      // 12% per year
        int revenueForecast     = 3;

        System.out.println("--- Scenario 2: Company Revenue Forecast ---");
        System.out.println("Current Revenue    : Rs." + currentRevenue);
        System.out.println("Growth Rate        : " + (revenueGrowth * 100) + "%");
        System.out.println("Forecast Period    : " + revenueForecast + " years");
        System.out.println();

        for (int year = 1; year <= revenueForecast; year++) {
            double revenue = calculateFutureValue(currentRevenue, revenueGrowth, year);
            System.out.printf("Year %d Revenue : Rs.%.2f%n", year, revenue);
        }

        System.out.println();

        // Concept explanation in output
        System.out.println("--- How Recursion Works Here ---");
        System.out.println("Step 1: calculateFutureValue(100000, 0.08, 3)");
        System.out.println("Step 2: calls calculateFutureValue(108000, 0.08, 2)");
        System.out.println("Step 3: calls calculateFutureValue(116640, 0.08, 1)");
        System.out.println("Step 4: calls calculateFutureValue(125971, 0.08, 0)");
        System.out.println("Step 5: years=0, BASE CASE reached, returns 125971");
        System.out.println("Step 6: results bubble back up through each call");
    }
}
