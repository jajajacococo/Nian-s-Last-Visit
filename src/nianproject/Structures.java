
// Import the Processing library core classes for graphics and images and packages
package nianproject;
import processing.core.PApplet;

/**
 * The Structure class for building props.
 * @author Jacob Zheng
 */
public class Structures extends Props {
    // offsets to adjust drawing position
    protected int offx;
    protected int offy;

    /**
     * Constructor for structure object at the given position.
     * @param app the main Processing sketch object used for rendering
     * @param x   the x-coordinate position
     * @param y   the y-coordinate position 
     */
    public Structures(PApplet app, int x, int y) {
        // Call superclass constructor
        super(app, x, y);
        
        // Load default sprite (small house)
        current = app.loadImage("imgs/smolhouse.png");

        // properties
        offx = 15;
        offy = 30;
        width = 125;
        height = 81;
    }

    /**
     * Changes the sprite and its new properties based on a sprite index.
     * Each sprite represents a different structure type (e.g., storage, market).
     * @param sprite the index of the desired structure sprite
     */
    @Override
    public void changeProp(int sprite) {
        // Select the sprite based on the provided index
        switch (sprite) {
            case 0: // Small House
                current = app.loadImage("imgs/smolhouse.png");
                offx = 15;
                offy = 30;
                width = 125;
                height = 81;
                break;
            case 1: // Storage
                current = app.loadImage("imgs/storage.png");
                offx = 15;
                offy = 30;
                width = 85;
                height = 75;
                break;
            case 2: // Night Market
                current = app.loadImage("imgs/nightmarket.png");
                offx = 15;
                offy = 30;
                width = 60;
                height = 55;
                break;
            case 3: // Blacksmith
                current = app.loadImage("imgs/blacksmith.png");
                offx = 20;
                offy = 45;
                width = 120;
                height = 100;
                break;
            case 4: // Small Church
                current = app.loadImage("imgs/smolchurch.png");
                offx = 25;
                offy = 50;
                width = 95;
                height = 51;
                break;
            case 5: // Well
                current = app.loadImage("imgs/well.png");
                offx = 30;
                offy = 60;
                width = 40;
                height = 25;
                break;
            case 6: // Big House
                current = app.loadImage("imgs/bighouse.png");
                offx = 30;
                offy = 40;
                width = 150;
                height = 128;
                break;
            default:
                break;
        }
    }

    /**
     * Draws the structure image to the screen using its position and offset.
     */
    @Override
    public void draw() {
        app.image(current, x - offx, y - offy);
    }
}
