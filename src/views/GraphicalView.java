
package views;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import model.album.Album;
import model.album.IPhotoAlbumModel;
import model.snapshots.ISnapshot;

/**
 * The type Graphical view.
 */
public class GraphicalView extends JFrame {
  private final JFrame frame;
  private static GraphicalView instance;
  private final IPhotoAlbumModel model = Album.getInstance();
  private final ArrayList<ISnapshot> snapshotList = model.getSnapshots();
  private final int xFrame;
  private final int yFrame;
  private final JPanel buttonsPanel = new JPanel();
  private final JPanel snapshotPanel = new JPanel();
  private int currentSnapshotIndex;
  private final JButton Prev = new JButton("<< Prev <<");
  private final JButton Select = new JButton("^^ Select ^^");
  private final JButton Next = new JButton(">> Next >>");
  private final JButton Quit = new JButton("xx Quit xx");

  /**
   * Instantiates a new Graphical view.
   *
   * @param x the x
   * @param y the y
   */
  public GraphicalView(int x, int y) {
    this.xFrame = x;
    this.yFrame = y;
    frame = new JFrame("Photo Album Display");
    frame.setSize(this.xFrame, this.yFrame);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    createButtonsPanel();
    createSnapshotPanel();
    getAllSnapshots();
    displaySnapshotPanel(currentSnapshotIndex);
    frame.pack();
    frame.setVisible(true);
  }

  /**
   * Gets instance.
   *
   * @param x the x
   * @param y the y
   * @return the instance
   */
  public static GraphicalView getInstance(int x, int y) {
    if (instance == null) {
      instance = new GraphicalView(x, y);
    }
    return instance;
  }

  private void createSnapshotPanel() {
    snapshotPanel.setBackground(Color.white);
    BoxLayout boxLayout = new BoxLayout(snapshotPanel, BoxLayout.PAGE_AXIS);
    snapshotPanel.setLayout(boxLayout);
    frame.add(snapshotPanel, BorderLayout.CENTER);
  }

  private void createButtonsPanel() {
    buttonsPanel.setBackground(Color.white);
    showButtons();
    frame.add(buttonsPanel, BorderLayout.SOUTH);
  }

  private void showButtons() {
    buttonsPanel.setLayout(new GridLayout(2, 4, 20, 10));
    buttonsPanel.add(Prev);
    buttonsPanel.add(Select);
    buttonsPanel.add(Next);
    buttonsPanel.add(Quit);
    clickPrev();
    clickSelect();
    clickNext();
    clickQuit();
    buttonsPanel.setLayout(new GridLayout(2, 2));
    buttonsPanel.setBackground(Color.yellow);
  }

  private void getAllSnapshots() {
    if (snapshotList.size() == 0) {
      JOptionPane.showMessageDialog(null,
              "Empty Snapshot List",
              "Message",
              JOptionPane.WARNING_MESSAGE);
    }
    snapshotPanel.setLayout(new BorderLayout());
    currentSnapshotIndex = 0;
  }

  private void displaySnapshotPanel(int currentIndex) {
    if (snapshotPanel.getComponentCount() > 0) {
      snapshotPanel.remove(0); // Remove the previous panel
    }
    if (snapshotList.size() != 0) {
      SnapshotPanel currentSnapshot = new SnapshotPanel(snapshotList.get(currentIndex), this.xFrame, this.yFrame);
      snapshotPanel.add(currentSnapshot, BorderLayout.CENTER);
      currentSnapshot.setVisible(true);
      snapshotPanel.revalidate();
      snapshotPanel.repaint();
    }
  }

  private void clickPrev() {
    Prev.addActionListener(e -> {
      if (currentSnapshotIndex > 0) {
        currentSnapshotIndex--;
        displaySnapshotPanel(currentSnapshotIndex);
      } else {
        JOptionPane.showMessageDialog(null,
                "No further snapshots exist",
                "Message",
                JOptionPane.WARNING_MESSAGE);
      }
    });
  }

  private void clickSelect() {
    Select.addActionListener(e -> {
      if (snapshotList.size() != 0) {
        String[] indices = new String[snapshotList.size()];
        for (int i = 0; i < snapshotList.size(); i++) {
          indices[i] = String.valueOf(i);
        }
        String indexStr = (String) JOptionPane.showInputDialog(null, "Choose snapshot",
                "Please choose an index:",
                JOptionPane.INFORMATION_MESSAGE, null, indices, indices[0]);
        int index = Integer.parseInt(indexStr);
        if (index >= 0 && index < snapshotList.size()) {
          displaySnapshotPanel(index);
        }
      }
    });
  }

  private void clickNext() {
    Next.addActionListener(e -> {
      if (currentSnapshotIndex < snapshotList.size() - 1) {
        currentSnapshotIndex++;
        displaySnapshotPanel(currentSnapshotIndex);
      } else {
        JOptionPane.showMessageDialog(null,
                "Last snapshot",
                "Message",
                JOptionPane.WARNING_MESSAGE);
      }
    });
  }

  private void clickQuit() {
    Quit.addActionListener(e -> {
      setVisible(false);
      dispose();
    });
  }

  public void setVisible(boolean visible) {
    frame.setVisible(visible);
  }

}