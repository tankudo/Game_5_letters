package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomGuess extends ArtificialIntelligence {


    @Override
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

    @Override
    public char[] guessTheWord() throws FileNotFoundException {
        return new char[0];
    }

    public String chooseTheWord() throws FileNotFoundException {
        ArrayList<String> fiveLetterWords = readTheFile("hu.txt");
        Random r = new Random();
        return fiveLetterWords.get(r.nextInt(fiveLetterWords.size()));

    }

}
