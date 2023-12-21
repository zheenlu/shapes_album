package model.snapshots;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.album.Album;
import model.shape.IShape;

/**
 * The type Snapshots.
 */
public class Snapshots implements ISnapshot {

  private final String ID;
  private final LocalDateTime timeStamp;
  private final String description;
  private Album photoAlbum;
  private static final DateTimeFormatter format =
          DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");

  /**
   * The Snapshot shapes.
   */
  public Map<String, Map<String, IShape>> snapshotShapes;

  /**
   * Instantiates a new Snapshots.
   *
   * @param description the description
   */
  public Snapshots(String description) {
    this.description = description;
    this.timeStamp = LocalDateTime.now();
    this.ID = LocalDateTime.now().format(format);
    this.snapshotShapes = new HashMap<>();
  }

  @Override
  public String getId() {
    return this.ID;
  }

  @Override
  public LocalDateTime getTimestamp() {
    return this.timeStamp;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public List<IShape> getShapes() {
    return photoAlbum.getShapesCollage();
  }

  @Override
  public void setAlbum(Album album) {
    this.photoAlbum = album;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Printing Snapshots\n");
    sb.append("Snapshot ID: ").append(this.getId()).append("\n");
    sb.append("Timestamp: ").append(this.getTimestamp()).append("\n");
    sb.append("Description: ").append(this.getDescription()).append("\n");
    sb.append("Shape Information: \n");
    List<IShape> shapes = new ArrayList<>(this.photoAlbum.getShapesCollage());
    for (IShape shape : shapes) {
      sb.append(shape.toString()).append("\n");
      sb.append("\n");
    }
    return sb.toString();
  }
}
