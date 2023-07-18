package application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FileUtilities {
    public static final String VOCAB_FILE = "words.txt";

    /*
     * Use this to get a random word from the VOCAB_FILE
     */
    public String readRandomLineFromFile() throws Exception {

        File file = new File (VOCAB_FILE);
        Scanner words = new Scanner(file);
        List<String> useableWords = new ArrayList<>();
        while (words.hasNext()){
            useableWords.add(words.next());
        }

        Random rand = new Random();
        int randomIndex = rand.nextInt(useableWords.size());

        return useableWords.get(randomIndex);
    }
}
