public interface GeometricCountable {
    String getFillingColor();

    void setBorderColor(String border);

    void setFillingColor(String filling);

    String getBorderColor();

    default int getTrianglePerimeter(int a, int b, int c) {
        return a + b + c;
    }

    default double getTriangleArea(int a, int b,int c) {
        double s = (double) (a + b + c) /2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    default int getRectanglePerimeter(int a, int b) {
        return 2*(a+b);
    }

    default int getRectangleArea(int a, int b) {
        return a*b;
    }

    default double getCirclePerimeter(int r) {
        return Math.PI*2*r;
    }

    default double getCircleArea(int r) {
        return Math.PI*r*r;
    }
}
