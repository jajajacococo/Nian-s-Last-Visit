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
    boolean wHold= false; 
    boolean sHold= false; 
    boolean aHold= false; 
    boolean dHold= false;
    


    
    
    @Override // Get rid of yellow line
    public void settings(){
            size(600,500);
        }
    
    @Override 
    public void setup(){
        you = new Character(this,300-32,250-48);
        
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
        background(255);
    int dx = 0, dy = 0;
     int speed = 1;

     if (wHold) dy = -speed;
     else if (sHold) dy = speed;
     else if (aHold) dx = -speed;
     else if (dHold) dx = speed;

     you.move(dx, dy);
     you.draw();
    }

}

 
