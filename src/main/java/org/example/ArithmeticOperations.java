package main.java.org.example;

public class ArithmeticOperations {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static Double divide(int a, int b) {
        if (b == 0) return null;
        return (double) a / b;
    }
}
