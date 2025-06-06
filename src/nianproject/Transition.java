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
public class Transition {
    protected int x;
    protected int y;
    private PApplet app;
    protected int width, height;
    public Transition (PApplet app,int x, int y, int width, int height){
        this.app=app;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }
    
    public void changeBox(int x, int y, int width, int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }
    
     public void draw(){
        app.noFill();
        app.stroke(255, 255, 0);
        app.strokeWeight(2);
        app.rect(x, y, width, height);
        
    }
}
