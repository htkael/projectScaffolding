package com.hunter;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Main {
  public static void main(String[] args) {
    int exitCode = 0;
    Scanner scanner = new Scanner(System.in);

    System.out.println("Provide directory name:");

    String dirName = scanner.next();
    String inDir = ProjectBuilder.getCurrentDir();

    try {
      ProjectBuilder.createDirectory(inDir, dirName);
    } catch (IOException e) {
      exitCode = -1;
      System.err.println(e.getMessage());
      System.exit(exitCode);
    }

    scanner.close();
    System.exit(exitCode);
  }
}
