package ui;

import java.util.Scanner;

/*
 * All code getting input from the user goes here
 */
public class UserInput {

    public String getLetterFromUser(){

        Scanner scan = new Scanner(System.in);
        System.out.print("Guess a letter: ");
        return scan.nextLine().toLowerCase();
    }

    public String getWordFromUser(){

        Scanner scan = new Scanner(System.in);
        System.out.print("Guess a word: ");
        return scan.nextLine().toLowerCase();
    }
}
