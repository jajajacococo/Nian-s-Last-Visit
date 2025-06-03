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
    protected PImage s1;
    protected PApplet app;

    
    public Scene(PApplet app){
        this.app=app;
        s1 = app.loadImage("imgs/scene1.png");
        
    }
    public void draw(){
        app.image(s1,0,0,600,499);
    }
    
}
