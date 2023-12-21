import java.io.IOException;

import controller.Controller;
import model.album.Album;

/**
 * The type Photo album main.
 */
public class PhotoAlbumMain {
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   * @throws IOException the io exception
   */
  public static void main(String[] args) throws IOException {
    Controller controller = new Controller();
    String inputFileName = null;
    String outputFileName = null;
    String viewType = null;
    int x = 0;
    int y = 0;

    for (int i = 0; i < args.length; i++) {
      String arg = args[i];
      switch (arg) {
        case "-in" -> {
          if (i + 1 < args.length) {
            inputFileName = args[++i];
          } else {
            System.err.println("Missing input file name");
            System.exit(1);
          }
        }
        case "-out" -> {
          if (i + 1 < args.length) {
            outputFileName = args[++i];
          } else {
            System.err.println("Missing output file name");
            System.exit(1);
          }
        }
        case "-view", "-v" -> {
          if (i + 1 < args.length) {
            viewType = args[++i];
          } else {
            System.err.println("Missing view type");
            System.exit(1);
          }
        }
        default -> {
          try {
            int argValue = Integer.parseInt(arg);
            if (x == 0) {
              x = argValue;
            } else if (y == 0) {
              y = argValue;
            }
          } catch (NumberFormatException e) {
            System.err.println("Unknown option: " + arg);
            System.exit(1);
          }
        }
      }
    }

    if (inputFileName == null || viewType == null) {
      System.err.println("Input file and view type are mandatory");
      System.exit(1);
    }

    if (outputFileName == null && viewType.equals("web")) {
      System.err.println("Output file is required for web view type");
      System.exit(1);
    }

    if (viewType.equals("web")) {
      controller.runWebView(inputFileName, outputFileName, x, y);
    } else if (viewType.equals("graphical")) {
      controller.runGraphicalView(inputFileName, x, y);
    } else {
      System.err.println("Unknown view type: " + viewType);
      System.exit(1);
    }
  }
}
