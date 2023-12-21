package views;

import java.awt.*;
import javax.swing.*;
import model.snapshots.ISnapshot;

/**
 * The type Snapshot panel.
 */
public class SnapshotPanel extends JPanel {
  private final ISnapshot snapshot;
  private final int x;
  private final int y;

  /**
   * Instantiates a new Snapshot panel.
   *
   * @param snapshot the snapshot
   * @param x        the x
   * @param y        the y
   */
  public SnapshotPanel(ISnapshot snapshot, int x, int y) {
    super();
    this.snapshot = snapshot;
    this.x = x;
    this.y = y;
    setLayout(new BorderLayout());
    drawIdDescription();
    drawShapes();
  }

  /**
   * Draw id description.
   */
  public void drawIdDescription() {
    JPanel idDescriptionPanel = new JPanel();
    idDescriptionPanel.setBackground(Color.pink);
    idDescriptionPanel.setLayout(new GridLayout(2, 1));
    JLabel idLabel = new JLabel(snapshot.getId());
    idDescriptionPanel.add(idLabel);
    JLabel descriptionLabel = new JLabel(snapshot.getDescription());
    idDescriptionPanel.add(descriptionLabel);
    add(idDescriptionPanel, BorderLayout.NORTH);
  }

  private void drawShapes() {
    JPanel drawPanel = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        snapshot.getShapes().forEach(shape -> {
          g.setColor(new Color(
                  (int) shape.getColor().getRed(),
                  (int) shape.getColor().getGreen(),
                  (int) shape.getColor().getBlue()));
          int posX = (int) shape.getXPos();
          int posY = (int) shape.getYPos();
          int xData, yData;
          if (shape.getType().equalsIgnoreCase("Rectangle")) {
            xData = (int) shape.getRectangleWidth();
            yData = (int) shape.getRectangleHeight();
            g.fillRect(posX, posY, xData, yData);
          } else if (shape.getType().equalsIgnoreCase("Oval")) {
            xData = (int) shape.getOvalXRadius();
            yData = (int) shape.getOvalYRadius();
            g.fillOval(posX, posY, xData, yData);
          }
        });
      }
    };
    drawPanel.setBackground(Color.BLUE);
    drawPanel.setPreferredSize(new Dimension(this.x, this.y));
    drawPanel.setVisible(true);
    add(drawPanel, BorderLayout.CENTER);
  }
}