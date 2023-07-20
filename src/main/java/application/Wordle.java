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


        String targetWord = fileUtilities.readRandomLineFromFile("wordleWords.txt").toLowerCase();
//        while (targetWord.length()!=5){
//            targetWord = fileUtilities.readRandomLineFromFile();
//        }

//        targetWord = "Drama";




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
            char[] targetChecker = targetWord.toCharArray();
            int count;
            for (int i = 0; i < targetChecker.length; i++){
                count = 1;
                for (int j = i + 1; j < targetChecker.length; j++){
                    if (targetChecker[i] == targetChecker[j]) {
                        count++;
                        //targetChecker[j] = '0';
                    }
                }
                String holder = "" + count;
                targetChecker[i] = holder.charAt(0);
            }
            char[] guessChecker = userGuess.toCharArray();
            for (int i = 0; i < guessChecker.length; i++){
                count = 1;
                for (int j = i + 1; j < guessChecker.length; j++){
                    if (guessChecker[i] == guessChecker[j]){
                        count++;
                        //targetChecker[j] = '0';
                    }
                }
                String holder = "" + count;
                guessChecker[i] = holder.charAt(0);
            }
            if(userGuess.equalsIgnoreCase(targetWord)){
                didSolve = true;
                numberFailedGuesses = 100;
            } else{
                numberFailedGuesses++;
                for(int i = 0; i < userGuess.length(); i++){
                    if(userGuess.charAt(i) == targetWord.charAt(i)){
                        System.out.print(ConsoleColors.GREEN_BACKGROUND);
                        System.out.print(userGuess.charAt(i));
                    } else {
                        int index = targetWord.indexOf(userGuess.charAt(i));
                        if (index != -1) {
                            if (targetChecker[index] == guessChecker[i]) {              //Find way to make repeat letters only turn blue if there is another letter of that kind
                                System.out.print(ConsoleColors.BLUE_BACKGROUND);
                                System.out.print(userGuess.charAt(i));
                            } else if (targetChecker[index] != '1'){
                                System.out.print(ConsoleColors.BLUE_BACKGROUND);
                                System.out.print(userGuess.charAt(i));
                            } else {
                                System.out.print(ConsoleColors.BLACK_BACKGROUND);
                                System.out.print(userGuess.charAt(i));
                            }

                        } else{
                            System.out.print(ConsoleColors.BLACK_BACKGROUND);
                            System.out.print(userGuess.charAt(i));
                        }
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
