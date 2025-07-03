import java.time.LocalDate;

public class Product {
    String name;
    String manufactureDate;
    String manufacturer;
    String country;
    int price;
    boolean reservationStatus;
    public void getProductInfo(Product product) {
        System.out.println("Название: " + product.name);
        System.out.println("Дата производства: " + product.manufactureDate);
        System.out.println("Производитель: " + product.manufacturer);
        System.out.println("Страна производства: " + product.country);
        System.out.println("Цена: " + product.price);
        System.out.println("Состояние бронирования покупателем: " + product.reservationStatus);
    }
    public Product(String name,String manufactureDate,String manufacturer,String country,int price,boolean reservationStatus) {
        this.name = name;
        this.manufactureDate = manufactureDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.reservationStatus = reservationStatus;
    }
}