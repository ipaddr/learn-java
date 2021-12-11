package id.oneindoensia.javabootcamp.day2;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberAndBigNumberExample {
    public static void main(String[] args) {
        Number number = Integer.valueOf(12) ;
        System.out.println(number.byteValue());
        System.out.println(number.intValue());
        System.out.println(number.floatValue());
        System.out.println(number.doubleValue());
        System.out.println(number.shortValue());

        int N = 20;
        System.out.println(factorial(N));
    }

    // Returns Factorial of N
    static BigInteger factorial(int N)
    {
        // Initialize result
        BigInteger f = new BigInteger("1"); // Or BigInteger.ONE

        // Multiply f with 2, 3, ...N
        for (int i = 2; i <= N; i++)
            f = f.multiply(BigInteger.valueOf(i));

        return f;
    }
}
