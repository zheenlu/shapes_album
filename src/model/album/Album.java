package model.album;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.shape.Color;
import model.shape.IShape;
import model.shape.Oval;
import model.shape.Rectangle;
import model.snapshots.ISnapshot;
import model.snapshots.Snapshots;


/**
 * The type Album.
 */
public class Album implements IPhotoAlbumModel {
  private static Album instance;
  private ArrayList<IShape> shapesCollage = new ArrayList<>();
  private ArrayList<ISnapshot> snapshots = new ArrayList<>();

  /**
   * Instantiates a new Album.
   */
  public Album() {
  }

  /**
   * Gets instance.
   *
   * @return the instance
   */
  public static Album getInstance() {
    if (instance == null) {
      instance = new Album();
    }
    return instance;
  }

  @Override
  public IShape createShape(String shapeType, String name, Color color,
                            double xPos, double yPos, double xData, double yData) {
    if (shapeType.equalsIgnoreCase("Rectangle")) {
      return new Rectangle(name, color, xPos, yPos, shapeType, xData, yData);
    } else if (shapeType.equalsIgnoreCase("Oval")) {
      return new Oval(name, color, xPos, yPos, shapeType, xData, yData);
    }
    return null;
  }

  @Override
  public void addShape(String shapeType, String name, Color color,
                       double xPos, double yPos, double xData, double yData) throws IllegalArgumentException {
    IShape newShape = createShape(shapeType, name, color, xPos, yPos, xData, yData);
    for (int i = 0; i < shapesCollage.size(); i++) {
      IShape shape = shapesCollage.get(i);
      if (shape.getName().equals(name)) {
        throw new IllegalArgumentException("Shape name already exists in the collage.");
      }
    }
    shapesCollage.add(newShape);
  }


  @Override
  public void removeShape(String name) throws IllegalArgumentException {
    IShape shapeToRemove = null;
    for (IShape shape : shapesCollage) {
      if (shape.getName().equals(name)) {
        shapeToRemove = shape;
        break;
      }
    }
    if (shapeToRemove != null) {
      shapesCollage.remove(shapeToRemove);
    }
  }

  @Override
  public void move(String name, double newXPos, double newYPos) {
    IShape shape = null;
    for (IShape s : shapesCollage) {
      if (s.getName().equalsIgnoreCase(name)) {
        shape = s;
        break;
      }
    }
    if (shape == null) {
      throw new IllegalArgumentException("Shape not found in the collage");
    }
    shape.setPos(newXPos, newYPos);
  }

  @Override
  public void changeColor(String name, Color newColor) {
    boolean shapeFound = false;
    for (IShape shape : shapesCollage) {
      if (shape.getName().equalsIgnoreCase(name)) {
        shape.setColor(newColor);
        shapeFound = true;
        break;
      }
    }
    if (!shapeFound) {
      throw new IllegalArgumentException("Shape with name " + name + " not found.");
    }
  }

  @Override
  public void resize(String name, double newXData, double newYData) throws IllegalArgumentException {
    if (newXData < 0 || newYData < 0) {
      throw new IllegalArgumentException("Size cannot be negative");
    }
    boolean shapeExists = false;
    IShape shape = null;
    for (int i = 0; i < shapesCollage.size(); i++) {
      IShape s = shapesCollage.get(i);
      if (s.getName().equalsIgnoreCase(name)) {
        shapeExists = true;
        shape = s;
        break;
      }
    }
    if (!shapeExists) {
      throw new IllegalArgumentException("Shape not found in the album");
    }
    if (shape instanceof Rectangle) {
      shape.setRectangleData(newXData, newYData);
    } else if (shape instanceof Oval) {
      shape.setOvalData(newXData, newYData);
    }
  }

  @Override
  public List<IShape> getShapesCollage() {
    return Collections.unmodifiableList(shapesCollage);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Shapes collage:\n");
    for (IShape shape : shapesCollage) {
      sb.append(shape);
      sb.append("\n");
    }
    sb.append("Snapshots:\n");
    for (ISnapshot snapshot : snapshots) {
      sb.append(snapshot);
      sb.append("\n");
    }
    return sb.toString();
  }

  @Override
  public void takeSnapshots(String description) { //description
    Album newAlbum = new Album();
    List<IShape> shapes = new ArrayList<>(this.shapesCollage);
    for (IShape shape : shapes) {
      String shapeType = shape.getClass().getSimpleName();
      String name = shape.getName();
      Color color = shape.getColor();
      double xPos = shape.getXPos();
      double yPos = shape.getYPos();
      double xData = 0;
      double yData = 0;
      if (shape instanceof Rectangle) {
        xData = shape.getRectangleWidth();
        yData = shape.getRectangleHeight();
      } else if (shape instanceof Oval) {
        xData = shape.getOvalXRadius();
        yData = shape.getOvalYRadius();
      }
      newAlbum.addShape(shapeType, name, color, xPos, yPos, xData, yData);
    }
    Snapshots snapshots = new Snapshots(description);
    snapshots.setAlbum(newAlbum);
    this.snapshots.add(snapshots);
  }

  @Override
  public ArrayList<ISnapshot> getSnapshots() {
    return this.snapshots;
  }
}
