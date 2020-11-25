package net.honux.engine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class GameWindow extends JFrame {

    private BufferedImage image;
    private Canvas canvas;
    private Dimension dimension;
    private Graphics graphics;

    public GameWindow(GameApp g) {
        super();
        initResource(g);
        initFrame(g);
    }

    public void render(int fps, long frame) {
        graphics.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), this);
        graphics.drawString(frame + " : " + fps, 20, 20);
        canvas.getBufferStrategy().show();
    }

    private void initResource(GameApp g) {
        dimension = g.getDimension();
        image = new BufferedImage(g.getWidth(), g.getHeight(), BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();
        canvas.setPreferredSize(dimension);
        canvas.setMaximumSize(dimension);
        canvas.setMinimumSize(dimension);
    }

    private void initFrame(GameApp g) {
        setTitle(g.getTitle());
        setPreferredSize(dimension);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        canvas.createBufferStrategy(2);
        graphics = canvas.getBufferStrategy().getDrawGraphics();
    }


}