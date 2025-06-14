// Importing packages and processing core stuff
package nianproject;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class object is for the character/player.
 * movement, collision, animation etc.
 */
public class Character {
    // Variables and stuff
    protected int x, y, oldx, oldy; // Character x and y and their old x and y
    private PApplet app;
    private String direction; // current direction of the character
    protected String lastdirection = "down"; // last direction of the character
    private int width, height; // width and height of the character for hitbox etc
    private int offsetx = 15, offsety = 5; // offset to properly align character with its x and y

    private PImage didle, widle, ridle, lidle; // images for idle character (left right up and down)
    private PImage current; // current image of the character
    private PImage[] downwalk, upwalk, rwalk, lwalk; // frame images for walking for up left right and down
    private int frame, frameside; 
    private int tick, tickside; // how often to switch frames... for up and down(tick) and (tickside) left and right

    public void drawHitbox() {
        app.noFill();
        app.stroke(0, 255, 0); // Green outline
        app.rect(x + offsetx, y + offsety, width, height);
    }

    public Character(PApplet app, int x, int y) {
        this.app = app;
        this.x = x;
        this.y = y;

        didle = app.loadImage("imgs/yDidle.png");
        this.width = 32;
        this.height = 52;

        downwalk = new PImage[] {
            app.loadImage("imgs/ydown.png"),
            app.loadImage("imgs/ydown2.png")
        };
        widle = app.loadImage("imgs/ywidle.png");

        upwalk = new PImage[] {
            app.loadImage("imgs/yup.png"),
            app.loadImage("imgs/yup2.png")
        };
        ridle = app.loadImage("imgs/yridle.png");

        rwalk = new PImage[] {
            app.loadImage("imgs/yright.png"),
            app.loadImage("imgs/yright2.png")
        };
        lidle = app.loadImage("imgs/ylidle.png");

        lwalk = new PImage[] {
            app.loadImage("imgs/yleft.png"),
            app.loadImage("imgs/yleft2.png")
        };

        frame = 0;
        frameside = 0;
        tick = 0;
        tickside = 0;
    }

    public void moveConstraint(boolean top) {
        if (!top) {
            x = PApplet.constrain(x, -35, app.width - 35);
            y = PApplet.constrain(y, -20, app.height - 160);
        } else {
            x = PApplet.constrain(x, -35, app.width - 35);
            y = PApplet.constrain(y, 180, app.height - 35);
        }
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;

        if (dy < 0) {
            direction = "up";
            lastdirection = direction;
        } else if (dy > 0) {
            direction = "down";
            lastdirection = direction;
        } else if (dx < 0) {
            direction = "left";
            lastdirection = direction;
        } else if (dx > 0) {
            direction = "right";
            lastdirection = direction;
        } else {
            direction = "idle";
            frame = 0;
            tick = 0;
        }
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        if (!direction.equals("idle")) {
            tick++;
            tickside++;

            if (tickside >= 10) {
                frameside = (frameside + 1) % 2;
                tickside = 0;
            }

            if (tick >= 15) {
                frame = (frame + 1) % 2;
                tick = 0;
            }

            switch (direction) {
                case "down":
                    current = downwalk[frame];
                    break;
                case "up":
                    current = upwalk[frame];
                    break;
                case "right":
                    current = rwalk[frameside];
                    break;
                case "left":
                    current = lwalk[frameside];
                    break;
            }
        } else {
            switch (lastdirection) {
                case "down":
                    current = didle;
                    break;
                case "up":
                    current = widle;
                    break;
                case "right":
                    current = ridle;
                    break;
                case "left":
                    current = lidle;
                    break;
            }
        }

        app.image(current, x, y, 64, 64);
    }

    public boolean isCollidingWith(Transition other) {
        boolean isLeftOfOtherRight = (x + offsetx) < other.x + other.width;
        boolean isRightOfOtherLeft = (x + offsetx) + width > other.x;
        boolean isAboveOtherBottom = (y + offsety) < other.y + other.height;
        boolean isBelowOtherTop = (y + offsety) + height > other.y;

        return isLeftOfOtherRight && isRightOfOtherLeft &&
               isAboveOtherBottom && isBelowOtherTop;
    }

    public boolean isCollidingWith(Props other) {
        boolean isLeftOfOtherRight = (x + offsetx) < other.x + other.width;
        boolean isRightOfOtherLeft = (x + offsetx) + width > other.x;
        boolean isAboveOtherBottom = (y + offsety) < other.y + other.height;
        boolean isBelowOtherTop = (y + offsety) + height > other.y;

        return isLeftOfOtherRight && isRightOfOtherLeft &&
               isAboveOtherBottom && isBelowOtherTop;
    }
}
