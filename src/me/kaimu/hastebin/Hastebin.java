package de.griefed.hastebin;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

/**
 * Create a HasteBin post from a given file. Errors are written to a log4j2 logger.
 * If you do not want to use the logging, replace the lines containing <code>appLogger.error</code>
 * with <code>ex.printStackTrace();</code>
 */
public class Hastebin {
    private static final Logger appLogger = LogManager.getLogger(HasteBin.class);
	
    /**
     * Create a HasteBin post from a given text file. The text file provided is read into a string and then passed onto
     * <a href="https://haste.zneix.eu">Haste zneix</a> which creates a HasteBin post out of the passed String and
     * returns the URL to the newly created post.<br>
     * Created with the help of <a href="https://github.com/kaimu-kun/hastebin.java">kaimu-kun's hastebin.java (MIT License)</a>
     * and edited to use HasteBin fork <a href="https://github.com/zneix/haste-server">zneix/haste-server</a>
     * @param textFile The file which will be read into a String of which then to create a HasteBin post of.
     * @return String. Returns a String containing the URL to the newly created HasteBin post.
     */
    public String createHasteBinFromFile(File textFile) {
        String text = null;
        String requestURL = "https://haste.zneix.eu/documents";
        String response = null;

        int postDataLength;

        URL url = null;

        HttpsURLConnection conn = null;

        byte[] postData;

        DataOutputStream dataOutputStream;

        BufferedReader bufferedReader;

        try { url = new URL(requestURL); }
        catch (IOException ex) {appLogger.error("Error during acquisition of request URL."), ex);}

        try { text = FileUtils.readFileToString(textFile, "UTF-8"); }
        catch (IOException ex) { appLogger.error("Error reading text from file."),ex); }

        postData = Objects.requireNonNull(text).getBytes(StandardCharsets.UTF_8);
        postDataLength = postData.length;

        try { conn = (HttpsURLConnection) Objects.requireNonNull(url).openConnection(); }
        catch (IOException ex) {appLogger.error("Error during opening of connection to URL."), ex);}

        Objects.requireNonNull(conn).setDoOutput(true);
        conn.setInstanceFollowRedirects(false);

        try { conn.setRequestMethod("POST"); }
        catch (ProtocolException ex) {appLogger.error("Error during request of POST method."), ex);}

        conn.setRequestProperty("User-Agent", "HasteBin-Creator API");
        conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        conn.setUseCaches(false);

        try {
            dataOutputStream = new DataOutputStream(conn.getOutputStream());
            dataOutputStream.write(postData);
            bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            response = bufferedReader.readLine();
        } catch (IOException ex) {
            appLogger.error("Error encountered when acquiring response from URL.", ex);
        }

        if (Objects.requireNonNull(response).contains("\"key\"")) {
            response = "https://haste.zneix.eu/" + response.substring(response.indexOf(":") + 2, response.length() - 2);
        }

        if (response.contains("https://haste.zneix.eu")) {
            return response;
        } else {
            return "Error encountered when acquiring response from URL.";
        }
    }
}
