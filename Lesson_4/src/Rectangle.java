public class Rectangle implements GeometricCountable {
     int a;
     int b;
    String filling = "Белый";
    String border = "Черный";

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
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
