import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {

    private static final int MAX_ATTEMPTS = 5;
    private static final int MAX_ROUNDS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Guess the Number Game");
        System.out.println("You have " + MAX_ROUNDS + " rounds to guess numbers between 1 and 100.");
        System.out.println("You get " + MAX_ATTEMPTS + " attempts per round.");
        System.out.println("Try to guess the number in fewer attempts to score more points!");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - -");

        int totalScore = 0;

        for (int round = 1; round <= MAX_ROUNDS; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            System.out.println("\nRound " + round + ": Guess the number (1 to 100)");

            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            while (attemptsUsed < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int userGuess;
                try {
                    userGuess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                    continue;
                }
                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Your guess is out of range! Please enter a number between 1 and 100.");
                    continue;
                }

                attemptsUsed++;

                if (userGuess == numberToGuess) {
                    guessedCorrectly = true;
                    int points = (MAX_ATTEMPTS - attemptsUsed + 1) * 10;
                    totalScore += points;
                    System.out.println("Congratulations! You guessed the correct number.");
                    System.out.println("You scored " + points + " points this round.");
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("The number is higher than your guess.");
                } else {
                    System.out.println("The number is lower than your guess.");
                }

                System.out.println("Attempts left: " + (MAX_ATTEMPTS - attemptsUsed));
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The number was: " + numberToGuess);
            }

            System.out.println("Your total score so far: " + totalScore);
            System.out.println("- - - - - - - - - - - - - - -");
        }

        System.out.println("\nGame Over! Your final score is: " + totalScore);
        System.out.println("Thanks for playing. Goodbye!");

        scanner.close();
    }
}