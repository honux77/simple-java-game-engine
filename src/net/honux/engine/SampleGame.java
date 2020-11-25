package net.honux.engine;

import java.awt.event.KeyEvent;

public class SampleGame extends Game{

    public SampleGame(String title) {
        super(title);
    }

    @Override
    public void update() {
        if(engine.getInput().isKeyDown(KeyEvent.VK_A)) System.out.printf("A down\n");
        if(engine.getInput().isKey(KeyEvent.VK_A)) System.out.printf("A pressed\n");
        if(engine.getInput().isKeyUp(KeyEvent.VK_A)) System.out.printf("A up\n");
    }

    @Override
    public void render() {

    }

    public static void main(String[] args) {
        Game game = new SampleGame("Sample Game");
        game.start();
    }
}
