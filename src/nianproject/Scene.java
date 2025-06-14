// Importing packages and processing
package nianproject;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Is an object to represent the scenes/cutscenes
 * @author Jacob Zheng
 */
public class Scene {
    protected PImage current;
    protected PApplet app;

    /**
     * Constructor for Scene
     * @param app Reference to the main PApplet application
     */
    public Scene(PApplet app){
        this.app=app;
        current = app.loadImage("imgs/scene1.png");  
    }
    
    /**
     * Changes the object current image scene.
     * @param x the number to which image is set to which
     */
    public void changeScene(int x){
        switch(x){
            case 1: // if x == 1
                current = app.loadImage("imgs/scene1.png");   // change image
                break;
            case 2:
                current = app.loadImage("imgs/NianAwaken.png");
                break;
            case 3:
                current = app.loadImage("imgs/NianAttack.png");
                break;
            case 4:
                current = app.loadImage("imgs/Win.png");
                break;
            case 5:
                current = app.loadImage("imgs/lose.png");
                break;
                            case 6:
                current = app.loadImage("imgs/attack.png");
                break;
                                        case 7:
                current = app.loadImage("imgs/scared.png");
                break;
                                                        case 8:
                current = app.loadImage("imgs/hiding.png");
                break;
                
        }
    }
      /**
     * Draws the current scene.
     */
    public void draw(){
        app.image(current,0,0,600,499);
    }
    
}
