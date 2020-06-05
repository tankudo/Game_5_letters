package backend;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) throws FileNotFoundException, NotCorrectSizeWordException {
        PlayWithUser playWithUser = new PlayWithUser();
        RandomGuess randomGuess = new RandomGuess();
        CleverGuess cleverGuess = new CleverGuess();
        ArrayList<String> five = cleverGuess.readTheFile("hu.txt");
        boolean flag = true;
        while (flag) {
            System.out.println("Would you like to play 5 letter word game? (Y/N) ");
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            switch (line) {
                case ("Y"):
                    System.out.println("Please chose game mode (you guess (u), computer guess(c)), clever guess (cl)");
                    String line1 = sc.nextLine();
                    switch (line1) {
                        case ("u"):
                            System.out.println("Please give me your word: ");
                            String word = sc.nextLine();
                            char[] secretLetters = playWithUser.guessTheWord();
                            //System.out.println(secretLetters); //todo delete
                            playTheGameWithUser(secretLetters, word);
                            break;
                        case ("c"):
                            boolean flag2 = false;
                            while (!flag2) {
                                System.out.println("Is it " + randomGuess.chooseTheWord() + "?");
                                System.out.println("How many correct letters in my word? ");
                                int correctLetters = sc.nextInt();
                                if (correctLetters == 5) {
                                    flag2 = true;
                                    System.out.println("You won!");
                                }
                            }
                            break;
                        case ("cl"):
                            boolean flag3 = false;
                            while (!flag3) {
                                cleverGuess.chooseTheWord(five);
                                if (cleverGuess.chooseTheWord(five).equals("I won!")) {
                                    flag3 = true;
                                    System.out.println("I won!");
                                }
                            }
                            break;
                    }
                case ("N"):
                    flag = false;
                    System.out.println("Good buy");
                    break;
                default:
                    System.out.println("Please enter the correct letter");
            }
        }
    }


    public static void playTheGameWithUser(char[] secretLetters, String word) throws NotCorrectSizeWordException {
        Scanner sc = new Scanner(System.in);
        PlayWithUser playWithUser = new PlayWithUser();
        boolean isFive = false;
        while (!isFive) {
            try {
                int correctLetters = playWithUser.checkTheWord(secretLetters, word);
                System.out.println("You have found " +
                        correctLetters + " letters.");
                if (correctLetters == 5) {
                    isFive = true;
                } else {
                    System.out.println("Please give me your word: ");
                    word = sc.nextLine();
                }
            } catch (NotCorrectSizeWordException e) {
                System.err.println("The word has not correct size");
                System.out.println("Please give me your word: ");
                word = sc.nextLine();
            }
        }
        System.out.println("You have won");
    }
}
