public class Animal {
    static int noOfAnimals = 0;
    public Animal() {
    }

    public void run(int distance) {
        System.out.println("Животное пробежало " + distance);
    }

    public void swim(int distance) {
        System.out.println("Животное проплыло " + distance);
    }
}
