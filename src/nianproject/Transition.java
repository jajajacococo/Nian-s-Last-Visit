// Imports and packages
package nianproject;
import processing.core.PApplet;

/**
 * Transition object to allow the character to explore other parts of the map
 */
public class Transition {
    // coordinates of the transition box
    protected int x;
    protected int y;

    // dimenstions of the box
    protected int width;
    protected int height;

    /** Reference to the Processing app used for drawing. */
    private PApplet app;

    /**
     * Constructor for the transition object with a position and size.
     * @param app    the Processing sketch used for rendering
     * @param x      the x-coordinate of the transition box
     * @param y      the y-coordinate of the transition box
     * @param width  the width of the box
     * @param height the height of the box
     */
    public Transition(PApplet app, int x, int y, int width, int height) {
        this.app = app;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

     /**
     * Updates the position and size of the transition box.
     * @param x      new x-coordinate
     * @param y      new y-coordinate
     * @param width  new width
     * @param height new height
     */
    public void changeBox(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * draws the transition box to the screen.
     */
    public void draw() {
        app.noFill();                    // Don't fill the rectangle
        app.stroke(255, 255, 0);         // Yellow outline
        app.strokeWeight(2);             // Thicker stroke for visibility
        app.rect(x, y, width, height);   // Draw rectangle at current position and size
    }
}