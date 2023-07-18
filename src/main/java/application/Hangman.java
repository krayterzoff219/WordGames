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

    public void run() throws Exception{

        userOutput.displayHangmanWelcome();

        // 1. From the FileUtilities class, get a random word to use as the
        // secret word to guess.

        String targetWord = fileUtilities.readRandomLineFromFile();


        // 2. Create a char array (or String) containing underscores for each
        // letter in the secret word. For example,
        // Secret word ...: giving (6 letters)
        // current guess .: ______ (6 underscores)

        StringBuilder guessRight = new StringBuilder();
        for (int i = 0; i < targetWord.length(); i++){
            guessRight.append("_");
        }


        // 3. Create a variable (maybe a final variable?) to hold the
        // maximum number of guesses before losing
        final int NUMBER_OF_GUESSES = 6;


        // 4. Create a variable to keep track of the number of failed guesses
        int numberFailedGuesses = 0;
        boolean didSolve = false;


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

        while (numberFailedGuesses < NUMBER_OF_GUESSES){
            System.out.println(guessRight);
            String userGuess = userInput.getLetterFromUser();
            /*
            Check to make sure userGuess is a letter
             */
            if(targetWord.contains(userGuess)){
                for (int i = 0; i < targetWord.length(); i++) {
                    if (targetWord.charAt(i) == userGuess.charAt(0)) {
                        guessRight.setCharAt(i, userGuess.charAt(0));
                    }
                }
                if (guessRight.toString().contains("_")){
                    System.out.println("Good job!");
                } else {
                    didSolve = true;
                    numberFailedGuesses = 10;
                }
            } else {
                numberFailedGuesses++;
                System.out.println("Wrong! You have " + (NUMBER_OF_GUESSES - numberFailedGuesses) + " guesses left.");
            }
        }

        if (didSolve){
            System.out.println("Congratulations! You solved the puzzle! The word was " + targetWord + ".");
        } else{
            System.out.println("Sorry! You didn't get the word in time. The word was " + targetWord + ". Try again!");
        }

        // Challenge: add other theme mode for hangman words
        // Challenge: add a hit option
        // Challenge: create Wordle

    }
}
