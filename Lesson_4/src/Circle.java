public class Circle implements GeometricCountable {
     int r;
    String filling = "Белый";
    String border = "Черный";

    public Circle(int r) {
        this.r = r;
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
