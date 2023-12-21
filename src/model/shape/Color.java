package model.shape;

/**
 * The type Color.
 */
public class Color {
  private final double red;
  private final double green;
  private final double blue;
  private static final double min = 0.0;
  private static final double max = 255.0;

  /**
   * Instantiates a new Color.
   *
   * @param r the r
   * @param g the g
   * @param b the b
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Color(double r, double g, double b) throws IllegalArgumentException {
    if (r < min || r > max || g < min || g > max || b < min || b > max) {
      throw new IllegalArgumentException("Color values must be between 0.0 and 255.0.");
    }
    this.red = r;
    this.green = g;
    this.blue = b;
  }

  /**
   * Gets red.
   *
   * @return the red
   */
  public double getRed() {
    return this.red;
  }

  /**
   * Gets green.
   *
   * @return the green
   */
  public double getGreen() {
    return this.green;
  }

  /**
   * Gets blue.
   *
   * @return the blue
   */
  public double getBlue() {
    return this.blue;
  }

  @Override
  public String toString() {
    return String.format("(%.1f, %.1f, %.1f)", red, green, blue);
  }
}
