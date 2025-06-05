/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nianproject;

import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author 342380474
 */
public class Scene {
    protected PImage current;
    protected PApplet app;

    
    public Scene(PApplet app){
        this.app=app;
        current = app.loadImage("imgs/scene1.png");  
    }
    
    public void changeScene(int x){
        switch(x){
            case 1:
                current = app.loadImage("imgs/scene1.png");  
                break;
            case 2:
                current = app.loadImage("imgs/NianAwaken.png");
                break;
            case 3:
                current = app.loadImage("imgs/NianAttack.png");
                break;
                
        }
    }
    
    public void draw(){
        app.image(current,0,0,600,499);
    }
    
}
