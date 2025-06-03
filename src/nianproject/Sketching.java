/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nianproject;
import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author Jacob Zheng
 */
public class Sketching extends PApplet{
    // Objects
    private Character you;
    private Scene s1;
    private boolean wHold= false; 
    private boolean sHold= false; 
    private boolean aHold= false; 
    private boolean dHold= false;
    private int scene = 0;
    private int dx = 0, dy = 0;
    private final int SPEED = 1;
    private int opactimer = 255;
    private int wait = 0;
    private String fade="in";


    
    
    @Override // Get rid of yellow line
    public void settings(){
            size(600,500);
            
        }
    
    @Override 
    public void setup(){
        you = new Character(this,300-32,250-48);
        s1 = new Scene(this);
        background(255);
    }
    
    // Remove janky movement delay by only tracking when one key is pressed and released
    public void keyPressed(){
    if (key == 'w') wHold= true; 
    if (key == 's') sHold= true; 
    if (key == 'a') aHold = true; 
    if (key == 'd') dHold= true;
    }
    public void keyReleased(){
        if (key == 'w') wHold= !true; 
        if (key == 's') sHold= !true; 
        if (key == 'a') aHold = !true; 
        if (key == 'd') dHold= !true;
    }
    
    
    
    
    
    @Override
    public void draw(){
        
        
        if (scene ==0){
            background(255);
            s1.draw();
            
            // SO JANKY REDO
            if (fade.equals("in")) {
                if (opactimer > 0){
                    opactimer--;
                }
                if (opactimer <= 0)
                fade = "out";
            } 
            if (fade.equals("out")){
                if (wait < 300){
                    wait++;
                }
                if (wait >=300){
                    if (opactimer < 255){
                       opactimer++;
                   }
                }
            }
            
            fill(0, 0, 0, opactimer);
            rect(-1,-1,601,501);
        }
      
        
        if (scene != 0) {
            if (wHold) dy = -SPEED;
            else if (sHold) dy = SPEED;
            else if (aHold) dx = -SPEED;
            else if (dHold) dx = SPEED;

            you.move(dx, dy);
            you.draw();
        }
    }

}

 
