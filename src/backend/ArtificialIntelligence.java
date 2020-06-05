package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArtificialIntelligence {

    public ArrayList<String> readTheFile(String filepath) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filepath));
        ArrayList<String> fiveLetterWords = new ArrayList<>();
        while (sc.hasNext()) {
            String[] allWords = sc.nextLine().split(" ");
            for (String word : allWords) {
                if (word.length() == 5) {
                    fiveLetterWords.add(word);

                }
            }
        }
        return fiveLetterWords;
    }


    public char[] guessTheWord() throws FileNotFoundException {
        return null;
    }

}
