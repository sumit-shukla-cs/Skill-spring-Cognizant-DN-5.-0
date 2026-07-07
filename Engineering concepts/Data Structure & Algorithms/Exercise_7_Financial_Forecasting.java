public class Exercise_7_Financial_Forecasting {

    public static double forecastValue(double currentValue, double growthRate, int periods) {
        if (periods == 0) {
            return currentValue;
        }
        return forecastValue(currentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double current = 10000;
        double annualGrowthRate = 0.08;
        double futureValue = forecastValue(current, annualGrowthRate, 5);
        System.out.println(futureValue);
    }
}