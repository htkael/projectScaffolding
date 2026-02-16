package com.hunter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProjectBuilder {

  public static String getCurrentDir() {
    return System.getProperty("user.dir");
  }

  public static void createDirectory(String inDir, String dirName) throws IOException {
    System.out.println("In dir: " + inDir);
    Path path = Paths.get(inDir + "/" + dirName);

    try {
      Files.createDirectories(path);
      System.out.println("Directory created: " + path.toAbsolutePath());
    } catch (IOException e) {
      System.err.println("Failed to create directory: " + e.getMessage());
      e.printStackTrace();
      throw new IOException("Failed to create directory: " + e.getMessage());
    }
  }
}
