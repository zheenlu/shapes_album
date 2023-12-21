package model.album;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.shape.Color;
import model.shape.IShape;
import model.snapshots.ISnapshot;


/**
 * The interface Photo album model.
 */
public interface IPhotoAlbumModel {
  /**
   * Create shape shape.
   *
   * @param shapeType the shape type
   * @param name      the name
   * @param color     the color
   * @param xPos      the x pos
   * @param yPos      the y pos
   * @param xData     the x data
   * @param yData     the y data
   * @return the shape
   */
  IShape createShape(String shapeType, String name, Color color,
                     double xPos, double yPos, double xData, double yData);

  /**
   * Add shape.
   *
   * @param shapeType the shape type
   * @param name      the name
   * @param color     the color
   * @param xPos      the x pos
   * @param yPos      the y pos
   * @param xData     the x data
   * @param yData     the y data
   * @throws IllegalArgumentException the illegal argument exception
   */
  void addShape(String shapeType, String name, Color color,
                double xPos, double yPos, double xData, double yData) throws IllegalArgumentException;

  /**
   * Remove shape.
   *
   * @param name the name
   * @throws IllegalArgumentException the illegal argument exception
   */
  void removeShape(String name) throws IllegalArgumentException;

  /**
   * Move.
   *
   * @param name    the name
   * @param newXPos the new x pos
   * @param newYPos the new y pos
   */
  void move(String name, double newXPos, double newYPos);

  /**
   * Change color.
   *
   * @param name     the name
   * @param newColor the new color
   */
  void changeColor(String name, Color newColor);

  /**
   * Resize.
   *
   * @param name     the name
   * @param newXData the new x data
   * @param newYData the new y data
   * @throws IllegalArgumentException the illegal argument exception
   */
  void resize(String name, double newXData, double newYData) throws IllegalArgumentException;

  /**
   * Gets shapes collage.
   *
   * @return the shapes collage
   */
  List<IShape> getShapesCollage();

  /**
   * Take snapshots.
   *
   * @param description the description
   */
  void takeSnapshots(String description);

  /**
   * Gets snapshots.
   *
   * @return the snapshots
   */
  ArrayList<ISnapshot> getSnapshots();

}
