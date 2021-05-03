package de.griefed.hastebin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class HasteBinTest {

    private HasteBin hasteBin;

    HasteBinTest() {
        hasteBin = new HasteBin();
    }


    @Test
    void testHasteBin() {
        String hasteBinPost = null;
        File testFile = new File("test.txt");

        hasteBinPost = hasteBin.createHasteBinFromFile(testFile);

        Assertions.assertTrue(hasteBinPost.startsWith("https://haste.zneix.eu/"));
    }
}
