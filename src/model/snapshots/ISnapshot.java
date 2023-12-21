package model.snapshots;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.album.Album;
import model.shape.IShape;


/**
 * The interface Snapshot.
 */
public interface ISnapshot {
  /**
   * Gets id.
   *
   * @return the id
   */
  String getId();

  /**
   * Gets timestamp.
   *
   * @return the timestamp
   */
  LocalDateTime getTimestamp();

  /**
   * Gets description.
   *
   * @return the description
   */
  String getDescription();

  /**
   * Gets shapes.
   *
   * @return the shapes
   */
  List<IShape> getShapes();

  /**
   * Sets album.
   *
   * @param album the album
   */
  void setAlbum(Album album);
}
