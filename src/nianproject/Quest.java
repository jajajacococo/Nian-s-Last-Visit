/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nianproject;

import processing.core.PApplet;

/**
 *
 * @author Jacob Zheng
 */
public class Quest extends Props{
    protected String[] quests = {"Warn the \nOther Villagers", "Gather Food", "Pump Water","Collect Red Cloth", "Collect a Lantern", "Find Red Clothes", "Collect Candles", "Find a Firecracker"}; 
    protected static String[][] dialogue = {{"It is today???","Thank you for \nthe warning.", "I must leave."}, //npc 1
                                     {"Thank you for \nthe warning.", "You saved my butt."},             //npc2
                                     {"Don't run. I know \nhow to defeat Nian. \nJoin me.", "Trust Me.", "Please gather:\nred cloth,\ncandles, lanterns,\nred clothes,\nand firecrackers"},//oldman
                                     {"Good job!\nLet us Prepare for\nthe attack."}
    };
    protected static boolean vilTrack[] = new boolean[3];
    protected static int questtracker = 0;
    protected static int[] track = new int [3];
    protected static int[] coltrack = new int [5];
    protected static boolean done = false;
    
    public Quest(PApplet app) {
        super(app, 0, 0);
        current = app.loadImage("imgs/vil1.png");
        x=0;
        y=370;
    }   
       
    @Override
    public void draw(){
        app.fill(0,0,0,128);
        app.noStroke();
        app.rect(x, y, 220, 150);
        if(questtracker == 0){
            app.fill(255);
            app.textSize(12);
            app.text(quests[0] + "(" + track[0] + "/3)",5,390);
            app.fill(128,128,128);
            app.text(quests[1] + "(" + track[1] + "/3)",5,420);
            app.text(quests[2] + "(" + track[2] + "/1)",5,440);
        } else {
            if (coltrack[0] == 5 && coltrack[1] == 4 && coltrack[2] == 1 && coltrack[3] == 2 && coltrack[4] ==3){
            app.fill(0,255,0);done=true; Score.writeFileTask("ALL TASKS COMPLETED");}
            else {app.fill(255); }
            app.textSize(12);
            app.text(quests[3] + " (" + coltrack[0] + "/5)",5,390);
            app.text(quests[4] + " (" + coltrack[1] + "/4)",5,410);
            app.text(quests[5] + " (" + coltrack[2] + "/1)",5,430);
            app.text(quests[6] + " (" + coltrack[3] + "/2)",5,450);
            app.text(quests[7] + " (" + coltrack[4] + "/3)",5,470);
            
        }
    }
}

