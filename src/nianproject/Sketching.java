// Imports and packages
  /**
     * ⬚ 15. Use of file input for retrieving data from a flat-file (database) (DIALOGUE FROM GRAMPS??
     * ⬚ 16. Use of file output for adding/modifying data to a flat-file (database) USER IDK TAKS COMPLELTE
     */

// WRONG BACKGROUND PICTURE FOR RIGHT UP IT SHOUDL BE INVESRED NO?
// WORK ON THE TRANISTION BOXES ALMOST DONE


// Imports and packages
package nianproject;
import processing.core.PApplet;
import processing.core.PFont;

public class Sketching extends PApplet {
    // Objects declarations
    private Character you;      // Player character
    private Scene slide;        // Scene handler for slide images
    private Scene bg;           // Background scene object
    private PFont font;         // Custom pixel font for text rendering
    private Transition[] box;   // Array to hold transition boxes for scene change

    // Variable to track key press states
    private boolean wHold = false, sHold = false, aHold = false, dHold = false;

    // Variable counter to track current scenes
    private int scene = 5;

    // Variables for character movement
    private int dx = 0, dy = 0;          // Movement distance on x and y
    private final int SPEED = 5;         // Movement speed(2)

    // Variables to handle fade-in and fade-out transitions
    private int opac = 255,  // Opacity for the fade effect
                wait = 0,   // Counter for wait time
                time = 0;   // Time delay counter
    private boolean fadein = true,  // To control fade-in effect
                    waiter = false; // To control the delay and trigger the next scene

    // Variables for typing animation for single line
    private String text = "February 3, 1045 BCE,"; // Text to display
    private String displayText = "";                // Currently displayed lines
    private int charCount = 0,                      // Index of text to display
                typeSpeed = 5,                      // Delay between character display
                typeFrameCount = 0;                 // Frame counter for counting

    // Variables for typing animation for mutliple lines
    private String[] textString = { // Text to display
        "Objective:",
        "Gather all supplies to",
        "escape before midnight."
    }; 
    private int[] charrayCount = {0, 0, 0};       // Array of index of text to display
    private int[] tarraypeFrameCount = {0, 0, 0}; // Array of frame counter for counting
    private String[] displayTexts = {"", "", ""}; // Array of currently displayed lines

    /**Sets the size of the display window.*/
    @Override
    public void settings() {
        size(600, 500);
    }

    /** Initializes/instantiating objects and resources for the game.*/
    @Override
    public void setup() {
        background(255); // Setting background to white
        
        // Instaniating the Objects
        you = new Character(this, 270, 50); // The player character
        slide = new Scene(this); // The slideshow images
        bg = new background(this); // The background images
        box = new Transition[5]; // Declaring the size of the box object array
        
        // Instaniating the transition boxes for scene change.
        box[0] = new Transition(this, 595, 270, 15, 50);
        box[1] = new Transition(this, 420, -6, 40, 10);
        box[2] = new Transition(this, 595, 330, 15, 50);
        box[3] = new Transition(this, 130, 495, 50, 10);
        box[4] = new Transition(this, 420, 495, 50, 10);
        
        // Load pixel Font for tpying animations.
        font = createFont("Pixel.otf", 32); // pixel font file and size 32
        textFont(font); 
    }

    /**
     * The main draw loop for the game. (Called continuously)
     * Handles scenes, activating fade transitions, typing animations, character movement.
     * Everything basically.
     */
    @Override
    public void draw() {
        
        // Scene 0: Cutscene-ish/Information slide/Setting slide.
        if (scene == 0) {
            background(255);// Setting background to white
            
            slide.changeScene(1); // Changing the slide object to slide 1
            slide.draw(); // Drawing the slide
            fadeinout(200, 2); // Calling the fade transition method
            
            // Reset variables and change scene. 
            // On cond of fadein=false, opac is 255 or larger.
            if (!fadein && opac >= 255) { 
                scene = 1;
                fadein = true; 
                opac = 255; 
                wait = 0; 
            } 
        }
        
        // Scene 1: Single line typing animation for date/setting
        else if (scene == 1) {
            
            // Checks if there are still characters to print
            if (charCount < text.length()) { 
                typeFrameCount++; // Frame counter time increases by 1.
                
                // If frame counter modulus by typeSpeed(5) = 0 -> start printing
                if (typeFrameCount % typeSpeed == 0) { 
                    displayText += text.charAt(charCount); // Starting slowly adding each character to displayed variable.
                    charCount++; // increase the character index
                }
                // after the text is printed:
                if (charCount >= text.length()) 
                    text("11:30pm", 220, 300); // print a different text
            }
            
            fill(255); // Text colour to white
            text(displayText, 60, 225); // Display the displayed text.
            waiter = wait(350); // Storing a boolean from the wait method(Delay method)
            
            // Reset variables and change scene.
            if (waiter) {
                waiter = false;
                scene = 2;
            }
        } 
        
        // Scene 2: Image of Nian awakening.
        else if (scene == 2) {
            
            // Slide change, draw, fade-in-out transition.
            slide.changeScene(2); 
            slide.draw(); 
            fadeinout(80, 5); 
            waiter = wait(100); // delay
            
            // Reset variables and change scene.
            if (!fadein && opac >= 255 && waiter) {
                waiter = false;
                scene = 3;
                fadein = true;
                opac = 255;
                wait = 0;
            }
        }
        
        // Scene 3: Reset Slide(Fade-in-out transition).
        else if (scene == 3) {
            
            //Slide change, draw, fade-in-out transition.
            slide.changeScene(3);
            slide.draw();
            fadeinout(80, 5); 
            waiter = wait(100); 
            scene = 4; 
        } 
        
        //Scene 4: Objective Slide.
        else if (scene == 4) {
            
            // For loop for each text string in the textString array(3).
            for (int i = 0; i < textString.length; i++) {
                // if charCount[0,1,2] is less than index length of textString[0,1,2]
                if (charrayCount[i] < textString[i].length()) { 
                    tarraypeFrameCount[i]++; // Increase frame counter.
                    //if frame counter modulus by typeSpeed(5) = 0 -> start printing
                    if (tarraypeFrameCount[i] % typeSpeed == 0) {
                        // Starting slowly adding each character to displayed variable.
                        displayTexts[i] += textString[i].charAt(charrayCount[i]);
                        charrayCount[i]++; // Increase the character index
                    }
                }
                
                fill(255); // Text colour to white
                // Display the displayed text.
                if (i == 0) {
                    text(displayTexts[i], 200, 215 + (40 * i)); // "Objective:"
                } else {
                    text(displayTexts[i], 30, 215 + (40 * i)); // "The other texts."
                }
            }
            
            // Delay method and Reset variables and change scene.
            waiter = wait(350); // 350
            if (waiter) {
                waiter = false;
                scene = 5;
            }
        } 
        
        // Scene 5: Map bottom left
        else if (scene == 5) {
            
            // Background change and draw.
            bg.changeScene(2); 
            bg.draw();
            
            // Reset Distance movement
            dx = 0;
            dy = 0;
            
            // Movement for player character
            // Checks if wasdHold variables are true and adds/minus speed to distance movement.
            // wasdHold is from processing core methods(Key Released and Pressed)
            if (wHold) dy -= SPEED; // up
            else if (sHold) dy += SPEED; // down
            else if (aHold) dx -= SPEED; // left
            else if (dHold) dx += SPEED; // right

            // Calls move method from the you object.
            // moves the character
            you.move(dx, dy);
            
            // Calls moveConstraint method from object. 
            // where the character can't move/ restricted.
            you.moveConstraint(false);
            
            // Draws the character.
            you.draw();
            
            // Debug hitbox for character
            you.drawHitbox();
            
            // Transition box positions and draw.
            box[0].changeBox(595, 270, 15, 50);
            box[0].draw();
            box[1].changeBox(420, -6, 40, 10);
            box[1].draw();
            
            // Collision method to check if character is touching the transition boxes
            leftbotToRightbot();
            leftbotToLeftup();
        } 
        
        // Scene 6: Map bottom right
        else if (scene == 6) {
            
            // Background change and draw.
            bg.changeScene(4);
            bg.draw();
            
            // Reset Distance movement
            dx = 0;
            dy = 0;

            // Movement for player character
            // Checks if wasdHold variables are true and adds/minus speed to distance movement.
            // wasdHold is from processing core methods(Key Released and Pressed)
            if (wHold) dy -= SPEED;
            else if (sHold) dy += SPEED;
            else if (aHold) dx -= SPEED;
            else if (dHold) dx += SPEED;

            // Calls move method from the you object.
            // moves the character
            you.move(dx, dy);
            
            // Calls moveConstraint method from object. 
            // where the character can't move/ restricted.
            you.moveConstraint(false);
            
            // Draws the character.
            you.draw();
            
             // Debug hitbox for character
            you.drawHitbox();

            // Transition box positions and draw.
            box[0].changeBox(-10, 270, 15, 50);
            box[0].draw();
            box[3].changeBox(130, -5, 50, 10);
            box[3].draw();
            box[4].changeBox(420, -5, 50, 10);
            box[4].draw();
            
            // Collision method to check if character is touching the transition boxes
            leftbotToRightbot();
            rightuptToRightbot();
        } 
        
        //Scene: Map left up
        else if (scene == 7) {
            
            // Background change and draw.
            bg.changeScene(1);
            bg.draw();
            
            // Reset Distance movement
            dx = 0;
            dy = 0;

            if (wHold) dy -= SPEED;
            else if (sHold) dy += SPEED;
            else if (aHold) dx -= SPEED;
            else if (dHold) dx += SPEED;

            // Calls move method from the you object.
            // moves the character
            you.move(dx, dy);
            
            // Calls moveConstraint method from object. 
            // where the character can't move/ restricted.
            you.moveConstraint(true);
            
            // Draws the character.
            you.draw();
            
            // Debug hitbox for character
            you.drawHitbox();

            // Transition box positions and draw.
            box[1].changeBox(420, 494, 40, 10);
            box[1].draw();
            box[2].changeBox(595, 330, 15, 50);
            box[2].draw();
            
            // Collision method to check if character is touching the transition boxes
            leftbotToLeftup();
            leftuptToRightup();

        } 
        
        // Scene 8: Map right up
        else if (scene == 8) {
            
            // Background change and draw.
            bg.changeScene(3);
            bg.draw();
            
            // Reset Distance movement 
            dx = 0;
            dy = 0;
          
            // Movement for player character
            // Checks if wasdHold variables are true and adds/minus speed to distance movement.
            // wasdHold is from processing core methods(Key Released and Pressed)
            if (wHold) dy -= SPEED;
            else if (sHold) dy += SPEED;
            else if (aHold) dx -= SPEED;
            else if (dHold) dx += SPEED;

            // Calls move method from the you object.
            // moves the character
            you.move(dx, dy);
            
            // Calls moveConstraint method from object. 
            // where the character can't move/ restricted.
            you.moveConstraint(true);
            
            // Draws the character.
            you.draw();
            
            // Debug hitbox for character
            you.drawHitbox();
            
            // Transition box positions and draw.
            box[2].changeBox(-11, 315, 15, 40);
            box[2].draw();
            box[3].changeBox(130, 495, 50, 10);
            box[3].draw();
            box[4].changeBox(420, 495, 50, 10);
            box[4].draw();
            
             // Collision method to check if character is touching the transition boxes
            leftuptToRightup();
            rightuptToRightbot();
        }
    }

// --- MAP TRANSITION HELPERS ---
    /**
     * 
     */
    public void rightuptToRightbot() {
        if (you.isCollidingWith(box[3]) && scene == 8) {
            System.out.println("TOUCHED lu to ru");
            scene = 6;
            you.setPos(130, 10);
        } else if (you.isCollidingWith(box[3]) && scene == 6) {
            System.out.println("TOUCHED lu to ru");
            scene = 8;
            you.setPos(130, 437);
        }

        if (you.isCollidingWith(box[4]) && scene == 8) {
            System.out.println("TOUCHED lu to ru");
            scene = 6;
            you.setPos(420,10);
        } else if (you.isCollidingWith(box[4]) && scene == 6) {
            System.out.println("TOUCHED lu to ru");
            scene = 8;
            you.setPos(420, 437);
        }
    }

    public void leftuptToRightup() {
        if (you.isCollidingWith(box[2]) && scene == 7) {
            System.out.println("TOUCHED lu to ru");
            scene = 8;
      
            you.setPos(-4, 305);
        } else if (you.isCollidingWith(box[2]) && scene == 8) {
            System.out.println("TOUCHED ru to lu");
            scene = 7;
    
            you.setPos(550, 320);
        }
    }

    public void leftbotToRightbot() {
        if (you.isCollidingWith(box[0]) && scene == 5) {
            System.out.println("TOUCHED lb to rb");
            scene = 6;
     
            you.setPos(-5, 265);
        } else if (you.isCollidingWith(box[0]) && scene == 6) {
            System.out.println("TOUCHED rb to lb");
            scene = 5;
 
            you.setPos(547, 265);
        }
    }

    public void leftbotToLeftup() {
        if (you.isCollidingWith(box[1]) && scene == 5) {
            System.out.println("TOUCHED lb to lu");
            scene = 7;

            you.setPos(410, 430);
        } else if (you.isCollidingWith(box[1]) && scene == 7) {
            System.out.println("TOUCHED lu to lb");
            scene = 5;

            you.setPos(410, 5);
        }
    }

    /**
     * Handles fade-in and fade-out effects.
     * @param waitTime time to wait during fade out
     * @param add fade increment/decrement amount
     */
    public void fadeinout(int waitTime, int add) {
        if (fadein) {
            if (opac > 0) opac -= add;
            if (opac <= 0) fadein = false;
        }
        if (!fadein) {
            if (wait < waitTime) wait++;
            if (wait >= waitTime && opac < 255) opac += add;
        }
        fill(0, 0, 0, opac);
        rect(-1, -1, 601, 501);
    }

    /**
     * Wait function acting as a timer.
     * @param waittime number of frames to wait
     * @return true if wait time is elapsed, false otherwise
     */
    public boolean wait(int waittime) {
        if (time < waittime) {
            time++;
            return false;
        } else {
            time = 0;
            return true;
        }
    }

    /**
     * Sets key hold flags on key press.
     */
    public void keyPressed() {
        if (key == 'w') wHold = true;
        if (key == 's') sHold = true;
        if (key == 'a') aHold = true;
        if (key == 'd') dHold = true;
    }

    /**
     * Unsets key hold flags on key release.
     */
    public void keyReleased() {
        if (key == 'w') wHold = false;
        if (key == 's') sHold = false;
        if (key == 'a') aHold = false;
        if (key == 'd') dHold = false;
    }
}
