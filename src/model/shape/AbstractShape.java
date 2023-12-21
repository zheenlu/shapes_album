package model.shape;


/**
 * The type Abstract shape.
 */
public abstract class AbstractShape implements IShape {
  private String name;
  private Color color;
  private String type;
  private double xPos;
  private double yPos;
  private double xData;
  private double yData;

  /**
   * Instantiates a new Abstract shape.
   *
   * @param name  the name
   * @param color the color
   * @param xPos  the x pos
   * @param yPos  the y pos
   * @param type  the type
   * @param xData the x data
   * @param yData the y data
   */
  public AbstractShape(String name, Color color, double xPos,
                       double yPos, String type,
                       double xData, double yData) {
    this.name = name;
    this.color = color;
    this.type = type;
    this.xPos = xPos;
    this.yPos = yPos;
    this.xData = xData;
    this.yData = yData;
  }


  public String getName() {
    return this.name;
  }


  public String getType() {
    return this.type;
  }


  public void setPos(double xPos, double yPos) {
    this.xPos = xPos;
    this.yPos = yPos;
  }


  public double getXPos() {
    return this.xPos;
  }


  public double getYPos() {
    return this.yPos;
  }


  public void setColor(Color color) {
    this.color = color;
  }


  public Color getColor() {
    return this.color;
  }


  public void setRectangleData(double xData, double yData) {
    this.xData = xData;
    this.yData = yData;
  }


  public double getRectangleWidth() {
    return this.xData;
  }


  public double getRectangleHeight() {
    return this.yData;
  }

  public void setOvalData(double xData, double yData) {
    this.xData = xData;
    this.yData = yData;
  }

  public double getOvalXRadius() {
    return this.xData;
  }

  public double getOvalYRadius() {
    return this.yData;
  }
}
