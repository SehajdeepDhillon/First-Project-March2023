import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        playGame();
    }

    public static String getPlayerChoice() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        String[] validChoices = {"rock", "paper", "scissors"};

        while (true) {
            System.out.print("Enter your choice (rock/paper/scissors): ");
            choice = scanner.nextLine().toLowerCase();

            for (String validChoice : validChoices) {
                if (choice.equals(validChoice)) {
                    return choice;
                }
            }

            System.out.println("Invalid choice. Please try again.");
        }
    }

    public static String generateComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        Random r = new Random();
        int i = r.nextInt(choices.length);
        return choices[i];
    }

    public static boolean determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return false;  // It's a tie
        } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return true;  // Player wins
        } else {
            return false;  // Computer wins
        }
    }

    public static void playGame() {
        System.out.println("Let's play Rock, Paper, Scissors!");

        while (true) {
            String playerChoice = getPlayerChoice();
            String computerChoice = generateComputerChoice();

            System.out.println("Player chose: " + playerChoice);
            System.out.println("Computer chose: " + computerChoice);

            boolean playerWins = determineWinner(playerChoice, computerChoice);

            if (playerWins) {
                System.out.println("Congratulations! You win!");
                return;
            } else if (!playerWins) {
                System.out.println("Sorry! You lose!");
                return;
            } else {
                System.out.println("It's a tie! Let's play again.");
            }
        }
    }
}
