import java.util.Random;

public class Die {
    private int currentValue;
    private int numberOfSides;

    private static Random rand = new Random();

    public Die(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        this.currentValue = 0;
    }

    public Die() {}

    // setter for currentValue
    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    // getter for currentValue
    public int getCurrentValue() {
        return currentValue;
    }

    public void roll() {
        currentValue = rand.nextInt(numberOfSides) + 1;
    }

    public String toString() {
        return "The current value is :" + currentValue;
    }
}
