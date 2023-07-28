import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CFG {

    public static void main(String[] args) {
        flip();
    }

    public static void flip() {
        List<Boolean> userGuesses = getUserGuesses();
        boolean userWins = flipCoinsAndCheckResult(userGuesses);

        if (userWins) {        //returning true if player wins, or else (fasle) if player losses (score<50%)
            System.out.println("Congratulations! You win! You guessed with an accuracy of >50%");
        } else {
            System.out.println("Sorry! Computer wins! You loose, try again!");
        }
    }

    public static List<Boolean> getUserGuesses() {
        List<Boolean> guesses = new ArrayList<>();  // creating a list for guesses
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your guesses (true for heads, false for tails), you have 9 guesses and must guess with an accuracy of 50% or greater to win!:");

        for (int i = 0; i < 9; i++) {  // attaining player guesses
            boolean guess = in.nextBoolean();
            guesses.add(guess);
        }

        return guesses;
    }

    public static boolean flipCoinsAndCheckResult(List<Boolean> userGuesses) {
        Random random = new Random();   //Genrating random coin flip
        int userWinsCount = 0;

        for (int i = 0; i < 9; i++) {
            boolean coinFlip = random.nextBoolean(); //checking if guess matches computer coin flip, since using boolean, true is equal to heads and false is equal to tails, as printed to user in instructions 
            boolean userGuess = userGuesses.get(i);

            System.out.println("Coin flip " + (i + 1) + ": " + (coinFlip ? "Heads" : "Tails"));

            if (coinFlip == userGuess) {
                userWinsCount++;
            }
        }

        double userWinPercentage = (double) userWinsCount / 9;

        return userWinPercentage > 0.5; //Therfore true if player wins (Has a guess percentage greater than 50% and returns false vise-versa
    }
}
