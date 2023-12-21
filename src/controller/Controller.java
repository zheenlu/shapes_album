package controller;

import model.album.Album;
import model.shape.Color;
import views.GraphicalView;
import views.WebView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * The type Controller.
 */
public class Controller implements IController {
  private final Album model = Album.getInstance();

  /**
   * Instantiates a new Controller.
   */
  public Controller() {
  }

  @Override
  public void readFile(String inputFileName, int x, int y) {
    try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.trim().startsWith("#")) {
          continue;
        }
        String[] tokens = line.trim().split("\\s+");
        String command = tokens[0].toLowerCase();
        String[] args = new String[tokens.length - 1];
        System.arraycopy(tokens, 1, args, 0, args.length);

        switch (command) {
          case "shape" -> createShape(args);
          case "move" -> moveShape(args);
          case "color" -> changeColor(args);
          case "resize" -> resizeShape(args);
          case "remove" -> removeShape(args);
          case "snapshot" -> takeSnapshot(args);
          default -> {
          }
        }
      }
    } catch (IOException e) {
      System.err.println("Failed to read file: " + inputFileName);
      e.printStackTrace();
    }
  }

  @Override
  public void runWebView(String input, String output, int x, int y) {
    readFile(input, x, y);
    WebView webView = WebView.getInstance(x, y);
    webView.runWebView(output, x, y);
  }

  @Override
  public void runGraphicalView(String input, int x, int y) {
    readFile(input, x, y);
    GraphicalView graphicalView = GraphicalView.getInstance(x, y); // 创建 GraphicalView 实例

    graphicalView.setVisible(true); // 将 GraphicalView 设置为可见
    graphicalView.repaint();
  }

  @Override
  public void createShape(String[] args) {
    String name = args[0];
    String shape = args[1];
    double xPos = Double.parseDouble(args[2]);
    double yPos = Double.parseDouble(args[3]);
    double xData = Double.parseDouble(args[4]);
    double yData = Double.parseDouble(args[5]);
    double colorR = Double.parseDouble(args[6]);
    double colorG = Double.parseDouble(args[7]);
    double colorB = Double.parseDouble(args[8]);
    Color color = new Color(colorR, colorG, colorB);
    model.addShape(shape, name, color, xPos, yPos, xData, yData);
  }

  @Override
  public void moveShape(String[] args) {
    String name = args[0];
    System.out.println("name" + name);
    double xPos = Double.parseDouble(args[1]);
    double yPos = Double.parseDouble(args[2]);
    model.move(name, xPos, yPos);
  }

  @Override
  public void changeColor(String[] args) {
    String name = args[1];
    int colorR = Integer.parseInt(args[2]);
    int colorG = Integer.parseInt(args[3]);
    int colorB = Integer.parseInt(args[4]);
    Color color = new Color(colorR, colorG, colorB);
    model.changeColor(name, color);
  }

  @Override
  public void resizeShape(String[] args) {
    String name = args[1];
    double xData = Double.parseDouble(args[2]);
    double yData = Double.parseDouble(args[3]);
    model.resize(name, xData, yData);
  }

  @Override
  public void removeShape(String[] args) {
    String name = args[1];
    model.removeShape(name);
  }

  @Override
  public void takeSnapshot(String[] args) {
    String description = "";
    if (args.length >= 2) {
      description = String.join(" ", Arrays.copyOfRange(args, 0, args.length));
    }
    model.takeSnapshots(description);
  }
}