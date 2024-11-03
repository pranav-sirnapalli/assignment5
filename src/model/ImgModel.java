package model;

import model.image.Image;

/**
 * ImgOperations interface defines the operations that can be performed on images.
 */
public interface ImgModel {

  /**
   * Splits an image into its RGB components.
   *
   * @param image the Image to be split
   * @return an RGBImage object containing separate channels for red, green, and blue
   */
  Image splitImage(Image image);

  /**
   * Combines the red, green, and blue components of separate images into one final image.
   *
   * @param red   the Image containing the red channel
   * @param green the Image containing the green channel
   * @param blue  the Image containing the blue channel
   * @return the combined Image
   */
  Image combineImage(Image red, Image green, Image blue);

  /**
   * Flips an image horizontally (left to right).
   *
   * @param img the Image to be flipped
   * @return the horizontally flipped Image
   */
  Image flipHorizontal(Image img);

  /**
   * Flips the given image vertically.
   *
   * @param img the image to be flipped
   * @return a new Image object that is vertically flipped
   */
  Image flipVertical(Image img);

  /**
   * Brightens the given image by a specified increment.
   *
   * @param img       the image to brighten
   * @param increment the amount to increase the brightness
   * @return a new Image object that is brightened
   */
  Image brighten(Image img, int increment);

  /**
   * Converts the given image to greyscale.
   *
   * @param img the image to convert
   * @return a new Image object that is in greyscale
   */
  Image toGreyscale(Image img);

  /**
   * Applies a blur effect to the given image.
   *
   * @param img the image to blur
   * @return a new Image object that is blurred
   */
  Image blur(Image img);

  /**
   * Applies a sepia filter to the given image.
   *
   * @param img the image to apply the filter on
   * @return a new Image object with the sepia effect applied
   */
  Image sepia(Image img);

  /**
   * Applies a sharpening filter to the given image.
   *
   * @param img the image to sharpen
   * @return a new Image object with the sharpened effect applied
   */
  Image sharpen(Image img);

  /**
   * Converts an RGB image to a grayscale image based on the max value calculation.
   *
   * @param img the input RGB image to be converted
   * @return a new grayscale image representing the max value of the original image
   */
  Image value(Image img);

  /**
   * Converts an RGB image to a grayscale image based on the intensity calculation.
   *
   * @param img the input RGB image to be converted
   * @return a new grayscale image representing the intensity of the original image
   */
  Image intensity(Image img);

  /**
   * Converts an RGB image to a grayscale image based on the luma calculation.
   *
   * @param img the input RGB image to be converted
   * @return a new grayscale image representing the luma of the original image
   */
  Image luma(Image img);

  /**
   * Converts an RGB image to a grayscale image based on red component.
   *
   * @param img the input RGB image to be converted
   * @return a new grayscale image representing the red component of the original image
   */
  Image redComponent(Image img);

  /**
   * Converts an RGB image to a grayscale image based on green component.
   *
   * @param img the input RGB image to be converted
   * @return a new grayscale image representing the green component of the original image
   */
  Image greenComponent(Image img);

  /**
   * Converts an RGB image to a grayscale image based on blue component.
   *
   * @param img the input RGB image to be converted
   * @return a new grayscale image representing the blue component of the original image
   */
  Image blueComponent(Image img);


}
