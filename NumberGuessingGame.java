import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalRounds = 0;
        int totalScore = 0;
        String playAgain = "y";

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain.equalsIgnoreCase("y")) {
            totalRounds++;
            int numberToGuess = random.nextInt(100) + 1; // Generates a number between 1 and 100
            int attempts = 0;
            int maxAttempts = 10;
            boolean hasGuessedCorrectly = false;

            System.out.println("Round " + totalRounds + ": You have " + maxAttempts + " attempts to guess the number between 1 and 100.");

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    hasGuessedCorrectly = true;
                    totalScore += maxAttempts - attempts + 1; // Higher score for fewer attempts
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("You've used all " + maxAttempts + " attempts! The number was: " + numberToGuess);
            }

            System.out.println("Your current score: " + totalScore);
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next();
        }

        System.out.println("Game over! Total rounds played: " + totalRounds);
        System.out.println("Your final score: " + totalScore);
        scanner.close();
    }
}
