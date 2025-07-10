package org.example;

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

    public static double divide(int a, int b) throws ArithmeticException {
        if (b == 0) throw new ArithmeticException("Деление на ноль запрещено");
        return (double) a / b;
    }
}
