package application;

import ui.UserInput;
import ui.UserOutput;

public class Hangman {
    UserOutput userOutput;
    UserInput userInput;
    FileUtilities fileUtilities;

    public Hangman(){
        userInput = new UserInput();
        userOutput = new UserOutput();
        fileUtilities = new FileUtilities();
    }

    public void run(){

        userOutput.displayWelcome();

        // 1. From the FileUtilities class, get a random word to use as the
        // secret word to guess.


        // 2. Create a char array (or String) containing underscores for each
        // letter in the secret word. For example,
        // Secret word ...: giving (6 letters)
        // current guess .: ______ (6 underscores)


        // 3. Create a variable (maybe a final variable?) to hold the
        // maximum number of guesses before losing


        // 4. Create a variable to keep track of the number of failed guesses


        // 5. While the user hasn't reached the max number of failed guesses,
        //   * Print out the current letters the user has guessed. For example,
        //       gi_i__  (secret word: giving)
        //   * Ask the user for a letter. (Optional: check for a valid letter)
        //   * Check if the letter is in the secret word
        //   * If the letter is in the secret word, replace the '_' with the letter
        //   * If the letter is NOT in the secret word, increase the variable that
        //     keeps track of the failed guesses by one.
        //   * If the users guess matches the secret word, print a congratulations
        //     message.
        //   * If the user has reached the maximum number of guesses without solving
        //     the secret word, print a message saying: try again.

        // Challenge: add other theme mode for hangman words
        // Challenge: add a hit option
        // Challenge: create Wordle

    }
}
