package net.honux.engine;

import java.awt.*;
import java.awt.image.DataBufferInt;

public class GameApp implements Runnable{

    private Thread mainThread;

    private Renderer renderer;

    private String title;
    private int width;
    private int height;
    private double scale;

    public GameWindow getWindow() {
        return window;
    }

    private long frame = 0;
    private long lastFrame = 0;

    private int fps = 0;
    private long update = 0L;

    private static final double GAP = 1.0 / 120;
    private boolean running;
    private GameWindow window;

    public GameApp(String title, int w, int h, double scale) {
        this.title = title;
        this.width = w;
        this.height = h;
        this.scale = scale;
    }

    public String getTitle() {
        return title;
    }

    public Dimension getDimension() {
        return new Dimension((int)(width * scale), (int)(height * scale));
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[] getWindowDataBuffer() {
        return window.getDataBufferInt();
    }

    public void start() {
        window = new GameWindow(this);
        renderer = new Renderer(this);
        mainThread = new Thread(this);
        mainThread.run();
    }

    public void render() {
        frame++;
        renderer.clear();
        window.render(fps, frame);
    }

    public void update() {
        update++;
    }

    public void run() {
        running = true;
        boolean render = false;
        final double OB = 1000_000_000.0f;
        double now;
        double lastTime = System.nanoTime() / OB;
        double passedTime;
        double frameTime = 0;
        double unprocessedTime = 0;


        while (running) {
            now = System.nanoTime() / OB;
            passedTime = now - lastTime;
            unprocessedTime += passedTime;
            frameTime += passedTime;
            lastTime = now;

            if (frameTime >= 1.0) {
                fps = (int) (frame - lastFrame);
                lastFrame = frame;
                frameTime = 0;
            }

            while (unprocessedTime > GAP) {
                unprocessedTime -= GAP;
                render = true;
                update();
            }

            if (render) {
                render = false;
                render();
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        GameApp game = new GameApp("Simple Game App", 320, 240, 2.0);
        game.start();
    }
}
