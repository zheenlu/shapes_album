package controller;

import java.util.Map;

import model.shape.Color;
import model.shape.IShape;

/**
 * The interface Controller.
 */
public interface IController {
  /**
   * Read file.
   *
   * @param inputFileName the input file name
   * @param x             the x
   * @param y             the y
   */
  void readFile(String inputFileName, int x, int y);

  /**
   * Run web view.
   *
   * @param input  the input
   * @param output the output
   * @param x      the x
   * @param y      the y
   */
  void runWebView(String input, String output, int x, int y);

  /**
   * Run graphical view.
   *
   * @param input the input
   * @param x     the x
   * @param y     the y
   */
  void runGraphicalView(String input, int x, int y);

  /**
   * Create shape.
   *
   * @param args the args
   */
  void createShape(String[] args);

  /**
   * Move shape.
   *
   * @param args the args
   */
  void moveShape(String[] args);

  /**
   * Change color.
   *
   * @param args the args
   */
  void changeColor(String[] args);

  /**
   * Resize shape.
   *
   * @param args the args
   */
  void resizeShape(String[] args);

  /**
   * Remove shape.
   *
   * @param args the args
   */
  void removeShape(String[] args);

  /**
   * Take snapshot.
   *
   * @param args the args
   */
  void takeSnapshot(String[] args);

}
