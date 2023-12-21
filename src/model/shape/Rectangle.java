package model.shape;

/**
 * The type Rectangle.
 */
public class Rectangle extends AbstractShape {
  private double width;
  private double height;

  /**
   * Instantiates a new Rectangle.
   *
   * @param name  the name
   * @param color the color
   * @param xPos  the x pos
   * @param yPos  the y pos
   * @param type  the type
   * @param xData the x data
   * @param yData the y data
   */
  public Rectangle(String name, Color color,
                   double xPos, double yPos,
                   String type, double xData,
                   double yData) {
    super(name, color, xPos, yPos, type, xData, yData);
    this.width = xData;
    this.height = yData;
  }

  /**
   * Sets rectangle data.
   *
   * @param xData the width
   * @param yData the height
   */
  public void setRectangleData(double xData, double yData) {
    this.width = xData;
    this.height = yData;
  }

  /**
   * Gets rectangle width.
   *
   * @return the rectangle width
   */
  public double getRectangleWidth() {
    return this.width;
  }

  /**
   * Gets rectangle height.
   *
   * @return the rectangle height
   */
  public double getRectangleHeight() {
    return this.height;
  }


  @Override
  public String toString() {
    return "Name: " + getName() + "\n"
            + "Type: " + getType() + "\n"
            + "Center: (" + getXPos() + ", " + getYPos() + ")\n"
            + "Width: " + getRectangleWidth() + "\n"
            + "Height: " + getRectangleHeight() + "\n"
            + "Color: " + getColor();
  }
}
