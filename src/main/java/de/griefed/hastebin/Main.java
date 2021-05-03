package de.griefed.hastebin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Main {
    private static final Logger appLogger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        HasteBin hasteBin = new HasteBin();
        String hasteBinPost = null;

        File file = new File("test.txt");

        hasteBinPost = hasteBin.createHasteBinFromFile(file);

        appLogger.info(String.format("The URL to the newly created HasteBin post is: %s", hasteBinPost));
        System.out.printf("The URL to the newly created HasteBin post is: %s", hasteBinPost);
    }
}
