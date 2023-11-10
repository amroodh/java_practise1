import java.util.Scanner;
import java.util.Random;

public class main2 {

    public static class GuessTheNumberGame {
        public static void main(String[] args) {
            Scanner reader = new Scanner(System.in);
            String play = "yes";

            while (play.equals("yes")) {
                System.out.println("Welcome to the Guess the Number game!");
                System.out.println("Choose a difficulty level: Easy, Medium, or Hard.");
                System.out.print("Enter the level: ");
                String difficulty = reader.nextLine().toLowerCase();

                int maxRange;
                int maxTries;

                if (difficulty.equals("easy")) {
                    maxRange = 50;
                    maxTries = 10;
                } else if (difficulty.equals("medium")) {
                    maxRange = 100;
                    maxTries = 10;
                } else if (difficulty.equals("hard")) {
                    maxRange = 1000;
                    maxTries = 20;
                } else {
                    System.out.println("Invalid difficulty level. Defaulting to Medium.");
                    maxRange = 100;
                    maxTries = 10;
                }

                Random rand = new Random();
                int randNum = rand.nextInt(maxRange) + 1;
                int guess = -1;
                int tries = 0;

                while (guess != randNum && tries < maxTries) {
                    System.out.println("Guess a number between 1 and " + maxRange);
                    guess = reader.nextInt();
                    tries++;

                    if (guess == randNum) {
                        System.out.println("Great! You guessed the number!");
                        System.out.println("It took " + tries + " guesses.");
                        System.out.println("Would you like to play again? YES or NO");
                        play = reader.next().toLowerCase();
                    } else if (guess > randNum) {
                        System.out.println("Your guess is too high.");
                    } else {
                        System.out.println("Your guess is too low.");
                    }
                }

                if (guess != randNum) {
                    System.out.println("Sorry, you've used up all your guesses. The correct number was " + randNum);
                    System.out.println("Would you like to play again? YES or NO");
                    play = reader.next().toLowerCase();
                }
            }

            System.out.println("Thanks for playing! Goodbye.");
            reader.close();
        }
    }

}
