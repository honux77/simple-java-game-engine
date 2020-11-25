package net.honux.engine;

import java.util.Random;

public class Renderer {

    private int pH;
    private int pW;
    private int[] buffer;

    public Renderer(GameEngine g) {
        pH = g.getHeight();
        pW = g.getWidth();
        buffer = g.getWindowDataBuffer();
    }

    private void setPixel(int x, int y, int color, int alpha) {
        if (x < 0 || x >= pW || y < 0 || y >= pH || color == alpha) return;
        buffer[x + y * pW] = color;
    }

    public void renderImage(Image image, int sx, int sy, int alpha) {
        if (alpha == -1) {
            alpha = image.getPixel(0, 0);
            //System.out.printf("alpha: %x", alpha);
        }
        for (int y = 0; y < image.getH(); y++) {
            for (int x = 0; x < image.getW(); x++) {
                setPixel(sx + x, sy + y, image.getPixel(x, y), alpha);
            }
        }
    }

    public void clear(int color) {
        Random r = new Random();
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = r.nextInt() % 2 == 0 ? 0xFFFFFFFF : 0xFFAAAAAA;
        }
    }
}
