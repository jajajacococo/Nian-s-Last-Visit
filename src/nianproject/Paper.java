// Importing packages, processing, and java util
package nianproject;
import processing.core.PApplet;
import java.util.*;
import java.io.*;

/**
 * Is a child of item
 * a paper object that will give lore to the character 
 */
public class Paper extends Item {
    private Scanner read; // scanner object variable
    private String[] paper = new String[3]; // stores all text
    protected String text; // formats the text given from paper array and displays
    private int index = 0; // index counter for each index of the array

    /**
     * 
     * @param app Reference to the main PApplet application
     * @param x x pos of object
     * @param y y pos of object
     * @param index index of the object to select certain text
     */
    public Paper(PApplet app, int x, int y, int index) {
        super(app, x, y); // calls parent constructor then it calls it grandparent constructor
        current = app.loadImage("imgs/paper.png"); // load the image for the paper
        text = read(index).replace("\\n", "\n"); // sets text of the object to the return of the read method and replaces \n with the escape cahracter
        
        // default settings of the object
        offx = 7; 
        offy = 5;
        width = 25;
        height = 30;
    }
    
    /**
     * Draws a green rectangle around the hitbox for debugging and visualization.
     */
    /**public void drawHitbox() {
        app.noFill();
        app.stroke(0, 255, 0); // Green outline
        app.rect(x, y, width, height);
    }*/
    
    /**
     * Reads the text off of a flatfile and stores it into an array
     * @param ind which index to return
     * @return returns the index of the paper array text string
     */
    public String read(int ind) {
        try {
            read = new Scanner(new File("papers.txt")); // iniates the Scanner object
            
            // while the text file has a next line
            while (read.hasNext()) {
                paper[index] = read.nextLine();// read and set index of array to that flat file line text
                index++; // increase index
            }
        } catch (IOException e) { // catch if file non existent
            System.out.print("error");
        }
        return paper[ind]; // returns the paper and its index 
    }

    /**
     * Changes the prop/image and properties of the object
     * @param sprite the number sprite to change to
     */
    @Override
    public void changeProp(int sprite) {
        switch (sprite) {
            case 0: // if sprite is 0
                current = app.loadImage("imgs/paper.png"); // set current to new image
                
                // property changes
                offx = 0;
                offy = 0;
                width = 32;
                height = 20;
                break;
        }
    }

    /**
     * Draws the current sprite image at the adjusted position using offsets.
     */
    @Override
    public void draw() {
        app.image(current, x - offx, y - offy);// image is now in position of x,y and looks like it is aswell.
    }
}

