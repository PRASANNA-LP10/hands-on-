import java.util.Scanner;

public class FinancialForecasting {

    public static double predictFutureValue(double presentValue,
                                            double growthRate,
                                            int years) {

        // Base Case
        if (years == 0) {
            return presentValue;
        }

        // Recursive Case
        return predictFutureValue(presentValue, growthRate, years - 1)
                * (1 + growthRate);
    }

    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
        double presentValue = sc.nextDouble();
        double growthRate = sc.nextDouble()/100;
        int years = sc.nextInt();

        double futureValue =
                predictFutureValue(presentValue, growthRate, years);

        System.out.printf("Future Value after %d years: %.2f",
                years, futureValue);
    }
}