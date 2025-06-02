package nianproject;

import processing.core.PApplet;
import processing.core.PImage;

public class ScrollingBackground {
    private PImage bg;
    private PApplet app;
    private int offsetX, offsetY;

    public ScrollingBackground(PApplet app, String imagePath) {
        this.app = app;
        bg = app.loadImage(imagePath);
        offsetX = 205;
        offsetY = 300;
    }
public void update(int dx, int dy) {
    offsetX += dx;
    offsetY += dy;

    // Clamp scrolling to image size
    offsetX = Math.max(0, Math.min(offsetX, bg.width - app.width));
    offsetY = Math.max(0, Math.min(offsetY, bg.height - app.height));
}

public void draw() {
    app.image(bg, -offsetX, -offsetY);
}

    public int getOffsetX() {
        return offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }
}
