package nianproject;

import processing.core.PApplet;
import processing.core.PFont;

public class Sketching extends PApplet {
    private Character you;
    private Scene slide;
    private boolean wHold = false, sHold = false, aHold = false, dHold = false;
    private int scene = 0, dx = 0, dy = 0;
    private final int SPEED = 1;
    private PFont font;
    private int opactimer = 255, wait = 0, time = 0;
    private boolean fadein = true, waiter = false;

    private String text = "February 3, 1045 BCE,";
    private String displayText = "";
    private int charCount = 0, typeSpeed = 5, typeFrameCount = 0;

    @Override
    public void settings() {
        size(600, 500);
    }

    @Override
    public void setup() {
        you = new Character(this, 268, 202);
        slide = new Scene(this);
        background(255);
        font = createFont("Pixel.otf", 32);
        textFont(font);
    }

    @Override
    public void draw() {
        if (scene == 0) {
            background(255);
            slide.changeScene(1);
            slide.draw();
            fadeinout(200, 2);
            if (!fadein && opactimer >= 255) {
                scene = 1;
                fadein = true;
                opactimer = 255;
                wait = 0;
            }
        } else if (scene == 1) {
            if (charCount < text.length()) {
                typeFrameCount++;
                if (typeFrameCount % typeSpeed == 0) {
                    displayText += text.charAt(charCount);
                    charCount++;
                }
                if (charCount >= text.length()) text("11:30pm", 200, 300);
            }
            fill(255);
            text(displayText, 50, 225);
            waiter = wait(350);
            if (waiter) {
                waiter = false;
                scene = 2;
            }
        } else if (scene == 2) {
            slide.changeScene(2);
            slide.draw();
            fadeinout(80, 5);
            waiter = wait(100);
            if (!fadein && opactimer >= 255 && waiter) {
                waiter = false;
                scene = 5;
                fadein = true;
                opactimer = 255;
                wait = 0;
            }
        } else if (scene == 5) {
            background(255);
            if (wHold) dy = -SPEED;
            else if (sHold) dy = SPEED;
            else if (aHold) dx = -SPEED;
            else if (dHold) dx = SPEED;
            you.move(dx, dy);
            you.draw();
        }
    }

    public void fadeinout(int waitTime, int add) {
        if (fadein) {
            if (opactimer > 0) opactimer -= add;
            if (opactimer <= 0) fadein = false;
        }
        if (!fadein) {
            if (wait < waitTime) wait++;
            if (wait >= waitTime && opactimer < 255) opactimer += add;
        }
        fill(0, 0, 0, opactimer);
        rect(-1, -1, 601, 501);
    }

    public boolean wait(int waittime) {
        if (time < waittime) {
            time++;
            return false;
        } else {
            time = 0;
            return true;
        }
    }

    public void keyPressed() {
        if (key == 'w') wHold = true;
        if (key == 's') sHold = true;
        if (key == 'a') aHold = true;
        if (key == 'd') dHold = true;
    }

    public void keyReleased() {
        if (key == 'w') wHold = false;
        if (key == 's') sHold = false;
        if (key == 'a') aHold = false;
        if (key == 'd') dHold = false;
    }
}
