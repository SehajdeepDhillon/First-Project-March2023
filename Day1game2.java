import java.util.Random;
import java.util.Scanner;

public class Day1game2 {
    public static void main(String[] args) {
        boolean result = playGuessGame();
        
        if (result) {
            System.out.println("Congratulations! You guessed correctly!");
        } else {
            System.out.println("Sorry, you couldn't guess the number.");
        }
    }
    
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
}


