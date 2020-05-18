package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PlayWithUser extends ArtificialIntelligence{

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
        ArrayList<String> fiveLetterWords = readTheFile("freedict.txt");
        Random r = new Random();
        String randomWord = fiveLetterWords.get(r.nextInt(fiveLetterWords.size()));
        char[] randomWordLetters = randomWord.toCharArray();
        return randomWordLetters;
    }

    public int checkTheWord(char[] secretWord, String myWord) throws NotCorrectSizeWordException {
        char[] word;
        int counter = 0;
        word = myWord.toCharArray();
        if(word.length !=5){
            throw new NotCorrectSizeWordException ("Not appropriate size of word");
        }
        for (int i = 0; i < 5; i++) {
            if (secretWord[i] == word[i]) {
                counter++;
            }
        }
        return counter;
    }
}

