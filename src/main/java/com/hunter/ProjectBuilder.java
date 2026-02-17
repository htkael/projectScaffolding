package com.hunter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProjectBuilder {

  public static void main(String[] args) {
    int exitCode = 0;
    if (args.length < 1) {
      System.out.println(
          "Invalid arguments. Please provide a single string representing the name of the project you would like to create.");
      exitCode = -1;
      System.exit(exitCode);
    }
    String projectName = args[0];

    try {
      ProjectBuilder.createNestedDirectories(projectName + "/src/main/java/com/hunter");
      ProjectBuilder.createNestedDirectories(projectName + "/src/test/java/com/hunter");
      ProjectBuilder.createPomFile(projectName);
      ProjectBuilder.createMainFile(projectName);
    } catch (IOException e) {
      exitCode = -1;
      System.err.println(e.getMessage());
      System.exit(exitCode);
    }

    System.exit(exitCode);
  }

  private static void createNestedDirectories(String dirs) throws IOException {
    Path path = Paths.get(getCurrentDir() + "/" + dirs);

    try {
      Files.createDirectories(path);
    } catch (IOException e) {
      System.err.println("Failed to create directory: " + e.getMessage());
      e.printStackTrace();
      throw new IOException("Failed to create directory: " + e.getMessage());
    }
  }

  private static void createPomFile(String projectName) throws IOException {
    try {
      Path whereTo = Paths.get(getCurrentDir() + "/" + projectName + "/pom.xml");
      Path templatePath = Paths.get("pom.template.xml");
      String template = Files.readString(templatePath);
      String toWrite = template.replace("{{PROJECT_NAME}}", projectName);
      Files.writeString(whereTo, toWrite);
    } catch (IOException e) {
      System.err.println("Failed to write pom file: " + e.getMessage());
      e.printStackTrace();
      throw new IOException("Failed to write pom file: " + e.getMessage());
    }
  }

  private static void createMainFile(String projectName) throws IOException {
    try {
      Path whereTo = Paths.get(getCurrentDir() + "/" + projectName + "/src/main/java/com/hunter/Main.java");
      Path templatePath = Paths.get("Main.template.java");
      String toWrite = Files.readString(templatePath);
      Files.writeString(whereTo, toWrite);
    } catch (IOException e) {
      System.err.println("Failed to write Main.java file: " + e.getMessage());
      e.printStackTrace();
      throw new IOException("Failed to write Main.java file: " + e.getMessage());
    }
  }

  private static String getCurrentDir() {
    return System.getProperty("user.dir");
  }
}
