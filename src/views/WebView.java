package views;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.album.Album;
import model.album.IPhotoAlbumModel;
import model.shape.IShape;
import model.snapshots.ISnapshot;

/**
 * The type Web view.
 */
public class WebView {
  private static WebView instance;
  private final IPhotoAlbumModel model = Album.getInstance();
  private Appendable out;
  private int xMax;
  private int yMax;

  private WebView(int x, int y) {
    this.xMax = x;
    this.yMax = y;
  }

  /**
   * Gets instance.
   *
   * @param x the x
   * @param y the y
   * @return the instance
   */
  public static WebView getInstance(Integer x, Integer y) {
    if (instance == null) {
      instance = new WebView(x == null ? 800 : x, y == null ? 800 : y);
    }
    return instance;
  }

  /**
   * Init.
   *
   * @param outputFile the output file
   * @param x          the x
   * @param y          the y
   */
  public void init(Appendable outputFile, int x, int y) {
    this.out = outputFile;
    this.xMax = x;
    this.yMax = y;
  }

  /**
   * Run web view.
   *
   * @param output the output
   * @param x      the x
   * @param y      the y
   */
  public void runWebView(String output, int x, int y) {
    try (FileWriter fileWriter = new FileWriter(output)) {
      this.xMax = x <= 0 ? 800 : x;
      this.yMax = y <= 0 ? 800 : y;
      String html = generateHTML();
      fileWriter.append(html);
      fileWriter.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void createHead() {
    try {
      out.append("<!DOCTYPE html>\n" +
              "<html lang=\"en\">\n" +
              "<head>\n" +
              "    <meta charset=\"UTF-8\">\n" +
              "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
              "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
              "    <title>Shapes Photo Album</title>\n" +
              "</head>\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void createBody() {
    try {
      out.append("<body>\n");
      out.append("<h1>Snapshot Photo Album</h1>\n");
      List<ISnapshot> snapshots = model.getSnapshots();
      if (!snapshots.isEmpty()) {
        for (ISnapshot snapshot : snapshots) {
          createSVG(snapshot);
        }
      } else {
        out.append("<p>No snapshots available.</p>\n");
      }
      out.append("</body>\n" +
              "</html>\n");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private void createSVG(ISnapshot snapshot) {
    try {
      out.append(String.format("<div style=\"background-color: cyan;\">\n" +
              "        <h2>%s</h2>\n", snapshot.getId()));
      if (!snapshot.getDescription().equals("")) {
        out.append(String.format("        <h3>%s</h3>\n", snapshot.getDescription()));
      }
      out.append(String.format("        <svg width=\"%d\" height=\"%d\">\n", xMax, yMax));
      for (IShape shape : snapshot.getShapes()) {
        if (shape.getType().equalsIgnoreCase("Rectangle")) {
          out.append(String.format("            <rect x=\"%.2f\" y=\"%.2f\" width=\"%.2f\" height=\"%.2f\" " +
                          "fill=\"rgb(%d, %d, %d)\" />\n",
                  shape.getXPos(),
                  shape.getYPos(),
                  shape.getRectangleWidth(),
                  shape.getRectangleHeight(),
                  (int) shape.getColor().getRed(),
                  (int) shape.getColor().getGreen(),
                  (int) shape.getColor().getBlue()));
        } else if (shape.getType().equalsIgnoreCase("Oval")) {
          out.append(String.format("            <ellipse cx=\"%.2f\" cy=\"%.2f\" rx=\"%.2f\" ry=\"%.2f\" " +
                          "fill=\"rgb(%d, %d, %d)\" />\n",
                  shape.getXPos(),
                  shape.getYPos(),
                  shape.getOvalXRadius(),
                  shape.getOvalYRadius(),
                  (int) shape.getColor().getRed(),
                  (int) shape.getColor().getGreen(),
                  (int) shape.getColor().getBlue()));
        }
      }
      out.append("        </svg>\n" +
              "    </div>\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Generate html string.
   *
   * @return the string
   */
  public String generateHTML() {
    StringBuilder htmlOutput = new StringBuilder();
    init(htmlOutput, xMax, yMax);
    createHead();
    createBody();
    return htmlOutput.toString();
  }
}

