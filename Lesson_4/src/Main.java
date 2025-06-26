import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static int foodBowl = 20;

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
        for (int i = 0; i < cats.length; i++) {
            if (cats[i].fulness == false) {
                int catApetite = ThreadLocalRandom.current().nextInt(1, 10);
                cats[i].eatFood(catApetite, foodBowl);
                foodBowl = foodBowl - catApetite;
                if (cats[i].fulness == false) {
                    addFood(30);
                    System.out.println("Миска пополнена");
                    i = i-1;
                }

            }
        }

    }

    public static void addFood(int food) {
        foodBowl = foodBowl + food;
    }
}