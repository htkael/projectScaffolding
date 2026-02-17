package com.hunter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ProjectBuilder {

  public static void main(String[] args) {
    // int exitCode = 0;
    // if (args.length < 1) {
    // System.out.println("✗ Invalid commit message");
    // System.out.println("Error: No arguments provided");
    // exitCode = -1;
    // System.exit(exitCode);
    // }
    // String input = args[0];
    int exitCode = 0;

    Scanner scanner = new Scanner(System.in);

    System.out.println("Provide directory name:");

    String dirName = scanner.next();
    try {
      ProjectBuilder.createNestedDirectories(dirName);
    } catch (IOException e) {
      exitCode = -1;
      System.err.println(e.getMessage());
      System.exit(exitCode);
    }

    scanner.close();
    System.exit(exitCode);
  }

  private static String getCurrentDir() {
    return System.getProperty("user.dir");
  }

  private static String getUserName() {
    return System.getProperty("user.name");
  }

  private static void createNestedDirectories(String dirs) throws IOException {
    Path path = Paths.get(getCurrentDir() + "/" + dirs);

    try {
      Files.createDirectories(path);
      System.out.println("Directory created: " + path.toAbsolutePath());
    } catch (IOException e) {
      System.err.println("Failed to create directory: " + e.getMessage());
      e.printStackTrace();
      throw new IOException("Failed to create directory: " + e.getMessage());
    }
  }

  private static void createFile(String pathName, String content) throws IOException {
    try {
    } catch (IOException e) {
      System.err.println("Failed to write file: " + e.getMessage());
      e.printStackTrace();
      throw new IOException("Failed to write file: " + e.getMessage());
    }
  }
}
