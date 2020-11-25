package net.honux.engine;

public abstract class Game {

    protected GameEngine engine;

    public Game(String title) {
        this.engine = new GameEngine(title);
        this.engine.setGame(this);
    }

    public abstract void update();
    public abstract void render();

    public void start() {
        engine.start();
    }
}
