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
    protected String[] quests = {"Warn the \nOther Villagers","Collect","",""}; 
    protected static String[][] dialogue = {{"It is today???","Thank you for \nthe warning.", "I must leave."}, //npc 1
                                     {"Thank you for \nthe warning.", "You saved my butt."},             //npc2
                                     {"Don't run. I know \nhow to defeat Nian. \nJoin me."}//oldman
    };
    protected static boolean vilTrack[] = new boolean[3];
    protected boolean done= false;
    protected static int track = 0;
    
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
        app.rect(x, y, 200, 150);
        if(!done){
            
            app.fill(255);
            app.textSize(12);
            app.text(quests[0] + "(" + track + "/3)",5,390);
        }
    }
}
