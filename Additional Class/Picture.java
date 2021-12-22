import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.awt.Color;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 * <p>
 * Copyright Georgia Institute of Technology 2004-2005
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments
     */
    public Picture() {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     *
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName) {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     *
     * @param width  the width of the desired picture
     * @param height the height of the desired picture
     */
    public Picture(int width, int height) {
        // let the parent class handle this width and height
        super(width, height);
    }

    /**
     * Constructor that takes a picture and creates a
     * copy of that picture
     */
    public Picture(Picture copyPicture) {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     *
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image) {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     *
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString() {
        String output = "Picture, filename " + getFileName() +
                " height " + getHeight()
                + " width " + getWidth();
        return output;

    }


    public static void main(String[] args) {
        String fileName = FileChooser.pickAFile();
        Picture pictObj = new Picture(fileName);
        pictObj.explore();
    }

    public void grayscale() {
        Pixel[] pixelArray = this.getPixels();
        Pixel pixel = null;
        int intensity = 0;

// loop through all the pixels//
        for (int i = 0; i < pixelArray.length; i++) {
// get the current pixel//

            pixel = pixelArray[i];

// compute the intensity of the pixel (average value)//
            intensity = (int) ((pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3);

// set the pixel color to the new color//
            pixel.setColor(new Color(intensity, intensity, intensity));
        }
    }

    public void negate() {
        Pixel[] pixelArray = this.getPixels();
        Pixel pixel = null;
        int redValue, blueValue, greenValue = 0;
// loop through all the pixels
        for (int i = 0; i < pixelArray.length; i++) {
// get the current pixel
            pixel = pixelArray[i];

// get the current red, green, and blue values
            redValue = pixel.getRed();
            greenValue = pixel.getGreen();
            blueValue = pixel.getBlue();
// set the pixel's color to the new color
            pixel.setColor(new Color(255 - redValue,
                    255 - greenValue,
                    255 - blueValue));
        }
    }


    public void edgeDetection(double amount) {
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        double topAverage = 0.0;
        double bottomAverage = 0.0;
        int endY = this.getHeight() - 1;
        /* loop through y values from 0 to height - 1
         * (since compare to below pixel) */
        for (int y = 0; y < endY; y++) {
// loop through the x values from 0 to width
            for (int x = 0; x < this.getWidth(); x++) {
// get the top and bottom pixels
                topPixel = this.getPixel(x, y);
                bottomPixel = this.getPixel(x, y + 1);
// get the color averages for the two pixels
                topAverage = topPixel.getAverage();
                bottomAverage = bottomPixel.getAverage();
                /* check if the absolute value of the difference
                 * is less than the amount */
                if (Math.abs(topAverage - bottomAverage) < amount) {
                    topPixel.setColor(Color.WHITE);
// else set the color to black
                } else {
                    topPixel.setColor(Color.BLACK);
                }
            }
        }
    }

}

// this } is the end of class Picture, put all new methods before this
 