package me.rayzr522.jpuzzle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Please note, this was not actually one of the original files for the game. I simply added this because my original
 * method of image-loading was hopelessly broken, so this was a quick solution. This file was added February 1st, 2018.
 */
public class Utils {
    public static Image loadImage(String path) {
        try {
            return ImageIO.read(Utils.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
