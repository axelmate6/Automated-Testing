package main.java.org.example;

public class Factorial {
    public static long factorial(int n) {
        if (n < 0) return 0;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}