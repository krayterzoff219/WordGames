package ui;

public class UserOutput {

    /*
     * https://ascii.co.uk/art/turkey
     */
    public void displayWelcome(){
        System.out.print(ConsoleColors.YELLOW_BOLD);
        System.out.println("                 .--.  "     );
        System.out.println(" {\\             / q {\\ "   );
        System.out.println(" { `\\           \\ (-(~`"   );
        System.out.println("{ '.{`\\          \\ \\ ) "  );
        System.out.println("{'-{ ' \\  .-\"\"'-. \\ \\  ");
        System.out.println("{._{'.' \\/       '.) \\ "   );
        System.out.println("{_.{.   {`            |"     );
        System.out.println("{._{ ' {   ;'-=-.     |"     );
        System.out.println(" {-.{.' {  ';-=-.`    /"     );
        System.out.println("  {._.{.;    '-=-   .' "     );
        System.out.println("   {_.-' `'.__  _,-'   "     );
        System.out.println("            |||`       "     );
        System.out.println("           .='==,      "     );
        System.out.println();
        System.out.print(ConsoleColors.RESET);
        System.out.println("*** Welcome to Thanksgiving Themed Hangman ***");
    }
}
