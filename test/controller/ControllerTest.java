package controller;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * The type Controller test.
 */
public class ControllerTest {
  private Controller controller;

  /**
   * Sets up.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    controller = new Controller();
  }

  /**
   * Test run web view.
   *
   * @throws IOException the io exception
   */
  @Test
  public void testRunWebView() throws IOException {
    String inputFileName = "test_input.txt";
    String outputFileName = "test_output.html";
    int x = 800;
    int y = 800;

    // Create test input file
    Path inputPath = Paths.get(inputFileName);
    Files.writeString(inputPath, "# canvas 0 0 800 800\n" +
            "shape background rectangle 0 0 800 800 33 94 248\n" +
            "shape B0 rectangle 80 424 100 326 0 0 0\n" +
            "shape B1 rectangle 260 365 100 385 0 0 0\n" +
            "shape B2 rectangle 440 375 100 375 0 0 0\n" +
            "shape B3 rectangle 620 445 100 305 0 0 0\n" +
            "shape window000 rectangle 100 500 20 20 255 255 255\n" +
            "shape window001 rectangle 140 500 20 20 255 255 255\n" +
            "shape window010 rectangle 100 600 20 20 255 255 255\n" +
            "shape window011 rectangle 140 600 20 20 255 255 255\n" +
            "shape window002 rectangle 280 500 20 20 255 255 255\n" +
            "shape window021 rectangle 320 500 20 20 255 255 255\n" +
            "shape window022 rectangle 280 600 20 20 255 255 255\n" +
            "shape window200 rectangle 320 600 20 20 255 255 255\n" +
            "# Lights On!\n" +
            "shape window003 rectangle 460 500 20 20 255 255 255\n" +
            "shape window033 rectangle 500 500 20 20 255 255 255\n" +
            "shape window333 rectangle 460 600 20 20 255 255 255\n" +
            "shape window313 rectangle 500 600 20 20 255 255 255\n" +
            "shape window004 rectangle 640 500 20 20 255 255 255\n" +
            "shape window044 rectangle 680 500 20 20 255 255 255\n" +
            "shape window444 rectangle 640 600 20 20 255 255 255\n" +
            "shape window414 rectangle 680 600 20 20 255 255 255\n" +
            "shape moon oval 200 200 100 100 229 229 255\n");

    // Run the method
    controller.runWebView(inputFileName, outputFileName, x, y);

    // Verify the output file was created
    File outputFile = new File(outputFileName);
    assertTrue(outputFile.exists());

    // Verify the content of the output file
    try (BufferedReader reader = new BufferedReader(new FileReader(outputFileName))) {
      StringBuilder content = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line).append("\n");
      }
      String expectedHtmlContent = "<!DOCTYPE html>\n" +
              "<html lang=\"en\">\n" +
              "<head>\n" +
              "    <meta charset=\"UTF-8\">\n" +
              "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
              "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
              "    <title>Shapes Photo Album</title>\n" +
              "</head>\n" +
              "<body>\n" +
              "<h1>Snapshot Photo Album</h1>\n" +
              "<p>No snapshots available.</p>\n" +
              "</body>\n" +
              "</html>\n";
      assertEquals(expectedHtmlContent, content.toString());
    } finally {
      // Clean up the test files
      Files.deleteIfExists(inputPath);
      Files.deleteIfExists(Paths.get(outputFileName));
    }
  }
}