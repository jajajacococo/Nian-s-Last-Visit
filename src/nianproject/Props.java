// Importing packages and processing
package nianproject;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * is an object to represent props or any object that the character will interact with
 * @author Jacob Zheng
 */
public class Props {
    // position 
    protected int x,y;
    //size
    protected int width,height;
    //number of props
    private static int numofprops;
    
    // current images and PApplet stuff
    protected PImage current;
    protected PApplet app;  
   
    
    /**
     * Constructor for an Prop.
     * @param app Reference to the main PApplet application
     * @param x initial x pos
     * @param y initial y pos
     */
    public Props(PApplet app, int x, int y){
        this.app=app;
        this.x=x;
        this.y=y;
        numofprops++;
       
    }
    
    /**
     * changes position of the object
     * @param x new x
     * @param y new y
     */
    public void changePos(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    /**
     * changes the dimension of the object
     * @param w new width
     * @param h  new height
     */
    public void changeDimensions(int w, int h){
        this.width=w;
        this.height=h;
    }
  
   /**
     * Changes the visual appearance and hitbox of the item based on a sprite ID.
     * @param sprite The ID of the sprite to switch to
     */  
    public void changeProp(int sprite){
        System.out.println("Changed Prop to" + sprite);
    }
    /**
     * Draws the current sprite image at the adjusted position using offsets.
     */
    public void draw(){
        app.image(current,x,y);
    }
}

