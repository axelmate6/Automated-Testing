//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Xiaomi", "2024.10.10", "Xiaomi", "China", 1900, true);
        product1.getProductInfo(product1);
        Product[] products = new Product[5];
        products[0] = new Product("iPhone", "2025.05.11", "Apple", "USA", 4999, true);
        products[1] = new Product("Pixel", "2023.05.05", "Google", "USA", 3999, false);
        products[2] = new Product("Priv", "2022.12.12", "BlackBerry", "Canada", 2999, false);
        products[3] = new Product("V30+", "2024.01.02", "LG", "South Korea", 2500, false);
        products[4] = new Product("Xperia", "2023.03.29", "Sony", "Japan", 3500, false);
        Park park1 = new Park();
        Park.Attractions attractions1 = park1.new Attractions();
        attractions1.attractionName = "Figure 8";
        attractions1.openingHours = "11:00-21:00";
        attractions1.price = 50;
        System.out.println(attractions1.attractionName);
        System.out.println(attractions1.openingHours);
        System.out.println(attractions1.price);
    }
}