package io.devonfw.application.authors.general.common.api;

/**
 * This is the interface for a {@link BinaryObject} of the authors.
 */
public interface BinaryObject extends ApplicationEntity {

  /**
   * @param mimeType is the MIME-Type of this {@link BinaryObject}
   */
  void setMimeType(String mimeType);

  /**
   * Returns MIME-Type of thie {@link BinaryObject}
   *
   * @return the MIME-Type, e.g image/jpeg
   */
  String getMimeType();

  /**
   * @return Returns the size in bytes
   */
  long getSize();

  /**
   * Sets the size of bytes
   *
   * @param size the size in bytes
   */
  void setSize(long size);

}
