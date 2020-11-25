package net.honux.engine;

public abstract class Game {

    public Input getInput() {
        return input;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    private Input input;
    private Renderer renderer;

    public void connect(Input input, Renderer renderer) {
        this.input = input;
        this.renderer = renderer;
    }

    protected String title;
    protected int w;
    protected int h;
    protected double scale;

    public Game(String title, int w, int h, double scale) {
        this.title = title;
        this.w = w;
        this.h = h;
        this.scale = scale;
    }

    public abstract void update();

    public abstract void render();
}
