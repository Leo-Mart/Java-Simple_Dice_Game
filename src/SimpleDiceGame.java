import java.util.ArrayList;
import java.util.Scanner;

public class SimpleDiceGame {
    public static void main(String[] args) {

        ArrayList<Player> players = initialize();

        takeTurn(players);

        ArrayList<Player> winners = new ArrayList<>();

        winners = getWinners(players);

        System.out.println("Here are the winners!");

        for (Player player : winners) {
            System.out.println(player);
        }


    }

    private static ArrayList<Player> initialize() {
        ArrayList<Player> players = new ArrayList<>();

        boolean isValid;
        int numPlayers = 0;
        int numDice = 0;
        int numSides = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Dice Game");

        do try {
            System.out.println("First enter the number of players: ");
            numPlayers = sc.nextInt();
            System.out.println("You have chosen: " + numPlayers + " players");
            System.out.println("Next specify how many dice each player should have: ");
            numDice = sc.nextInt();
            System.out.println("You have chosen: " + numDice + " dice for each player");
            System.out.println("Now choose the number of sides for each die: ");
            numSides = sc.nextInt();
            System.out.println("You have chosen: " + numSides + " sides for each die");
            isValid = true;
        } catch (Exception e) {
            isValid = false;
            sc.next();
            System.out.println("Invalid input " + e);
        } while (!isValid);

        /*System.out.println("First enter the number of players: ");
        int numPlayers = Integer.parseInt(sc.nextLine());
        System.out.println("You have chosen: " + numPlayers + " players");
        System.out.println("Next specify how many dice each player should have: ");
        int numDice = Integer.parseInt(sc.nextLine());
        System.out.println("You have chosen: " + numDice + " dice for each player");
        System.out.println("Now choose the number of sides for each die: ");
        int numSide = Integer.parseInt(sc.nextLine());
        System.out.println("You have chosen: " + numSide + " sides for each die");
*/
        System.out.println("Lastly chose what each player would like to be called: ");

        // TODO: add some form of input validation

        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Player " + (i + 1) + " please enter your name: ");
            String playerName = sc.next();
            Player newPlayer = new Player(playerName);
            players.add(newPlayer);
            for (int j = 0; j < numDice; j++) {
                newPlayer.addDie(numSides);
            }
        }

        System.out.println("That is all the setup, let's play!");

        return players;
    }

    private static void takeTurn(ArrayList<Player> players) {
        int rounds = 5;
        int i;
        Scanner sc = new Scanner(System.in);

        System.out.println("Let the game begin!");
        System.out.println("You have " + rounds + " rounds");

        for (i = 0; i < rounds; i++) {

            int currentRound = i + 1;

            System.out.println("It is currently round: " + currentRound);

            for (Player player : players) {

                // roll the current playes dice to get an answer
                player.rollDice();

                // the correct answer is the sum of the rolled dice
                int answer = player.getDieValue();
                System.out.println(answer);

                // every player guesses a value
                System.out.println("Player " + player.getPlayerName() + " enter your guess: ");
                int guess = Integer.parseInt(sc.nextLine());


                if (guess == answer) {
                    // if the guess is the same as the answer the current player is awarded a point
                    // otherwise they get nothing and the next player gets to try
                    System.out.println("You guessed correctly and have been awarded one point!");
                    player.increaseScore();
                } else {
                    System.out.println("Sorry that guess was not correct!");
                }

            }
        }

        if (i == rounds) {
            System.out.println("That's all folks, wait a moment while we calculate scores!");
        }
    }

    private static ArrayList<Player> getWinners(ArrayList<Player> players) {
        ArrayList<Player> winners = new ArrayList<>();


        // this will sort the players array based on score, it loops through the entire array comparing each object in the array
        // if the score of one is higher than the other it moves up one step in the order (-1) otherwise it sits at its old postion
        players.sort((p1, p2) -> p1.getScore() > p2.getScore() ? -1 : 0);

       // this gets the current winningscore from the first player object in the players arraylist
       int winningScore = players.getFirst().getScore();

       // using the winningscore I can then compare each players score in the player array, if their score is the same
       // they are also added to the winners arraylist
       for (Player player : players) {
           if (player.getScore() == winningScore) {
               winners.add(player);
           }
       }

       // this works, but truthfully it will probably break at some point, but for now it seems to work.


        return winners;
    }
}
