import java.util.ArrayList;

public class Player {
    private String playerName;
    private int score;
    private ArrayList<Die> dice;

    public Player(String playerName) {
        this.playerName = playerName;
        this.score = 0;
        this.dice = new ArrayList<>();
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<Die> getDice() {
        return dice;
    }

    public void rollDice() {
        for (Die die : dice) {
            die.roll();
        }
    }

    public int getDieValue() {
        int sum = 0;

        for (Die die : dice) {
            sum += die.getCurrentValue();
        }

        return sum;
    }

    public void increaseScore() {
        this.score += 1;
    }

    public void addDie(int sides) {
        Die newDie = new Die(sides);
        dice.add(newDie);
    }

    public String toString() {
        return String.format("Player %s has the score: %d", playerName, score);
    }


}
