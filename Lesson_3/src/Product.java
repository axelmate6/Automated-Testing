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
    public Product(String _name,String _manufactureDate,String _manufacturer,String _country,int _price,boolean _reservationStatus) {
        name = _name;
        manufactureDate = _manufactureDate;
        manufacturer = _manufacturer;
        country = _country;
        price = _price;
        reservationStatus = _reservationStatus;
    }
}