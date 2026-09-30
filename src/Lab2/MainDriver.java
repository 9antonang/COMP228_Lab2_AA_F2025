package Lab2;

import java.math.BigDecimal;
import java.util.Scanner;

public class MainDriver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter principal (decimal only): ");
        BigDecimal principal = sc.nextBigDecimal();

        System.out.print("Enter rate (decimal only): ");
        BigDecimal rate = sc.nextBigDecimal();

        System.out.print("Enter time (years): ");
        BigDecimal time = sc.nextBigDecimal();

        // Create 5 objects
        Interest obj1 = new Interest(principal, rate, time);
        Interest obj2 = new Interest(principal, rate, time);
        Interest obj3 = new Interest(principal, rate, time);
        Interest obj4 = new Interest(principal, rate, time);
        Interest obj5 = new Interest(principal, rate, time);

        System.out.println("\n--- Using BigDecimal ---");
        System.out.println("Simple Interest: " + obj1.calculateSimpleInterest());
        System.out.println("Compound Interest: " + obj1.calculateCompoundInterest());

        System.out.println("\n--- Using double (method overloading) ---");
        double p = principal.doubleValue();
        double r = rate.doubleValue();
        double t = time.doubleValue();

        System.out.println("Simple Interest (double): " + obj1.calculateSimpleInterest(p, r, t));
        System.out.println("Compound Interest (double): " + obj1.calculateCompoundInterest(p, r, t));

        sc.close();
    }
}
