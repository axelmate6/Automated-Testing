import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Cat vasya = new Cat("Вася");
        Cat sara = new Cat("Сара");
        Dog chop = new Dog("Чоп");
        vasya.run(50);
        sara.swim(20);
        chop.swim(20);
        chop.run(300);
        System.out.println("Создано " + Cat.noOfCats + " котов и " + Dog.noOfDogs + " собак");
        System.out.println("Всего создано " + Animal.noOfAnimals + " животных");
        Cat[] cats = new Cat[5];
        cats[0] = vasya;
        cats[1] = sara;
        cats[2] = new Cat("Кузя");
        cats[3] = new Cat("Лорд");
        cats[4] = new Cat("Барсик");
        FoodBowl foodBowl = new FoodBowl(20);
        for (int i = 0; i < cats.length; i++) {
            if (cats[i].fulness == false) {
                int catApetite = ThreadLocalRandom.current().nextInt(1, 10);
                cats[i].eatFood(catApetite, foodBowl.food);
                foodBowl.setFood(foodBowl.food-catApetite);
                if (cats[i].fulness == false) {
                    foodBowl.addFood(30);
                    System.out.println("Миска пополнена");
                    i = i-1;
                }

            }
        }
        Triangle triangle = new Triangle(7, 3, 5);
        Rectangle rectangle = new Rectangle(10, 15);
        Circle circle = new Circle(23);
        triangle.setFillingColor("Оранжевый");
        rectangle.setFillingColor("Голубой");
        System.out.println(triangle.getArea(triangle.a, triangle.b, triangle.c));
        System.out.println(triangle.getPerimeter(triangle.a, triangle.b, triangle.c));
        System.out.println(triangle.getBorderColor());
        System.out.println(triangle.getFillingColor());
        System.out.println(rectangle.getPerimeter(rectangle.a, rectangle.b));
        System.out.println(rectangle.getArea(rectangle.a, rectangle.b));
        System.out.println(rectangle.getBorderColor());
        System.out.println(rectangle.getFillingColor());
        System.out.println(circle.getPerimeter(circle.r));
        System.out.println(circle.getArea(circle.r));
        System.out.println(circle.getFillingColor());
        System.out.println(circle.getBorderColor());

    }


}