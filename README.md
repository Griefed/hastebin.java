# hastebin.java
A simple Hastebin API wrapper for Java. Forked from [kaimu-kun/hastebin.java](https://github.com/kaimu-kun/hastebin.java) and edited to use HasteBin fork [zneix/haste-server](https://github.com/zneix/haste-server) and to create a post from a passed file, instead of a passed string.

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
