package de.griefed.hastebin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * Main class as per usual. In this repository, it only exists so a user can immediately test the functionality of the
 * HasteBin.class.
 */
public class Main {
    private static final Logger appLogger = LogManager.getLogger(Main.class);

    /**
     * Creates an instance of {@link HasteBin} and calls {@link HasteBin#createHasteBinFromFile(File)} with the test.txt
     * file in the repository root to create a HasteBin post from it and to retrive the URL to said post to then post to
     * console and log.
     * @param args The usual commandline arguments. We don't need them in this case.
     */
    public static void main(String[] args) {
        HasteBin hasteBin = new HasteBin();
        String hasteBinPost = null;

        File file = new File("test.txt");

        hasteBinPost = hasteBin.createHasteBinFromFile(file);

        appLogger.info(String.format("The URL to the newly created HasteBin post is: %s", hasteBinPost));
        System.out.printf("The URL to the newly created HasteBin post is: %s", hasteBinPost);
    }
}
