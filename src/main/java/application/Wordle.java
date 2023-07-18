package application;

import ui.ConsoleColors;
import ui.UserInput;
import ui.UserOutput;



public class Wordle {

    UserOutput userOutput;
    UserInput userInput;
    FileUtilities fileUtilities;

    public Wordle(){
        userInput = new UserInput();
        userOutput = new UserOutput();
        fileUtilities = new FileUtilities();
    }

    public void run() throws Exception{

        userOutput.displayWordleWelcome();


        String targetWord = fileUtilities.readRandomLineFromFile();
        while (targetWord.length()!=5){
            targetWord = fileUtilities.readRandomLineFromFile();
        }

//        String targetWord = "daily";




        // 3. Create a variable to hold the
        // maximum number of guesses before losing
        final int NUMBER_OF_GUESSES = targetWord.length();


        // 4. Create a variable to keep track of the number of failed guesses
        int numberFailedGuesses = 0;
        boolean didSolve = false;


        /*
        Play Wordle!
        1) check to see if each letter is in correct position
        2) Check to see if each letter is in word
        3) Set Colors appropriately
        4) ---->>> make sure if a letter is a repeat, it only shows blue if there is another of the same letter in the word
         */



        while (numberFailedGuesses < NUMBER_OF_GUESSES){

            String userGuess = userInput.getWordFromUser();
            int count = 0;
            if(userGuess.equalsIgnoreCase(targetWord)){
                didSolve = true;
                numberFailedGuesses = 100;
            } else{
                numberFailedGuesses++;
                for(int i = 0; i < userGuess.length(); i++){
                    if(userGuess.charAt(i) == targetWord.charAt(i)){
                        System.out.print(ConsoleColors.GREEN_BACKGROUND);
                        System.out.print(userGuess.charAt(i));
                    } else if (targetWord.indexOf(userGuess.charAt(i)) != -1){              //Find way to make repeat letters only turn blue if there is another letter of that kind
                        System.out.print(ConsoleColors.BLUE_BACKGROUND);
                        System.out.print(userGuess.charAt(i));
                    } else{
                        System.out.print(ConsoleColors.BLACK_BACKGROUND);
                        System.out.print(userGuess.charAt(i));
                    }
                }
                System.out.print(ConsoleColors.RESET);
                System.out.println();
            }
        }

        if (didSolve){
            System.out.println("Congratulations! You solved the puzzle! The word was " + targetWord + ".");
        } else{
            System.out.println("Sorry! You didn't get the word in time. The word was " + targetWord + ". Try again!");
        }


    }
}
