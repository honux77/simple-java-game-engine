package net.honux.engine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {

    private int w, h;
    private int[] buffer;

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public int[] getBuffer() {
        return buffer;
    }

    public int getPixel(int x, int y) {
        return buffer[x + y * w];
    }

    public Image(String path) {
        loadImage(path);
    }

    private void loadImage(String path) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            w = image.getWidth();
            h = image.getHeight();
            buffer = image.getRGB(0, 0, w, h, null, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
