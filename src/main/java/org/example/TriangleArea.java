package org.example;

public class TriangleArea {
    public static Double calculateArea(int a, int b, int c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            return null;
        }
        double s = (double) (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
