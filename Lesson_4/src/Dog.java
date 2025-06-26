public class Dog extends Animal {
    String name;
    int maxRunDistance = 500;
    int maxSwimDistance = 10;
    static int noOfDogs = 0;

    public Dog(String name, int maxDistance) {
    }

    public Dog(String name) {
        this.name = name;
        noOfDogs++;
        noOfAnimals++;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " пробежал " + distance + " метров");
        } else {
            System.out.println(name + " не может столько проплыть");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= maxSwimDistance) {
        System.out.println(name + "Проплыл " + distance + " метров");
        } else  {
            System.out.println(name + " не может столько проплыть");
        }
    }

}
