package net.honux.engine;

import java.awt.event.*;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

    private final int NUM_KEYS = 256;
    private final int NUM_BUTTONS = 8;

    private boolean[] keys = new boolean[NUM_KEYS];
    private boolean[] keysLast = new boolean[NUM_KEYS];

    private boolean[] buttons = new boolean[NUM_BUTTONS];
    private boolean[] buttonsLast = new boolean[NUM_BUTTONS];


    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    private int mouseX;
    private int mouseY;
    private int scroll;
    private double scale;


    /**
     * should create after window init
     * @param g GameApp
     */
    public Input(GameEngine g) {
        g.addEventListenner(this);
        scale = g.getScale();
    }

    public void update() {
        for(int i = 0; i < NUM_KEYS; i++) {
            keysLast[i] = keys[i];
        }

        for(int i = 0; i < NUM_BUTTONS; i++) {
            buttonsLast[i] = buttons[i];
        }
    }

    public boolean isKey(int keycode) {
        return keys[keycode];
    }

    public boolean isKeyUp(int keycode) {
        return keysLast[keycode] && !keys[keycode];
    }

    public boolean isKeyDown(int keycode) {
        return !keysLast[keycode] && keys[keycode];
    }

    public boolean isButton(int buttonCode) {
        return buttons[buttonCode];
    }


    public boolean isButtonUp(int buttonCode) {
        return buttonsLast[buttonCode] && !buttons[buttonCode];
    }


    public boolean isButtonDown(int buttonCode) {
        return !buttonsLast[buttonCode] && buttons[buttonCode];
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        buttons[e.getButton()] = true;

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        buttons[e.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        setMouseLocation(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        setMouseLocation(e.getX(), e.getY());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        scroll = e.getWheelRotation();
    }

    private void setMouseLocation(int x, int y) {
        mouseX = (int) (x / scale);
        mouseY = (int) (y / scale);
    }
}
