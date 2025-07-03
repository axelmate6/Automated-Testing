public interface GeometricCountable {
    String getFillingColor();

    void setBorderColor(String border);

    void setFillingColor(String filling);

    String getBorderColor();

    default int getPerimeter(int a, int b, int c) {
        return a + b + c;
    }

    default double getArea(int a, int b,int c) {
        double s = (double) (a + b + c) /2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    default int getPerimeter(int a, int b) {
        return 2*(a+b);
    }

    default int getArea(int a, int b) {
        return a*b;
    }

    default double getPerimeter(int r) {
        return Math.PI*2*r;
    }

    default double getArea(int r) {
        return Math.PI*r*r;
    }
}
