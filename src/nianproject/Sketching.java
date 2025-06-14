// Imports and packages
// Use of file output for adding/modifying data to a flat-file (database)
// When write when taskes are completed. and write if sucess and score and write if fail and score 






//

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
    private Structures[] build; // Array to hold structures.
    private Villager[] villagers;
    private Quest questboard;
    private Item[] items;
    private Paper[] paper;

    // Variable to track key press states
    private boolean wHold = false, sHold = false, aHold = false, dHold = false;
    private int eHold = 0 ,fHold=0;

    // Variable counter to track current scenes
    private int scene = 5;

    // Variables for character movement
    private int dx = 0, dy = 0;          // Movement distance on x and y
    private int speed = 5;         // Movement speed(2)

    // Variables to handle fade-in and fade-out transitions
    private int opac = 255,  // Opacity for the fade effect
                wait = 0,   // Counter for wait time
                time = 0;   // Time delay counter
    private boolean fadein = true,  // To control fade-in effect
                    waiter = false; // To control the delay and trigger the next scene
    private boolean waiti[] = new boolean[15];

    // Variables for typing animation for single line
    private String text = "February 3, 1045 BCE,"; // Text to display
    private String displayText = "";                // Currently displayed lines
    private int charCount = 0,                      // Index of text to display
                typespeed = 5,                      // Delay between character display
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
        build = new Structures[6];
        villagers = new Villager[3];
        questboard = new Quest(this);
        items = new Item[15];
        paper = new Paper[3];
        
        
        
        // Instaniating the transition boxes for scene change.
        box[0] = new Transition(this, 595, 270, 15, 50);
        box[1] = new Transition(this, 420, -6, 40, 10);
        box[2] = new Transition(this, 595, 330, 15, 50);
        box[3] = new Transition(this, 130, 495, 50, 10);
        box[4] = new Transition(this, 420, 495, 50, 10);
        
        // Instaniating the Structures. 
        build[0] = new Structures(this, 250, 150);
        build[1] = new Structures(this, 35, 150);
        build[2] = new Structures(this, 145, 335);
        build[2].changeProp(1);
        build[3] = new Structures(this, 250, -40);
        build[4] = new Structures(this, 30, 35);
        build[5] = new Structures(this, 540, 50);
        build[5].changeProp(5);

        
        villagers[0] = new Villager(this,470,280,"oldman");
        villagers[0].changeProp(0);
        villagers[1] = new Villager(this,50,250,"mob","v1");
        villagers[1].changeProp(1);
        villagers[2] = new Villager(this,135,240);
        villagers[2].changeProp(2);
        
        items[0] = new Item(this,570,75); // cloth
        items[0].changeProp(0);
        items[1] = new Item(this,520,265); // lantern
        items[1].changeProp(1);
        items[2] = new Item(this,220,260); // suit
         items[2].changeProp(2);
        items[3] = new Item(this,530,260); // candle
         items[3].changeProp(3);
        items[4] = new Item(this,235,375); // candle 2
         items[4].changeProp(4);
        items[5] = new Item(this,30,110); // cracker
        items[5].changeProp(5);
        items[6] = new Item(this,180,400); // lantern
        items[6].changeProp(1);
        items[7] = new Item(this,410,300); // cracker
        items[7].changeProp(5);
        items[8] = new Item(this,40,350); // cracker
        items[8].changeProp(5);
        items[9] = new Item(this,150,10); // cloth
        items[9].changeProp(0);
        items[10] = new Item(this,465,120); // cloth
        items[10].changeProp(0);
        items[11] = new Item(this,205,250); // lantern
        items[11].changeProp(1);
        items[12] = new Item(this,390,250); // lantern
        items[12].changeProp(1);
        items[13] = new Item(this,370,400); // cloth
        items[13].changeProp(0);
        items[14] = new Item(this,140,420); // cloth
        items[14].changeProp(0);
        
        paper[0] = new Paper(this, 160,110,0);
        paper[1] = new Paper(this, 200,30,1);
        paper[2] = new Paper(this, 40,320,2);
        
        // Load pixel Font for tpying animations.
        font = createFont("Pixel.otf", 32); // pixel font file and size 32
        textFont(font); 
    }

    /**
     * The main draw loop for the game. (Called continuously)
     * Handles scenes, activating fade transitions, typing animations, character movement.
     * Everything basically.
     */
    
    
    
    
    
    
    
     private int gameTimerCount = 0;
    private int gameMinuteCount = 0;
    private int hour = 11;
    private int minutes = 30;
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
                
                // If frame counter modulus by typespeed(5) = 0 -> start printing
                if (typeFrameCount % typespeed == 0) { 
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
                    //if frame counter modulus by typespeed(5) = 0 -> start printing
                    if (tarraypeFrameCount[i] % typespeed == 0) {
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
            if (wHold) dy -= speed; // up
            else if (sHold) dy += speed; // down
            else if (aHold) dx -= speed; // left
            else if (dHold) dx += speed; // right

            // Calls move method from the you object.
            // moves the character
            you.oldy  = -dy;
            you.oldx = -dx;
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

            drawBuild(0);
            drawBuild(1);
            drawBuild(2);
            drawBuild(3);
            drawBuild(4);
            drawBuild(5);

           drawVillagerIfActive(1);
           
   
           
            drawItem(0);
            drawItem(4);
            drawItem(8);
            drawItem(9);
            
            drawPaper(0);
            
            
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
            if (wHold) dy -= speed;
            else if (sHold) dy += speed;
            else if (aHold) dx -= speed;
            else if (dHold) dx += speed;

            // Calls move method from the you object.
            // moves the character
            you.oldy  = -dy;
            you.oldx = -dx;
            you.move(dx, dy);

            
            // Calls moveConstraint method from object. 
            // where the character can't move/ restricted.
            you.moveConstraint(false);
            
            // Draws the character.
            you.draw();
            
             // Debug hitbox for character
            you.drawHitbox();
               drawBuild(0);
            drawBuild(1);
            drawBuild(2);
            drawBuild(3);
            drawBuild(4);
            drawBuild(5);
            
  
                        drawItem(3);
            drawItem(5);
            drawItem(10);

            drawPaper(1);
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

            if (wHold) dy -= speed;
            else if (sHold) dy += speed;
            else if (aHold) dx -= speed;
            else if (dHold) dx += speed;

            // Calls move method from the you object.
            // moves the character
                        you.oldy  = -dy;
            you.oldx = -dx;
            you.move(dx, dy);
            
            // Calls moveConstraint method from object. 
            // where the character can't move/ restricted.
            you.moveConstraint(true);
            
            // Draws the character.
            you.draw();
            
            // Debug hitbox for character
            you.drawHitbox();
 

                 drawBuild(0);
            drawBuild(1);
            drawBuild(2);
            drawBuild(3);
            drawBuild(4);
  

           drawVillagerIfActive(2);

            
                        drawItem(1);
            drawItem(2);
            drawItem(6);
            drawItem(7);
            drawPaper(2);
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
            if (wHold) dy -= speed;
            else if (sHold) dy += speed;
            else if (aHold) dx -= speed;
            else if (dHold) dx += speed;

            // Calls move method from the you object.
            // moves the character
                        you.oldy  = -dy;
            you.oldx = -dx;
            you.move(dx, dy);
            
            // Calls moveConstraint method from object. 
            // where the character can't move/ restricted.
            you.moveConstraint(true);
            
            // Draws the character.
            you.draw();
            
            // Debug hitbox for character
            you.drawHitbox();
  

            
            drawBuild(0);
            drawBuild(1);
            drawBuild(2);
            drawBuild(3);

            
            drawVillagerIfActive(0);

            drawItem(11);
            drawItem(12);
            drawItem(13);
            drawItem(14);


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
        
        else if (scene == 9) { 
          // Slide change, draw, fade-in-out transition.
            slide.changeScene(4); 
            slide.draw(); 
            fadeinout(60, 9); 
            waiter = wait(30); // delay
            
            // Reset variables and change scene.
            if (!fadein && opac >= 255 && waiter) {
                waiter = false;
                scene = 10;
                fadein = true;
                opac = 255;
                wait = 0;
            }}  else if (scene == 10) { 
          // Slide change, draw, fade-in-out transition.
            slide.changeScene(6); 
            slide.draw(); 
            fadeinout(60, 9); 
            waiter = wait(30); // delay
                        // Reset variables and change scene.

            if (!fadein && opac >= 255 && waiter) {
                waiter = false;
                scene = 11;
                fadein = true;
                opac = 255;
                wait = 0;
            } } else if (scene == 11) { 
          // Slide change, draw, fade-in-out transition.
            slide.changeScene(7); 
            slide.draw(); 
            fadeinout(60, 9); 
            waiter = wait(30); // delay
            
            // Reset variables and change scene.
            if (!fadein && opac >= 255 && waiter) {
                waiter = false;
                scene = 12;
                fadein = true;
                opac = 255;
                wait = 0;
            } } else if (scene == 12) { 
          // Slide change, draw, fade-in-out transition.
            slide.changeScene(8); 
            slide.draw(); 
            fill(255);
            textSize(32);
            text("game won", 200,250);
            fadeinout(100, 5); 
            waiter = wait(50); // delay
             if (!fadein && opac >= 255 && waiter) {
                waiter = false;
                scene = 12;
                fadein = true;
                opac = 255;
                wait = 0;
                Score.writeFileState(true, hour+":" +minutes);
            } 
            
           
          
            
            
            
            
        } else if (scene == 15) { 
          // Slide change, draw, fade-in-out transition.
            slide.changeScene(5); 
            slide.draw(); 
            fill(255);
            textSize(32);
            text("game over", 200,250);
            fadeinout(80, 5); 
            waiter = wait(50); // delay
            if (!fadein && opac >= 255 && waiter) {
                waiter = false;
                scene = 15;
                fadein = true;
                opac = 255;
                wait = 0;
            Score.writeFileState(false, "lose");
          }}
        
        
            
        if (scene == 5 || scene == 6||scene == 7|| scene == 8) {
            questboard.draw();
            textSize(12);
            fill(255);
                     if (gameMinuteCount >= 450) {
                gameMinuteCount = 0;
                minutes++;
                if (minutes >=60){
                    minutes = 0;
                    hour++;
                }
            }
            if (minutes < 10) {text(hour+":0" +minutes + "  "  , 280,20);} else { 
            text(hour+":" +minutes + "  "  , 280,20);}
            gameTimerCount++;
            gameMinuteCount++;
   
           if (minutes == 0 && hour ==12){
               speed=0;
               scene = 15;
           }
        }
        mousePressed();System.out.println(eHold);}
          public void colPaper(int index) {
    if (you.isCollidingWith(paper[index])) {
        text(paper[index].text,you.x,you.y);
        Score.interaction("paper");
    }}
   private boolean[] hideItem = new boolean[15];
  public void colItem(int index) {
    if (you.isCollidingWith(items[index])) {
        Score.interaction("item");
        if (fHold == 0) {
        fill(255);
        text("F to Collect", you.x, you.y);
        } else{        
            hideItem[index] = true;
            switch(index){
                case 0:
                    Quest.coltrack[0]++;
                    Score.writeFileTask("Collected Cloth");
                    break;
                case 1:
                    Quest.coltrack[1]++;
                    Score.writeFileTask("Collected Lantern");
                    break;
                                    case 2:
                    Quest.coltrack[2]++;
                    Score.writeFileTask("Collected Suit");
                    break;
                                    case 3:
                    Quest.coltrack[3]++;
                    Score.writeFileTask("Collected Candle");
                    break;
                                    case 4:
                    Quest.coltrack[3]++;
                    Score.writeFileTask("Collected Candle");
                    break;
                    case 5:
                    Quest.coltrack[4]++;
                    Score.writeFileTask("Collected Firecracker");
                    break;
                    case 6:
                    Quest.coltrack[1]++;
                    Score.writeFileTask("Collected Lantern");
                    break;
                    case 7:
                    Quest.coltrack[4]++;
                    Score.writeFileTask("Collected Firecracker");
                    break;
                    case 8:
                    Quest.coltrack[4]++;
                    Score.writeFileTask("Collected Firecracker");
                    break;
                    case 9:
                    Quest.coltrack[0]++;
                    Score.writeFileTask("Collected Cloth");
                    break;
                    case 10:
                    Quest.coltrack[0]++;
                    Score.writeFileTask("Collected Cloth");
                    break;
                    case 11:
                    Quest.coltrack[1]++;
                    Score.writeFileTask("Collected Lantern");
                    break;
                    case 12:
                    Quest.coltrack[1]++;
                    Score.writeFileTask("Collected Lantern");
                    break;
                    case 13:
                    Quest.coltrack[0]++;
                    Score.writeFileTask("Collected Cloth");
                    break;
                    case 14:
                    Quest.coltrack[0]++;
                    Score.writeFileTask("Collected Cloth");
                    break;
                    
            }
        }
    }
  
  }

    
    public void colBuild(int index){
        if (you.isCollidingWith(build[index])) {
                Score.interaction("building");
                you.move(you.oldx, you.oldy);
                if (you.lastdirection.equals("down")) {
                    you.lastdirection = "up";
                }
                else if (you.lastdirection.equals("up")) {
                    you.lastdirection = "down";
                }
                else if (you.lastdirection.equals("right")) {
                    you.lastdirection = "left";
                }
                else if (you.lastdirection.equals("left")) {
                    you.lastdirection = "right";
                }
        }
    }
 
    private int dialogueStage = 0,dialogueStartTime = 0;
    
 public void colVil(int index) {
     textSize(12);
    if (you.isCollidingWith(villagers[index])) {
        Score.interaction("villager");

        // Villager 1 interaction
       if (!Quest.vilTrack[1] && index == 1) {
    if (eHold == 0 || eHold==8) {
        fill(255);
        text("E to Interact", you.x, you.y);
    } else if (eHold == 1) {
        you.setPos(65, 245);
        speed = 0;
        text("Nian is coming... \nleave", you.x, you.y-10);
        waiti[0] = wait(50);
        if (waiti[0]) eHold =2;
    } else if (eHold == 2) {
        text(Quest.dialogue[0][0], 40, 230);
        waiti[1] = wait(50);
        if (waiti[1]) eHold =3;
    }
    else if (eHold == 3) {
        text(Quest.dialogue[0][1], 40, 230);
        waiti[2] = wait(50);
        if (waiti[2]) eHold =4;
    }    else if (eHold == 4) {
        text(Quest.dialogue[0][2], 40, 230);
        waiti[3] = wait(50);
        if (waiti[3]) {eHold =5; Quest.vilTrack[1] = true; speed =5; Quest.track[0]++;}
    }}
    
           if (!Quest.vilTrack[2] && index == 2) {
    if (eHold == 0 || eHold == 5) {
        fill(255);
        text("E to Interact", you.x, you.y);
        you.lastdirection="left";
    } else if (eHold == 1) {
        you.setPos(150, 235);
        speed = 0;
        text("Nian is coming... \nleave", you.x, you.y-10);
        waiti[4] = wait(50);
        if (waiti[4]) eHold =6;
    } else if (eHold == 6) {
        text(Quest.dialogue[1][0], 70, 230);
        waiti[5] = wait(50);
        if (waiti[5]) eHold =7;
    }
      else if (eHold == 7) {
        text(Quest.dialogue[1][1], 70, 230);
        waiti[6] = wait(50);
        if (waiti[6]) {eHold =8; Quest.vilTrack[2] = true; speed =5; Quest.track[0]++;}
    }
   
}

    if (!Quest.vilTrack[0] && index == 0 && !once) {
    if (eHold == 0 || eHold == 5 || eHold ==8) {
        fill(255);
        text("E to Interact", you.x, you.y);
        you.lastdirection="right";
    } else if (eHold == 1) {
        you.setPos(425, 275);
        speed = 0;
        text("Nian is coming... \nrun...", you.x, you.y-10);
        waiti[7] = wait(100);
        if (waiti[7]) eHold =9;
    } else if (eHold == 9) {
        text(Quest.dialogue[2][0], you.x + 5, you.y+70);
        waiti[8] = wait(150);
        if (waiti[8]) eHold =10;
        
    } else if (eHold ==10) {
        text("How?", you.x, you.y-10);
        waiti[9] = wait(50);
        if (waiti[9]) eHold =11;
    }else if (eHold == 11) {
        text(Quest.dialogue[2][1], you.x + 5, you.y+70);
        waiti[10] = wait(50);
        if (waiti[10]) eHold =12;}
else if (eHold == 12) {
        text(Quest.dialogue[2][2], you.x - 20, you.y+70);
        waiti[11] = wait(120);
        if (waiti[11]) eHold =13;}
    
      else if (eHold == 13) {
        waiti[12] = wait(10);
        if (waiti[12]) {eHold =14; once = true; speed =5; Quest.questtracker = 1; Quest.vilTrack[1] = true; Quest.vilTrack[2] = true;}
    }
   
}

    if (!Quest.vilTrack[0] && index == 0 && Quest.done == true) {
        if (eHold==14){
        fill(255);
        text("E to Interact", you.x, you.y);}
        you.lastdirection="right";
    if (eHold == 15) {
        you.setPos(425, 275);
        text(Quest.dialogue[3][0], you.x + 5, you.y+70);
        speed = 0; 
        waiti[13] = wait(150);
        if (waiti[13]){scene =9;}
    }}
            
  

        
    }} private boolean once;

    
        public void drawBuild(int index){
            build[index].draw();
            colBuild(index);
        }
        
        public void drawPaper(int index){
            paper[index].draw();
            paper[index].drawHitbox();
            colPaper(index);

        } 
        public void drawItem(int index){
            if (Quest.vilTrack[1] == true && Quest.vilTrack[2] ==true && eHold==14) {
            if (!hideItem[index]) {
            items[index].draw(); colItem(index); //items[index].drawHitbox();
           }
            }
        }
        
        public void drawVillagerIfActive(int index) {
    if (!Quest.vilTrack[index]) {
        villagers[index].draw();
        villagers[index].drawHitbox();
        colVil(index);
    }
}

    public void loopBuild(int count){
        for (int i=0; i<count;i++){
            colBuild(i);
        }
    }

// --- MAP TRANSITION HELPERS ---
    /**
     * 
     */
    public void rightuptToRightbot() {
        if (you.isCollidingWith(box[3]) && scene == 8) {
          
            Score.transition("Right Up to Right Bottom");
            scene = 6;
            build[0].changePos(230, 150);
            build[0].changeProp(0);
            build[1].changePos(370, 160);
            build[1].changeProp(0);
            build[2].changePos(510, 155);
            build[2].changeProp(0);
            build[3].changePos(256, -40);
            build[3].changeProp(0);
            build[4].changePos(500, 301);
            build[4].changeProp(1);
            build[5].changePos(542,45);
            build[5].changeProp(5);
            you.setPos(130, 10);
        } else if (you.isCollidingWith(box[3]) && scene == 6) {
            Score.transition("Right Bottom to Right Up");
            scene = 8;
            build[0].changePos(30, 190);
            build[0].changeProp(3);
            build[1].changePos(240, 150);
            build[1].changeProp(6);
            build[2].changePos(256, 460);
            build[2].changeProp(0);
            build[3].changePos(280, 390);
            build[3].changeProp(5);
            you.setPos(130, 437);
        }

        if (you.isCollidingWith(box[4]) && scene == 8) {
            Score.transition("Right Up to Right Bottom");
            scene = 6;
            build[0].changePos(230, 150);
            build[0].changeProp(0);
            build[1].changePos(370, 160);
            build[1].changeProp(0);
            build[2].changePos(510, 155);
            build[2].changeProp(0);
            build[3].changePos(256, -40);
            build[3].changeProp(0);
            build[4].changePos(500, 301);
            build[4].changeProp(1);
            build[5].changePos(542,45);
            build[5].changeProp(5);
            you.setPos(420,10);
        } else if (you.isCollidingWith(box[4]) && scene == 6) {
            Score.transition("Right Bottom to Right Up");
            scene = 8;
                      build[0].changePos(30, 190);
            build[0].changeProp(3);
            build[1].changePos(240, 150);
            build[1].changeProp(6);
            build[2].changePos(256, 460);
            build[2].changeProp(0);
            build[3].changePos(280, 390);
            build[3].changeProp(5);
            you.setPos(420, 437);
        }
    }

    public void leftuptToRightup() {
        if (you.isCollidingWith(box[2]) && scene == 7) {
             Score.transition("Left Up to Right Up");
            scene = 8;
                build[0].changePos(30, 190);
            build[0].changeProp(3);
            build[1].changePos(240, 150);
            build[1].changeProp(6);
            build[2].changePos(256, 460);
            build[2].changeProp(0);
            build[3].changePos(280, 390);
            build[3].changeProp(5);
            you.setPos(-4, 305);
        } else if (you.isCollidingWith(box[2]) && scene == 8) {
             Score.transition("Right Up to Left Up");
            scene = 7;
    build[0].changePos(250, 460);
build[1].changePos(77, 380);
build[1].changeProp(4);
build[2].changePos(260, 250);
build[2].changeProp(2);
build[3].changePos(360, 250);
build[3].changeProp(2);
build[4].changePos(460, 250);
build[4].changeProp(2);
            you.setPos(550, 320);
        }
    }

    public void leftbotToRightbot() {
        if (you.isCollidingWith(box[0]) && scene == 5) {
             Score.transition("Left Bottom to Right Bottom");
            scene = 6;
            build[0].changePos(230, 150);
            build[0].changeProp(0);
            build[1].changePos(370, 160);
            build[1].changeProp(0);
            build[2].changePos(510, 155);
            build[2].changeProp(0);
            build[3].changePos(256, -40);
            build[3].changeProp(0);
            build[4].changePos(500, 301);
            build[4].changeProp(1);
            build[5].changePos(542,45);
            build[5].changeProp(5);
            you.setPos(-5, 265);
        } else if (you.isCollidingWith(box[0]) && scene == 6) {
             Score.transition("Right Bottom to Left Bottom");
            scene = 5;
            build[0].changePos(250, 150);
            build[0].changeProp(0);
            build[1].changePos(35, 150);
            build[1].changeProp(0);
            build[2].changePos(145, 335);
            build[2].changeProp(1);
            build[3].changePos(250, -40);
            build[3].changeProp(0);
            build[4].changePos(30, 35);
            build[4].changeProp(0);
            build[5].changePos(540, 50);
            build[5].changeProp(5);
            you.setPos(547, 265);
        }
    }

    public void leftbotToLeftup() {
        if (you.isCollidingWith(box[1]) && scene == 5) {
             Score.transition("Left Bottom to Left Up");
            scene = 7;
build[0].changePos(250, 460);
build[1].changePos(77, 380);
build[1].changeProp(4);
build[2].changePos(260, 250);
build[2].changeProp(2);
build[3].changePos(360, 250);
build[3].changeProp(2);
build[4].changePos(460, 250);
build[4].changeProp(2);
            you.setPos(410, 430);
        } else if (you.isCollidingWith(box[1]) && scene == 7) {
             Score.transition("Left Up to Left Bottom");
            scene = 5;
            build[0].changePos(250, 150);
            build[0].changeProp(0);
            build[1].changePos(35, 150);
            build[1].changeProp(0);
            build[2].changePos(145, 335);
            build[2].changeProp(1);
            build[3].changePos(250, -40);
            build[3].changeProp(0);
            build[4].changePos(30, 35);
            build[4].changeProp(0);
            build[5].changePos(540, 50);
            build[5].changeProp(5);
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
       
        if (Quest.done) { if (key == 'e') eHold = 15;}else if (Quest.vilTrack[1] && Quest.vilTrack[2] && once){if (key == 'e') eHold = 14;} else { if (key == 'e') eHold = 1;}
        if (key == 'f') fHold = 1;
    }

    /**
     * Unsets key hold flags on key release.
     */
    public void keyReleased() {
        if (key == 'w') wHold = false;
        if (key == 's') sHold = false;
        if (key == 'a') aHold = false;
        if (key == 'd') dHold = false;
        if (key == 'f') fHold = 0;
        
    }

    public void mousePressed(){
        fill(255);
        text(mouseX + "," + mouseY,0,30);
    }
}
