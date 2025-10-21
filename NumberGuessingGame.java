import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int numberOfTries = 0;
        int userGuess = 0;
        boolean hasGuessedCorrectly = false;
        final int maxAttempts = 10;

        System.out.println("--- Welcome to the Number Guessing Game! ---");
        System.out.printf("I have selected a number between %d and %d.%n", lowerBound, upperBound);
        System.out.printf("You have %d attempts to guess it. Good luck!%n", maxAttempts);

        while (!hasGuessedCorrectly && numberOfTries < maxAttempts) {
            System.out.printf("Attempt %d/%d - Enter your guess: ", numberOfTries + 1, maxAttempts);

            try {
                userGuess = scanner.nextInt();
                numberOfTries++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    hasGuessedCorrectly = true;
                    System.out.printf("Congratulations! You've guessed the number %d correctly in %d tries!%n", numberToGuess, numberOfTries);
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.printf("Sorry, you've run out of attempts. The number was %d.%n", numberToGuess);
        }

        scanner.close();
        System.out.println("--- Game Over ---");
    }
}
