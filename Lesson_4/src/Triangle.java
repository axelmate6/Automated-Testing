public class Triangle implements GeometricCountable {
     int a;
     int b;
     int c;
    String filling = "Белый";
    String border = "Черный";

    public Triangle(int a, int b, int   c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public void setBorderColor(String border) {
        this.border = border;
    }

    @Override
    public void setFillingColor(String filling) {
        this.filling = filling;
    }
    @Override
    public String getBorderColor() {
        return border;
    }
    @Override
    public String getFillingColor() {
        return filling;
    }
}
