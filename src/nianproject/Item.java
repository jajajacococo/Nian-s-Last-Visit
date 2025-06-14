// Importing packages
package nianproject;
import processing.core.PApplet;

/**
 * Is an object to represent items for the game(cloth,lantern,candle).
 * inherits properties from Props to manage position, collision etc.
 */
public class Item extends Props {

    // Offsets for drawing the image relative to the x, y coordinates
    protected int offx, offy;
    // THE PICTURE IS NOT CENTERED SO THE OFFSET MOVES IT BUT THE X AND Y ARE STILL THE SAME
    // THIS FIXES SO THAT THE COLLISION ALIGN WITH THE IMAGE

    /**
     * Constructor for an Item.
     * @param app Reference to the main PApplet application
     * @param x X-coordinate
     * @param y Y-coordinate
     */
    public Item(PApplet app, int x, int y) {
        super(app, x, y); // calls parent constructor
        current = app.loadImage("imgs/rcloth2.png");        // Load the default image for the item
    }

    /**
     * Draws a green rectangle around the hitbox for debugging and visualization.
     */
    /**public void drawHitbox() {
        app.noFill(); // empty
        app.stroke(0, 255, 0); // Green outline
        app.rect(x, y, width, height); // drawing rectangle and position and size
    } */

    /**
     * Changes the visual appearance and hitbox of the item based on a sprite ID.
     * @param sprite The ID of the sprite to switch to
     */
    @Override
    public void changeProp(int sprite) {
        switch (sprite) {
            case 0: // Cloth
                current = app.loadImage("imgs/rcloth2.png"); // sets current image to display to the iamge of cloth
                offx = 3; // x offset to align collision
                offy = 10; // y offset to align collision
                width = 32; // width of the hitbox
                height = 20; // height of the hitbox
                break;

            case 1: // Lantern
                current = app.loadImage("imgs/rlantern.png");
                offx = 10;
                offy = 5;
                width = 32;
                height = 30;
                break;

            case 2: // red shirt and pants
                current = app.loadImage("imgs/rsuit.png");
                offx = 12;
                offy = 5;
                width = 35;
                height = 50;
                break;

            case 3: // Candle
                current = app.loadImage("imgs/candle.png");
                offx = 15;
                offy = 15;
                width = 19;
                height = 29;
                break;

            case 4: // Candle Variant
                current = app.loadImage("imgs/candle2.png");
                offx = 15;
                offy = 15;
                width = 18;
                height = 29;
                break;

            case 5: // Firecracker
                current = app.loadImage("imgs/fcracker.png");
                offx = 5;
                offy = 5;
                width = 40;
                height = 40;
                break;
        }
    }

    /**
     * Draws the current sprite image at the adjusted position using offsets.
     */
    @Override
    public void draw() {
        app.image(current, x - offx, y - offy); // image is now in position of x,y and looks like it is aswell.
    }
}
