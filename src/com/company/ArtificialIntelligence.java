package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public  abstract class ArtificialIntelligence {

    public abstract ArrayList<String> readTheFile(String filepath) throws FileNotFoundException;
    public abstract char[] guessTheWord() throws FileNotFoundException;

}
