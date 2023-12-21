package model.shape;

/**
 * The type Oval.
 */
public class Oval extends AbstractShape {
  private double xRadius;
  private double yRadius;

  /**
   * Instantiates a new Oval.
   *
   * @param name  the name
   * @param color the color
   * @param xPos  the x pos
   * @param yPos  the y pos
   * @param type  the type
   * @param xData the x data
   * @param yData the y data
   */
  public Oval(String name, Color color, double xPos, double yPos, String type, double xData, double yData) {
    super(name, color, xPos, yPos, type, xData, yData);
    this.xRadius = xData;
    this.yRadius = yData;
  }

  /**
   * Sets oval data.
   *
   * @param xRadius the x radius
   * @param yRadius the y radius
   */
  @Override
  public void setOvalData(double xRadius, double yRadius) {
    this.xRadius = xRadius;
    this.yRadius = yRadius;

  }

  /**
   * Gets oval x radius.
   *
   * @return the oval x radius
   */
  @Override
  public double getOvalXRadius() {
    return this.xRadius;
  }

  /**
   * Gets oval y radius.
   *
   * @return the oval y radius
   */
  @Override
  public double getOvalYRadius() {
    return this.yRadius;
  }

  @Override
  public String toString() {
    return "Name: " + getName() + "\n"
            + "Type: " + getType() + "\n"
            + "Center: (" + getXPos() + ", " + getYPos() + ")\n"
            + "X Radius: " + getOvalXRadius() + "\n"
            + "Y Radius: " + getOvalYRadius() + "\n"
            + "Color: " + getColor();
  }
}
