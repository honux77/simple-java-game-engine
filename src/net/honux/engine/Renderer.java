package net.honux.engine;

import java.util.Random;

public class Renderer {

    private int pH;
    private int pW;
    private int[] buffer;

    public Renderer(GameApp g) {
        pH = g.getHeight();
        pW = g.getWidth();
        buffer = g.getWindowDataBuffer();
    }

    public void clear() {
        Random r = new Random();
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = r.nextInt();
        }
    }
}
