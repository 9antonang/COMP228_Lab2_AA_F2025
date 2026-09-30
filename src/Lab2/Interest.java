package Lab2;

import java.math.BigDecimal;

public class Interest {

    private BigDecimal principalBD;
    private BigDecimal rateBD;
    private BigDecimal timeBD;

    // Constructor with validation
    public Interest(BigDecimal principal, BigDecimal rate, BigDecimal time) {

        if (principal == null || rate == null || time == null) {
            throw new IllegalArgumentException("Values cannot be null.");
        }

        // No negative or zero values
        if (principal.compareTo(BigDecimal.ZERO) <= 0 ||
            rate.compareTo(BigDecimal.ZERO) <= 0 ||
            time.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Values cannot be negative or zero.");
        }

        // Principal and rate cannot be integers
        if (principal.scale() == 0) {
            throw new IllegalArgumentException("Principal cannot be an integer.");
        }
        if (rate.scale() == 0) {
            throw new IllegalArgumentException("Rate cannot be an integer.");
        }

        this.principalBD = principal;
        this.rateBD = rate;
        this.timeBD = time;
    }

    // Simple Interest using BigDecimal
    public BigDecimal calculateSimpleInterest() {
        return principalBD.multiply(rateBD).multiply(timeBD);
    }

    // Simple Interest using double (method overloading)
    public double calculateSimpleInterest(double p, double r, double t) {
        return p * r * t;
    }

    // Compound Interest using BigDecimal
    public BigDecimal calculateCompoundInterest() {
        BigDecimal onePlusRate = BigDecimal.ONE.add(rateBD);
        BigDecimal amount = principalBD.multiply(onePlusRate.pow(timeBD.intValue()));
        return amount.subtract(principalBD);
    }

    // Compound Interest using double (method overloading)
    public double calculateCompoundInterest(double p, double r, double t) {
        return p * (Math.pow(1 + r, t)) - p;
    }
}
