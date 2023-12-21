package model.shape;


/**
 * The interface Shape.
 */
public interface IShape {
  /**
   * Gets name.
   *
   * @return the name
   */
  String getName();

  /**
   * Gets type.
   *
   * @return the type
   */
  String getType();

  /**
   * Sets pos.
   *
   * @param xPos the x pos
   * @param yPos the y pos
   */
  void setPos(double xPos, double yPos);

  /**
   * Gets x pos.
   *
   * @return the x pos
   */
  double getXPos();

  /**
   * Gets y pos.
   *
   * @return the y pos
   */
  double getYPos();

  /**
   * Sets color.
   *
   * @param color the color
   */
  void setColor(Color color);

  /**
   * Gets color.
   *
   * @return the color
   */
  Color getColor();

  void setRectangleData(double width, double height);

  /**
   * Gets rectangle width.
   *
   * @return the rectangle width
   */
  double getRectangleWidth();

  /**
   * Gets rectangle height.
   *
   * @return the rectangle height
   */
  double getRectangleHeight();

  /**
   * Sets oval data.
   *
   * @param xRadius the x radius
   * @param yRadius the y radius
   */
  void setOvalData(double xRadius, double yRadius);

  /**
   * Gets oval x radius.
   *
   * @return the oval x radius
   */
  double getOvalXRadius();

  /**
   * Gets oval y radius.
   *
   * @return the oval y radius
   */
  double getOvalYRadius();
}
