package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CleverGuess extends ArtificialIntelligence {

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

    public String chooseTheWord(ArrayList<String> fiveLetterWords) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        String randomTryString = fiveLetterWords.get(r.nextInt(fiveLetterWords.size()));
        System.out.println("How many correct letters in word " + randomTryString + "?");
        int userCheck = sc.nextInt();
        ArrayList<String> noNeedWord = new ArrayList<>();
        Set<String> neededWord = new HashSet<>();
        char[] randomTryLetters = randomTryString.toCharArray();

        if (userCheck == 0) {
            fiveLetterWords.remove(randomTryString);
            for (int i = 0; i < fiveLetterWords.size(); i++) {
                char[] checkArray = fiveLetterWords.get(i).toCharArray();
                for (int j = 0; j < 5; j++) {
                    if (checkArray[j] == randomTryLetters[j]) {
                        noNeedWord.add(fiveLetterWords.get(i));
                    }
                }
            }
            for (String s : noNeedWord) {
                fiveLetterWords.remove(s);
            }
        }

        if (userCheck == 1) {
            fiveLetterWords.remove(randomTryString);
            for (int i = 0; i < fiveLetterWords.size(); i++) {
                char[] checkArray = fiveLetterWords.get(i).toCharArray();
                for (int j = 0; j < 5; j++) {
                    if (checkArray[j] == randomTryLetters[j]) {
                        neededWord.add(fiveLetterWords.get(i));

                    }
                }
            }
            fiveLetterWords.clear();
            fiveLetterWords.addAll(neededWord);
           // System.out.println(fiveLetterWords);
            randomTryString = fiveLetterWords.get(r.nextInt(fiveLetterWords.size()));
            return randomTryString;
        }
        if (userCheck == 2) {
            fiveLetterWords.remove(randomTryString);
            for (int i = 0; i < fiveLetterWords.size(); i++) {
                char[] checkArray = fiveLetterWords.get(i).toCharArray();
                if (checkArray[0] == randomTryLetters[0] && checkArray[1] == randomTryLetters[1]
                        || checkArray[1] == randomTryLetters[1] && checkArray[2] == randomTryLetters[2]
                        || checkArray[2] == randomTryLetters[2] && checkArray[3] == randomTryLetters[3]
                        || checkArray[3] == randomTryLetters[3] && checkArray[4] == randomTryLetters[4]
                        || checkArray[0] == randomTryLetters[0] && checkArray[2] == randomTryLetters[2]
                        || checkArray[0] == randomTryLetters[0] && checkArray[3] == randomTryLetters[3]
                        || checkArray[0] == randomTryLetters[0] && checkArray[4] == randomTryLetters[4]
                        || checkArray[1] == randomTryLetters[1] && checkArray[3] == randomTryLetters[3]
                        || checkArray[1] == randomTryLetters[1] && checkArray[4] == randomTryLetters[4]
                        || checkArray[2] == randomTryLetters[2] && checkArray[4] == randomTryLetters[4]) {
                    neededWord.add(fiveLetterWords.get(i));
                }
            }

            fiveLetterWords.clear();
            fiveLetterWords.addAll(neededWord);
            //System.out.println(fiveLetterWords);
            randomTryString = fiveLetterWords.get(r.nextInt(fiveLetterWords.size()));
            return randomTryString;
        }
        if (userCheck == 3) {
            fiveLetterWords.remove(randomTryString);
            for (int i = 0; i < fiveLetterWords.size(); i++) {
                char[] checkArray = fiveLetterWords.get(i).toCharArray();
                if (checkArray[0] == randomTryLetters[0] && checkArray[1] == randomTryLetters[1] && checkArray[2] == randomTryLetters[2]
                        || checkArray[1] == randomTryLetters[1] && checkArray[2] == randomTryLetters[2] && checkArray[3] == randomTryLetters[3]
                        || checkArray[2] == randomTryLetters[2] && checkArray[3] == randomTryLetters[3] && checkArray[4] == randomTryLetters[4]
                        || checkArray[0] == randomTryLetters[0] && checkArray[2] == randomTryLetters[2] && checkArray[3] == randomTryLetters[3]
                        || checkArray[0] == randomTryLetters[0] && checkArray[2] == randomTryLetters[2] && checkArray[4] == randomTryLetters[4]
                        || checkArray[0] == randomTryLetters[0] && checkArray[1] == randomTryLetters[1] && checkArray[3] == randomTryLetters[3]
                        || checkArray[1] == randomTryLetters[1] && checkArray[3] == randomTryLetters[3] && checkArray[4] == randomTryLetters[4]
                        || checkArray[1] == randomTryLetters[1] && checkArray[2] == randomTryLetters[2] && checkArray[4] == randomTryLetters[4]
                        || checkArray[0] == randomTryLetters[0] && checkArray[3] == randomTryLetters[3] && checkArray[4] == randomTryLetters[4]
                        || checkArray[0] == randomTryLetters[0] && checkArray[1] == randomTryLetters[1] && checkArray[4] == randomTryLetters[4]

                ) {
                    neededWord.add(fiveLetterWords.get(i));
                }
            }
            fiveLetterWords.clear();
            fiveLetterWords.addAll(neededWord);
            //System.out.println(fiveLetterWords);
            randomTryString = fiveLetterWords.get(r.nextInt(fiveLetterWords.size()));
            return randomTryString;
        }
        if (userCheck >= 5) {
            return "I won!";
        }
        return randomTryString;
    }
}