// Importing packages
package nianproject;
import processing.core.PApplet;

/**
 * is an object to represent task/quests for the character to complete
 * @author Jacob Zheng
 */
public class Quest extends Props{
    // quests/tasks stored in an array
    protected String[] quests = {"Warn the \nOther Villagers", "Gather Food", "Pump Water","Collect Red Cloth", "Collect a Lantern", "Find Red Clothes", "Collect Candles", "Find a Firecracker"}; 
    // dialogue for the quests villager interactions.
    protected static String[][] dialogue = {{"It is today???","Thank you for \nthe warning.", "I must leave."}, //npc 1
                                     {"Thank you for \nthe warning.", "You saved my butt."},             //npc2
                                     {"Don't run. I know \nhow to defeat Nian. \nJoin me.", "Trust Me.", "Please gather:\nred cloth,\ncandles, lanterns,\nred clothes,\nand firecrackers"},//oldman
                                     {"Good job!\nLet us Prepare for\nthe attack."}
    };
    // tracks which villagers ahve been interacted with
    protected static boolean vilTrack[] = new boolean[3];
    // tracks which set of quests the character has
    protected static int questtracker = 0;
    // tracks each task and how many of it are completed of set 1
    protected static int[] track = new int [3];
    // tracks each task and how many of it are completed of set 2
    protected static int[] coltrack = new int [5];
    // tracks if the tasks are completed
    protected static boolean done = false;
    
    /**
     * Constructor for a Quest.
     * @param app  Reference to the main PApplet application
     */
    public Quest(PApplet app) {
        super(app, 0, 0); // calls parent constructor
    }   
    
    /**
     * Draws the quests and quest board
     */
    @Override
    public void draw(){
        app.fill(0,0,0,128); // fill black with half opacity
        app.noStroke(); //no outline
        app.rect(0, 375, 220, 150); //draw the quest board
        if(questtracker == 0){ // if quests are set 1
            app.fill(255); // text colour white
            app.textSize(12); // text size
            //main quest
            app.text(quests[0] + "(" + track[0] + "/3)",5,390); // display task and checks if been done and will update.
            app.fill(128,128,128); // side questions
            app.text(quests[1] + "(" + track[1] + "/3)",5,420);
            app.text(quests[2] + "(" + track[2] + "/1)",5,440);
        } else {// else if set 2 tasks
            // checks if all tasks are copmpleted and writes to file
            if (coltrack[0] == 5 && coltrack[1] == 4 && coltrack[2] == 1 && coltrack[3] == 2 && coltrack[4] ==3){
            app.fill(0,255,0); done=true; Score.writeFileTask("ALL TASKS COMPLETED");
            } 
            else {app.fill(255); } // else if not completed
            app.textSize(12); 
            // display task and checks if been done and will update.
            app.text(quests[3] + " (" + coltrack[0] + "/5)",5,390);
            app.text(quests[4] + " (" + coltrack[1] + "/4)",5,410);
            app.text(quests[5] + " (" + coltrack[2] + "/1)",5,430);
            app.text(quests[6] + " (" + coltrack[3] + "/2)",5,450);
            app.text(quests[7] + " (" + coltrack[4] + "/3)",5,470);
            
        }
    }
}

