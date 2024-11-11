import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    private int guessesLeft = 5;
    private String wordToGuess;
    private ArrayList<String> words;

    public GuessingGame() {
        words = new ArrayList<>();
        words.add("apple");
        words.add("banana");
        words.add("cherry");
        words.add("grape");
        words.add("orange");
        words.add("mango");
        words.add("strawberry");
        words.add("blueberry");
        words.add("kiwi");
        words.add("watermelon");
        wordToGuess = getRandomWord();
    }

    public void play() {
        System.out.println("Welcome to the Word Guessing Game!");
        Scanner input = new Scanner(System.in);

        while (guessesLeft > 0) {
            System.out.print("Enter your guess: ");
            String userGuess = input.nextLine();

            if (userGuess.equalsIgnoreCase(wordToGuess)) {
                System.out.println("Congrats! You guessed right!");
                break;
            } else {
                guessesLeft--;
                System.out.println("Nope, try again. You have " + guessesLeft + " guesses left.");
            }

            if (guessesLeft == 0) {
                System.out.println("Sorry, you're out of guesses. The word was: " + wordToGuess);
            }
        }

        input.close();
    }

    private String getRandomWord() {
        Random random = new Random();
        int index = random.nextInt(words.size());
        return words.get(index);
    }
}
