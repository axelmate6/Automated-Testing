public class Cat extends Animal {
    String name;
    int maxRunDistance = 200;
    boolean fulness = false;
    static int noOfCats = 0;

    public Cat(String name) {
        this.name = name;
        noOfCats++;
        noOfAnimals++;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " пробежал " + distance + " метров");
        } else {
            System.out.println(name + " не сможет столько пробежать");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Коты не умеют плавать");
    }

    public void eatFood(int amount, int availableFood) {
        if (amount <= availableFood) {
        System.out.println(name+" поел");
        fulness = true;
        } else  {
            System.out.println(name+" не хватило еды");
        }
    }
}
