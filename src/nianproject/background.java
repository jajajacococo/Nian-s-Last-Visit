//importing packages 
package nianproject;
import processing.core.PApplet;

/**
 * Background object for map background
 * @author Jacob Zheng
 */
public class background extends Scene {
    
    /**
     * constructor for background object
     * @param app Reference to the main PApplet application
     */
    public background(PApplet app){
        super(app); //calls parent constructor
        current = app.loadImage("imgs/mapfinal2.png"); // default set to map 2
    }
    
    /**
     * changes the map image based on parameter
     * @param x num to change to which map num
     */
    @Override
    public void changeScene(int x){
                switch (x) {
            case 1: //if x == 1
                current = app.loadImage("imgs/mapfinal1.png"); // change map to amp 1
                break;
            case 2:
                current = app.loadImage("imgs/mapfinal2.png");
                break;
            case 3:
                current = app.loadImage("imgs/mapfinal3.png");
                break;
            case 4:
                current = app.loadImage("imgs/mapfinal4.png");
                break;
        }
    }
    
}
