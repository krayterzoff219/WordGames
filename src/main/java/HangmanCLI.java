import application.Hangman;
import application.Wordle;

import java.util.Scanner;

public class HangmanCLI {
    public static void main(String[] args) throws Exception {
        Scanner gameType = new Scanner (System.in);
        System.out.println("Choose your Game Type: (H)angman or (W)ordle");
        String game = gameType.nextLine();
        if(game.equalsIgnoreCase("h")){
            new Hangman().run();
        } else if (game.equalsIgnoreCase(("w"))){
            new Wordle().run();
        } else {
            System.out.println("Invalid Choice. Try Again Later");
        }
    }
}
