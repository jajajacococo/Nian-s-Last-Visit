// Imports and packages


// WRONG BACKGROUND PICTURE FOR RIGHT UP IT SHOUDL BE INVESRED NO?
// WORK ON THE TRANISTION BOXES ALMOST DONE



package nianproject;
import processing.core.PApplet;
import processing.core.PFont;

public class Sketching extends PApplet {
    // Objects
    private Character you;      // character
    private Scene slide;        // scene backgrounds etc
    private Scene bg;
    private PFont font;         // text font
    private Transition[] box;

    // Key press and release detectors
    private boolean wHold = false, sHold = false, aHold = false, dHold = false;

    // Scene/Stage counter
    private int scene = 5;

    // Character movement variables
    private int dx = 0, dy = 0;
    private final int SPEED = 5; //2

    // Fade in and fade out timers and debounces
    private int opac = 255,  // opacity
                wait = 0,   // wait counter
                time = 0;   // time counter
    private boolean fadein = true,  // to allow fade in or out
                    waiter = false; // to allow / activate then next scene like a delay

    // Typing animation variables
    private String text = "February 3, 1045 BCE,"; // original text
    private String displayText = "";                // displayed text
    private int charCount = 0,                      // character index of the text
                typeSpeed = 5,                      // speed to print out letters
                typeFrameCount = 0;                 // frame counter

    // Multiple typing animations
    private String[] textString = {
        "Objective:",
        "Gather all supplies to",
        "escape before midnight."
    }; // original texts
    private boolean[] debounceLine = new boolean[3];
    private int[] charrayCount = {0, 0, 0};       // character index of the texts
    private int[] tarraypeFrameCount = {0, 0, 0}; // frame counters
    private String[] displayTexts = {"", "", ""}; // displayed texts

    /**
     * Sets the size of the display window.
     */
    @Override
    public void settings() {
        size(600, 500);
    }

    /**
     * Initializes game components like the player character and background scene.
     * Also loads the custom pixel font for rendering text.
     */
    @Override
    public void setup() {
        you = new Character(this, 270, 50);
        slide = new Scene(this);
        background(255);
        font = createFont("Pixel.otf", 32);
        textFont(font);
        bg = new background(this);
        box = new Transition[5];
        box[0] = new Transition(this, 595, 270, 15, 50);
        box[1] = new Transition(this, 420, -6, 40, 10);
        box[2] = new Transition(this, 595, 330, 15, 50);
        box[3] = new Transition(this, 130, 495, 50, 10);
        box[4] = new Transition(this, 420, 495, 50, 10);
    }

    /**
     * The main draw loop for the game. (Called continuously)
     * Handles scenes, activating fade transitions, typing animations, character movement.
     */
    @Override
    public void draw() {
        if (scene == 0) {
            background(255);
            slide.changeScene(1);
            slide.draw();
            fadeinout(200, 2); // 200,2
            if (!fadein && opac >= 255) {
                scene = 1;
                fadein = true;
                opac = 255;
                wait = 0;
            }

        } else if (scene == 1) {
            if (charCount < text.length()) {
                typeFrameCount++;
                if (typeFrameCount % typeSpeed == 0) {
                    displayText += text.charAt(charCount);
                    charCount++;
                }
                if (charCount >= text.length())
                    text("11:30pm", 220, 300);
            }
            fill(255);
            text(displayText, 60, 225);
            waiter = wait(350); // 350
            if (waiter) {
                waiter = false;
                scene = 2;
            }

        } else if (scene == 2) {
            slide.changeScene(2);
            slide.draw();
            fadeinout(80, 5); // 80,5
            waiter = wait(100); // 100
            if (!fadein && opac >= 255 && waiter) {
                waiter = false;
                scene = 3;
                fadein = true;
                opac = 255;
                wait = 0;
            }

        } else if (scene == 3) {
            slide.changeScene(3);
            slide.draw();
            fadeinout(80, 5); // 80,5
            waiter = wait(100); // 100
            scene = 4;

        } else if (scene == 4) {
            for (int i = 0; i < textString.length; i++) {
                if (charrayCount[i] < textString[i].length()) {
                    tarraypeFrameCount[i]++;
                    if (tarraypeFrameCount[i] % typeSpeed == 0) {
                        displayTexts[i] += textString[i].charAt(charrayCount[i]);
                        charrayCount[i]++;
                    }
                }
                fill(255);
                if (i == 0) {
                    text(displayTexts[i], 200, 215 + (40 * i));
                } else {
                    text(displayTexts[i], 30, 215 + (40 * i));
                }
            }
            waiter = wait(350); // 350
            if (waiter) {
                waiter = false;
                scene = 5;
            }

        } else if (scene == 5) {
            bg.changeScene(2);
            bg.draw();
            dx = 0;
            dy = 0;

            if (wHold) dy -= SPEED;
            else if (sHold) dy += SPEED;
            else if (aHold) dx -= SPEED;
            else if (dHold) dx += SPEED;

            box[1].changeBox(420, -6, 40, 10);
            box[0].changeBox(595, 270, 15, 50);
            box[0].draw();
            box[1].draw();

            you.move(dx, dy);
            you.moveConstraint(dx, dy, false);
            you.draw();
            you.drawHitbox();

            leftbotToRightbot();
            leftbotToLeftup();

        } else if (scene == 6) {
            bg.changeScene(4);
            bg.draw();
            dx = 0;
            dy = 0;

            box[3].changeBox(130, 0, 50, 10);
            box[0].changeBox(-10, 270, 15, 50);
            box[4].changeBox(420, 0, 50, 10);

            box[0].draw();
            box[3].draw();
            box[4].draw();

            if (wHold) dy -= SPEED;
            else if (sHold) dy += SPEED;
            else if (aHold) dx -= SPEED;
            else if (dHold) dx += SPEED;

            you.move(dx, dy);
            you.moveConstraint(dx, dy, false);
            you.draw();
            you.drawHitbox();

            leftbotToRightbot();
            rightuptToRightbot();

        } else if (scene == 7) {
            bg.changeScene(1);
            bg.draw();
            dx = 0;
            dy = 0;

            box[1].changeBox(420, 494, 40, 10);
            box[2].changeBox(595, 330, 15, 50);

            box[1].draw();
            box[2].draw();

            if (wHold) dy -= SPEED;
            else if (sHold) dy += SPEED;
            else if (aHold) dx -= SPEED;
            else if (dHold) dx += SPEED;

            you.move(dx, dy);
            you.moveConstraint(dx, dy, true);
            you.draw();
            you.drawHitbox();

            leftbotToLeftup();
            leftuptToRightup();

        } else if (scene == 8) {
            bg.changeScene(3);
            bg.draw();
            dx = 0;
            dy = 0;

            box[3].changeBox(130, 495, 50, 10);
            box[2].changeBox(-11, 315, 15, 40);
            box[4].changeBox(420, 495, 50, 10);

            box[2].draw();
            box[3].draw();
            box[4].draw();

            if (wHold) dy -= SPEED;
            else if (sHold) dy += SPEED;
            else if (aHold) dx -= SPEED;
            else if (dHold) dx += SPEED;

            you.move(dx, dy);
            you.moveConstraint(dx, dy, true);
            you.draw();
            you.drawHitbox();

            leftuptToRightup();
            rightuptToRightbot();
        }
    }

    public void rightuptToRightbot() {
        if (you.isCollidingWith(box[3]) && scene == 8) {
            System.out.println("TOUCHED lu to ru");
            scene = 6;
            box[3].changeBox(130, 0, 15, 40);
            you.setPos(-4, 305);
        } else if (you.isCollidingWith(box[3]) && scene == 6) {
            System.out.println("TOUCHED lu to ru");
            scene = 8;
            box[3].changeBox(130, 0, 15, 40);
            you.setPos(-4, 305);
        }

        if (you.isCollidingWith(box[4]) && scene == 8) {
            System.out.println("TOUCHED lu to ru");
            scene = 6;
            box[4].changeBox(420, 495, 50, 10);
            you.setPos(-4, 305);
        } else if (you.isCollidingWith(box[4]) && scene == 6) {
            System.out.println("TOUCHED lu to ru");
            scene = 8;
            box[4].changeBox(420, 0, 50, 10);
            you.setPos(-4, 305);
        }
    }

    public void leftuptToRightup() {
        if (you.isCollidingWith(box[2]) && scene == 7) {
            System.out.println("TOUCHED lu to ru");
            scene = 8;
            box[2].changeBox(-11, 315, 15, 40);
            you.setPos(-4, 305);
        } else if (you.isCollidingWith(box[2]) && scene == 8) {
            System.out.println("TOUCHED ru to lu");
            scene = 7;
            box[2].changeBox(595, 330, 15, 50);
            you.setPos(550, 320);
        }
    }

    public void leftbotToRightbot() {
        if (you.isCollidingWith(box[0]) && scene == 5) {
            System.out.println("TOUCHED lb to rb");
            scene = 6;
            box[0].changeBox(-10, 270, 15, 50);
            you.setPos(-5, 265);
        } else if (you.isCollidingWith(box[0]) && scene == 6) {
            System.out.println("TOUCHED rb to lb");
            scene = 5;
            box[0].changeBox(595, 270, 15, 50);
            you.setPos(547, 265);
        }
    }

    public void leftbotToLeftup() {
        if (you.isCollidingWith(box[1]) && scene == 5) {
            System.out.println("TOUCHED lb to lu");
            scene = 7;
            box[1].changeBox(420, 494, 40, 10);
            you.setPos(410, 430);
        } else if (you.isCollidingWith(box[1]) && scene == 7) {
            System.out.println("TOUCHED lu to lb");
            scene = 5;
            box[1].changeBox(420, -6, 40, 10);
            you.setPos(410, 5);
        }
    }

    /**
     * Handles fade-in and fade-out effects.
     * @param waitTime time to wait during fade out
     * @param add fade increment/decrement amount
     */
    public void fadeinout(int waitTime, int add) {
        if (fadein) {
            if (opac > 0) opac -= add;
            if (opac <= 0) fadein = false;
        }
        if (!fadein) {
            if (wait < waitTime) wait++;
            if (wait >= waitTime && opac < 255) opac += add;
        }
        fill(0, 0, 0, opac);
        rect(-1, -1, 601, 501);
    }

    /**
     * Wait function acting as a timer.
     * @param waittime number of frames to wait
     * @return true if wait time is elapsed, false otherwise
     */
    public boolean wait(int waittime) {
        if (time < waittime) {
            time++;
            return false;
        } else {
            time = 0;
            return true;
        }
    }

    /**
     * Sets key hold flags on key press.
     */
    public void keyPressed() {
        if (key == 'w') wHold = true;
        if (key == 's') sHold = true;
        if (key == 'a') aHold = true;
        if (key == 'd') dHold = true;
    }

    /**
     * Unsets key hold flags on key release.
     */
    public void keyReleased() {
        if (key == 'w') wHold = false;
        if (key == 's') sHold = false;
        if (key == 'a') aHold = false;
        if (key == 'd') dHold = false;
    }
}
