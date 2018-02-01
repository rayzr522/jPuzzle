package me.rayzr522.jpuzzle;

import java.awt.*;

public class Player {

    private Image image;
    private int x, y;

    public Player() {
        image = Utils.loadImage("/sprite/char.png");

        reset();
    }

    public void reset() {
        this.x = 3;
        this.y = 2;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int dx, int dy) {

        x += dx;
        y += dy;

    }
}
