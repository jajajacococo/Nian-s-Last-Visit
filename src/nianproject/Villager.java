// Imports Package and processing
package nianproject;
import processing.core.PApplet;

/**
 * The object for an NPC in the game.
 * Each villager can have a type and identity, and be drawn with different sprites.
 * @author Jacob Zheng
 */
public class Villager extends Props {
    // int idenity for the villager
    private String identity;

    // job or type of villager
    private String type;

    //offset for image adjustment
    private int offx;
    private int offy;

    /**
     * Constructs a villager object with a specific identity and default sprite.
     * @param app      the main Processing sketch used for rendering
     * @param x        the x-coordinate of the villager
     * @param y        the y-coordinate of the villager
     * @param identity the identity of the villager
     */
    public Villager(PApplet app, int x, int y, String identity) {
        super(app, x, y); // calls parent constructor
        this.identity = identity; // sets identity
        current = app.loadImage("imgs/oldman.png"); //default image 
    }

    /**
     * Constructs a villager object with a specific identity and default sprite.
     * @param app the main Processing sketch
     * @param x   the x-coordinate of the villager
     * @param y   the y-coordinate of the villager
     */
    public Villager(PApplet app, int x, int y) {
        super(app, x, y); // calls parent constructor
        this.identity = "vil2"; // sets identity
        current = app.loadImage("imgs/vil2.png"); //default image 
    }

    /**
      * Constructs a villager object with a specific identity and default sprite.
     * @param app      the main Processing sketch
     * @param x        the x-coordinate of the villager
     * @param y        the y-coordinate of the villager
     * @param type     the type of the villager
     * @param identity the identity of the villager
     */
    public Villager(PApplet app, int x, int y, String type, String identity) {
        super(app, x, y); // calls parent constructor
        this.identity = identity; // sets identity
        this.type = type; // sets type
        current = app.loadImage("imgs/vil1.png"); //default image 
    }

    /**
     * Draws a green hitbox around the villager for debugging.
     */
    /*public void drawHitbox() {
        app.noFill();
        app.stroke(0, 255, 0); // Green outline
        app.rect(x, y, width, height);
    }*/

    /**
     * Changes the villager's sprite and properties depending on the given index.
     * @param sprite the index of the desired sprite to use
     */
    @Override
    public void changeProp(int sprite) {
        switch (sprite) {
            case 0: // Old man sprite
                current = app.loadImage("imgs/oldman.png"); // cahnge image
                width = 32; // change properties
                height = 52;
                offx = -16;
                offy = -5;
                break;
            case 1: // Villager 1 sprite
                current = app.loadImage("imgs/vil1.png");
                width = 32;
                height = 52;
                offx = -16;
                offy = -5;
                break;
            case 2: // Villager 2 sprite
                current = app.loadImage("imgs/vil2.png");
                width = 32;
                height = 52;
                offx = -16;
                offy = -5;
                break;
            default:
                break;
        }
    }

    /**
     * Draws the villager to the screen. Adjusts image size based on identity.
     */
    @Override
    public void draw() {
        if (identity.equals("v1")) {
            // Draw larger for v1-type villagers
            app.image(current, x + offx, y + offy, 66, 70);
        } else {
            // Default size for others
            app.image(current, x + offx, y + offy, 64, 64);
        }
    }
}
