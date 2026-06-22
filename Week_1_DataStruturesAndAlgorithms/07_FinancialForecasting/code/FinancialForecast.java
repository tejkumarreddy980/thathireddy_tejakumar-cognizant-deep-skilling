public class FinancialForecast {

    
    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    
    public static double calculateFutureValueMemo(double currentValue, double growthRate, int years, Double[] memo) {
        if (years == 0) {
            return currentValue;
        }
        if (memo[years] != null) {
            return memo[years];
        }
        memo[years] = calculateFutureValueMemo(currentValue * (1 + growthRate), growthRate, years - 1, memo);
        return memo[years];
    }

    public static void main(String[] args) {
        double initialValue = 10000;
        double growthRate = 0.08;    
        int years = 5;               

        double futureValue = calculateFutureValue(initialValue, growthRate, years);
        System.out.println("Future Value (Recursive): " + futureValue);

        Double[] memo = new Double[years + 1];
        double futureValueMemo = calculateFutureValueMemo(initialValue, growthRate, years, memo);
        System.out.println("Future Value (With Memoization): " + futureValueMemo);
    }
}
