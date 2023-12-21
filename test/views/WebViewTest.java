package views;

import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

import controller.Controller;
import model.album.Album;
import model.album.IPhotoAlbumModel;

/**
 * The type Web view test.
 */
public class WebViewTest {
  private WebView webView;
  private IPhotoAlbumModel model;

  /**
   * Sets up.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    webView = WebView.getInstance(800, 800);
    model = Album.getInstance();
  }

  /**
   * Test generate html.
   */
  @Test
  public void testGenerateHTML() {
    Controller controller = new Controller();
    WebView webView = WebView.getInstance(800, 800);

    String inputFileName = "buildings.txt";
    // Read the input file and populate the model
    controller.readFile(inputFileName, 800, 800);

    // Generate the actual HTML
    String actualHTML = webView.generateHTML();

    // Remove the three lines containing the timestamps
    String pattern = "(<h2>).*?(</h2>)";
    Pattern compiledPattern = Pattern.compile(pattern, Pattern.DOTALL);
    Matcher matcher = compiledPattern.matcher(actualHTML);
    actualHTML = matcher.replaceAll("");

    // Define the delimiter for splitting the HTML
    String sectionDelimiter = "<div style=\"background-color: cyan;\">";

    // Split the HTML into sections
    String[] sections = actualHTML.split(sectionDelimiter, -1);

    // Concatenate the common starting HTML tags to each section
    String startTags = sections[0];
    String section1Html = startTags + sectionDelimiter + sections[1];
    String section2Html = startTags + sectionDelimiter + sections[2];
    String section3Html = startTags + sectionDelimiter + sections[3];

    // Define the expected HTML strings for each section
    String expectedSection1Html = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <title>Shapes Photo Album</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1>Snapshot Photo Album</h1>\n" +
            "<div style=\"background-color: cyan;\">\n" +
            "        \n" +
            "        <svg width=\"800\" height=\"800\">\n" +
            "            <rect x=\"0.00\" y=\"0.00\" width=\"800.00\" height=\"800.00\" fill=\"rgb(33, 94, 248)\" />\n" +
            "            <rect x=\"80.00\" y=\"424.00\" width=\"100.00\" height=\"326.00\" fill=\"rgb(0, 0, 0)\" />\n" +
            "            <rect x=\"260.00\" y=\"365.00\" width=\"100.00\" height=\"385.00\" fill=\"rgb(0, 0, 0)\" />\n" +
            "            <rect x=\"440.00\" y=\"375.00\" width=\"100.00\" height=\"375.00\" fill=\"rgb(0, 0, 0)\" />\n" +
            "            <rect x=\"620.00\" y=\"445.00\" width=\"100.00\" height=\"305.00\" fill=\"rgb(0, 0, 0)\" />\n" +
            "            <rect x=\"100.00\" y=\"500.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"140.00\" y=\"500.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"100.00\" y=\"600.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"140.00\" y=\"600.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "        </svg>\n" +
            "    </div>\n";
    String expectedSection2Html = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <title>Shapes Photo Album</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1>Snapshot Photo Album</h1>\n" +
            "<div style=\"background-color: cyan;\">\n" +
            "        \n" +
            "        <svg width=\"800\" height=\"800\">\n" +
            "            <rect x=\"0.00\" y=\"0.00\" width=\"800.00\" height=\"800.00\" fill=\"rgb(33, 94, 248)\" />\n" +
            "            <rect x=\"80.00\" y=\"424.00\" width=\"100.00\" height=\"326.00\" fill=\"rgb(0, 0, 0)\" />\n" +
            "            <rect x=\"260.00\" y=\"365.00\" width=\"100.00\" height=\"385.00\" fill=\"rgb(0, 0, 0)\" />\n" +
            "            <rect x=\"440.00\" y=\"375.00\" width=\"100.00\" height=\"375.00\" fill=\"rgb(0, 0, 0)\" />\n" +
            "            <rect x=\"620.00\" y=\"445.00\" width=\"100.00\" height=\"305.00\" fill=\"rgb(0, 0, 0)\" />\n" +
            "            <rect x=\"100.00\" y=\"500.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"140.00\" y=\"500.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"100.00\" y=\"600.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"140.00\" y=\"600.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"280.00\" y=\"500.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"320.00\" y=\"500.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"280.00\" y=\"600.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"320.00\" y=\"600.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "        </svg>\n" +
            "    </div>\n";
    String expectedSection3Html = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <title>Shapes Photo Album</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1>Snapshot Photo Album</h1>\n" +
            "<div style=\"background-color: cyan;\">\n" +
            "        \n" +
            "        <h3>Turn on the Lights!</h3>\n" +
            "        <svg width=\"800\" height=\"800\">\n" +
            "            <rect x=\"0.00\" y=\"0.00\" width=\"800.00\" height=\"800.00\" fill=\"rgb(33, 94, 248)\" />\n" +
            "            <rect x=\"80.00\" y=\"424.00\" width=\"100.00\" height=\"326.00\" fill=\"rgb(0, 0, 0)\" />\n" +
            "            <rect x=\"260.00\" y=\"365.00\" width=\"100.00\" height=\"385.00\" fill=\"rgb(0, 0, 0)\" />\n" +
            "            <rect x=\"440.00\" y=\"375.00\" width=\"100.00\" height=\"375.00\" fill=\"rgb(0, 0, 0)\" />\n" +
            "            <rect x=\"620.00\" y=\"445.00\" width=\"100.00\" height=\"305.00\" fill=\"rgb(0, 0, 0)\" />\n" +
            "            <rect x=\"100.00\" y=\"500.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"140.00\" y=\"500.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"100.00\" y=\"600.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"140.00\" y=\"600.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"280.00\" y=\"500.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"320.00\" y=\"500.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"280.00\" y=\"600.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"320.00\" y=\"600.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"460.00\" y=\"500.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"500.00\" y=\"500.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"460.00\" y=\"600.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"500.00\" y=\"600.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"640.00\" y=\"500.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"680.00\" y=\"500.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"640.00\" y=\"600.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <rect x=\"680.00\" y=\"600.00\" width=\"20.00\" height=\"20.00\" fill=\"rgb(255, 255, 255)\" />\n" +
            "            <ellipse cx=\"200.00\" cy=\"200.00\" rx=\"100.00\" ry=\"100.00\" fill=\"rgb(229, 229, 255)\" />\n" +
            "        </svg>\n" +
            "    </div>\n" +
            "</body>\n" +
            "</html>\n";
    // Perform assertEquals on each section
    assertEquals(expectedSection1Html, section1Html);
    assertEquals(expectedSection2Html, section2Html);
    assertEquals(expectedSection3Html, section3Html);
  }
}