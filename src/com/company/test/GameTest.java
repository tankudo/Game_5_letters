package com.company.test;

import com.company.PlayWithUser;
import com.company.NotCorrectSizeWordException;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test(expected = NotCorrectSizeWordException.class)
    public void testCheckTheWord () throws NotCorrectSizeWordException {
        PlayWithUser bh = new PlayWithUser();
        int sum = bh.checkTheWord("kilép".toCharArray(), "kilép");
        assertEquals(5, sum);

    }

}