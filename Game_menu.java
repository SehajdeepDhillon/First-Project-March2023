import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Game_menu {

    public static void main(String[] args) {
        int wins = 0;
        int losses = 0;
        boolean playAgain = true;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Game Menu!");

        while (playAgain) {
            displayMenu();
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                 flip();   
                // Play game 1
                    // Update wins/losses based on outcome
                    break;
                case 2:
                    boolean result = playGuessGame();//game 2
        
        if (result) {
            System.out.println("Congratulations! You guessed correctly!");
        } else {
            System.out.println("Sorry, you couldn't guess the number.");
        }
                // Play game 2
                    // Update wins/losses based on outcome
                    break;
                case 3:
                boolean resultx = Dicegame();//game 3
        if (resultx){
            System.out.println("Congrats you Win!");
        }
        else{
            System.out.println("You loose, Try again");
        }
                    // Play game 3
                    // Update wins/losses based on outcome
                case 4:
                playGame();//game 4
                // Play game 3
                    // Update wins/losses based on outcome
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
                    continue;
            }
            
            System.out.println("Wins: " + wins + " Losses: " + losses);
            
            System.out.println("Do you want to play again? (Y/N)");
            String playAgainInput = scanner.next();
            
            if (playAgainInput.equalsIgnoreCase("N")) {
                playAgain = false;
            }
        }
        
        System.out.println("Thanks for playing! Final score: Wins: " + wins + " Losses: " + losses);
        scanner.close();
    }
        
        public static void displayMenu(){
        System.out.println("Welcome to the game menu");
        System.out.println("There are 4 games that you can play");
        System.out.println("To play the coin flip game please enter 1, to play the number guessing game please enter 2, to play the dice game please enter 3, to play the rock/paper/scissors game please enter 4");
        }

        
// GAME 1111111
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



//GAME22222222222222

    
    public static boolean playGuessGame() {
        Random random = new Random();
        int secretNumber = random.nextInt(10) + 1;
        int attempts = 0;
        
        Scanner scanner = new Scanner(System.in);
        
        while (attempts < 2) {
            System.out.print("Guess a number between 1 and 10: ");
            int guess = scanner.nextInt();
            
            if (guess == secretNumber) {
                return true;
            } else if (Math.abs(guess - secretNumber) <= 2) {
                System.out.println("Close, but not quite right. Try again!");
                attempts++;
            } else {
                break;
            }
        }
        
        return false;
    }


//GAME3333333333

        public static boolean Dicegame() {
            Random r =  new Random();
            int resultx = r.nextInt(6);
            resultx++;
            int comp1 = resultx;
            Random w =  new Random();
            int result2 = w.nextInt(6);
            result2++;
            int comp2 = result2;
            Random x =  new Random();
            int result3 = x.nextInt(6);
            result3++;
            int player1 = result3;
            Random y =  new Random();
            int result4 = y.nextInt(6);
            result4++;
            int player2 = result4;
           
            int comp_total = comp1+comp2;
            int player_total = player1 + player2;


            if (comp_total>=player_total){
                return false;
            }
            else{
                return true;
            }
               
            }




//GAME44444444

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