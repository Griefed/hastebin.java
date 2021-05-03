# hastebin.java
A simple Hastebin API wrapper for Java. Forked from [kaimu-kun/hastebin.java](https://github.com/kaimu-kun/hastebin.java) and edited to use HasteBin fork [zneix/haste-server](https://github.com/zneix/haste-server) and to create a post from a passed file, instead of a passed string.

Requires [Apache commons-io](https://mvnrepository.com/artifact/commons-io/commons-io) in order to read the passed file to a string and Apache log4j2( [SLF4j LOG4J 12 Binding](https://mvnrepository.com/artifact/org.slf4j/slf4j-log4j12) and [Apache Log4j SLF4J Binding](https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-slf4j-impl)) for logging. Logging can be replaced by regular `ex.printStackTrace();` if you do not want to add any log4j dependencies to your project.

# Example:

```java 
Hastebin hastebin = new Hastebin();
String hasteBinPost = null;

// Define the file which you want to post to HasteBin
File file = new File("path/to/your/file.txt");

// Create the HasteBin post and store the returned string.
hasteBinPost = hastebin.createHasteBinFromFile(file);

// Print the String containing our URL.
System.out.println(hasteBinPost);
```
