package net.honux.engine;

public class GameApp implements Runnable{

    private Thread mainThread;
    private int frame = 0;
    private long update = 0L;

    private static final double GAP = 1.0 / 60;
    private boolean running;

    public GameApp() {
    }
    
    public void start() {
        mainThread = new Thread(this);
        mainThread.run();
    }

    public void render() {
        frame++;
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
                System.out.printf("fps: %d\n", frame);
                frame = 0;
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
        GameApp game = new GameApp();
        game.start();
    }
}
