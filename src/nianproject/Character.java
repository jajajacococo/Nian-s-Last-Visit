// Importing packages and processing core stuff
package nianproject;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class object is for the character/player.
 * Handles movement, collision, animation, etc.
 */
public class Character {
    // Position variables
    protected int x, y, oldx, oldy; // Character x and y and their old x and y
    private int offsetx = 15, offsety = 5; // offset to properly align character with its x and y
    
    // Size
    private int width, height; // width and height of the character for hitbox etc
    
    // Direction and animation variables
    private String direction; // current direction of the character
    protected String lastdirection = "down"; // last direction of the character
    private int frame, frameside; 
    private int tick, tickside; // how often to switch frames... for up and down(tick) and (tickside) left and right

    //Proccessing and image variables
    private PApplet app;
    private PImage didle, widle, ridle, lidle; // images for idle character (left right up and down)
    private PImage current; // current image of the character
    private PImage[] downwalk, upwalk, rwalk, lwalk; // frame images for walking for up left right and down
   
    /**
     * Instantiates a new Character Object at a specified position, animation frame, size. It also loads all the animation images.
     * @param app the PApplet context used for drawing and loading images
     * @param x initial x pos of character
     * @param y initial y pos of character
     */
    public Character(PApplet app, int x, int y) {
        //setting variables
        this.app = app;
        this.x = x;
        this.y = y;
        
        //setting size
        this.width = 32;
        this.height = 52;
        
        //loading all images to respective variables 
        didle = app.loadImage("imgs/yDidle.png");
        downwalk = new PImage[] {app.loadImage("imgs/ydown.png"), app.loadImage("imgs/ydown2.png")};
        widle = app.loadImage("imgs/ywidle.png");
        upwalk = new PImage[] {app.loadImage("imgs/yup.png"),app.loadImage("imgs/yup2.png")};
        ridle = app.loadImage("imgs/yridle.png");
        rwalk = new PImage[] {app.loadImage("imgs/yright.png"),app.loadImage("imgs/yright2.png")};
        lidle = app.loadImage("imgs/ylidle.png");
        lwalk = new PImage[] {app.loadImage("imgs/yleft.png"),app.loadImage("imgs/yleft2.png")};
        
        // Resetting/ Declaring variables
        frame = 0;
        frameside = 0;
        tick = 0;
        tickside = 0;
    }
     
    /**
     * Draws a green rectangle around the hitbox for debugging and visualization.
     */
    /*public void drawHitbox() {
        app.noFill();
        app.stroke(0, 255, 0); // Green outline
        app.rect(x + offsetx, y + offsety, width, height);
    }*/
    
    /**
     * Prevents the character from moving out of a certain area
     * @param top checks if the map is top or bottom
     */
    public void moveConstraint(boolean top) {
        // position of character, minimum, maximum
        if (!top) { // if the map is on the bottom there is a bottom constraint
            x = PApplet.constrain(x, -35, app.width - 35);
            y = PApplet.constrain(y, -20, app.height - 160);
        } else { // if the map is on the top there is a top constraint
            x = PApplet.constrain(x, -35, app.width - 35);
            y = PApplet.constrain(y, 180, app.height - 35); 
        }
    }

    /**
     * Handles the moving of the character and direction setting
     * @param dx
     * @param dy 
     */
    public void move(int dx, int dy) {
        x += dx; // increases or dec x pos by dx
        y += dy; // increases or dec y pos by dy

        // Checks if dy goes up or down, if dx goes right or left to set the direction
        if (dy < 0) { //dy is decreaseing so going up
            direction = "up"; // set direction to up
            lastdirection = direction; //set last direction to up
        } else if (dy > 0) {
            direction = "down";
            lastdirection = direction;
        } else if (dx < 0) {
            direction = "left";
            lastdirection = direction;
        } else if (dx > 0) {
            direction = "right";
            lastdirection = direction;
        } else { // else set direction to idle position and reset animation variables
            direction = "idle";
            frame = 0;
            tick = 0;
        }
    }

    /**
     * Sets a new current position of the character 
     * @param x new x position
     * @param y new y position
     */
    public void setPos(int x, int y) {
        this.x = x; // new x pos
        this.y = y; // new y pos
    }

    /**
     * Handles the animations and drawing of the character.
     */
    public void draw() {
        if (!direction.equals("idle")) { // checks if direction is NOT idle
            tick++; // increase up and down counter
            tickside++; // increase right and left counter

            // left and right frame animation settings
            if (tickside >= 10) { // when clock counter hits ten
                frameside = (frameside + 1) % 2; // even odd clock giving 0 when even and 1 when odd
                // works because I only ahve two frames and their index are 0 and 1
                tickside = 0; // reset counter
            }
            
            //up and down frame animation setting
            if (tick >= 15) { // when clock counter hits 15
                frame = (frame + 1) % 2; // even odd clock giving 0 when even and 1 when odd
                tick = 0;// reset counter
            }
            
            // checks the direction of the character
            switch (direction) {
                case "down": // if direction is down
                    current = downwalk[frame]; // set the current image to the downwalk image and its certain frame
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
        } else { // else image is idle, checks what last direction is and sets idle image to the certain direction 
            switch (lastdirection) {
                case "down": // if last known direction is down
                    current = didle; // set the current image to the down idle image
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
        // draws the current character image, position and size.
        app.image(current, x, y, 64, 64);
    }
    /**
     * Checks if the character is colliding with the transition object/ map transition box
     * @param other the object it is colliding with
     * @return returns a true or false
     */
    public boolean isCollidingWith(Transition other) {
        // checks if character leftside is to the left of the rightside of the other 
        boolean isLeftOfOtherRight = (x + offsetx) < other.x + other.width;
        // checks if character rightside is to the right of the leftside of the other 
        boolean isRightOfOtherLeft = (x + offsetx) + width > other.x;
        // checks if character top is above the objects bottom
        boolean isAboveOtherBottom = (y + offsety) < other.y + other.height;
         // checks if character bottom is below the objects top
        boolean isBelowOtherTop = (y + offsety) + height > other.y;
        //
        return isLeftOfOtherRight && isRightOfOtherLeft && isAboveOtherBottom && isBelowOtherTop;
    }
    
    /**
     * Checks if the character is colliding with a prop object
     * @param other the object it is colliding with
     * @return returns a true or false
     */
    public boolean isCollidingWith(Props other) {
        boolean isLeftOfOtherRight = (x + offsetx) < other.x + other.width;
        boolean isRightOfOtherLeft = (x + offsetx) + width > other.x;
        boolean isAboveOtherBottom = (y + offsety) < other.y + other.height;
        boolean isBelowOtherTop = (y + offsety) + height > other.y;
        return isLeftOfOtherRight && isRightOfOtherLeft &&isAboveOtherBottom && isBelowOtherTop;
    }
}
