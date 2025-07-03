public class FoodBowl {
    public int food;
    public FoodBowl(int food) {
        this.food = food;
    }
    public void addFood(int amount) {
        food += amount;
    }
    public void setFood(int food) {
        this.food = food;
    }
}
