package net.honux.engine;

import java.awt.event.KeyEvent;

public class SampleGame extends Game{

    public SampleGame(String title, int w, int h, double scale) {
        super(title, w, h, scale);
    }

    @Override
    public void update() {
        if(getInput().isKeyDown(KeyEvent.VK_A)) System.out.printf("A down\n");
        if(getInput().isKey(KeyEvent.VK_A)) System.out.printf("A pressed\n");
        if(getInput().isKeyUp(KeyEvent.VK_A)) System.out.printf("A up\n");
    }

    @Override
    public void render() {

    }

    public static void main(String[] args) {
        Game game = new SampleGame("Sample Game", 320, 240, 2.0);
        GameEngine engine = new GameEngine(game);
        engine.start();
    }
}
