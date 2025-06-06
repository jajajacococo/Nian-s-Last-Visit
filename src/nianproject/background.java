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
public class background extends Scene {
    private int bg;
    
    public background(PApplet app){
        super(app);
        current = app.loadImage("imgs/mapfinal2.png");
    }
    @Override
    public void changeScene(int x){
                switch (x) {
            case 1:
                current = app.loadImage("imgs/mapfinal1.png");
                break;
            case 2:
                current = app.loadImage("imgs/mapfinal2.png");
                break;
            case 3:
                current = app.loadImage("imgs/mapfinal3.png");
                break;
            case 4:
                current = app.loadImage("imgs/mapfinal4.png");
                break;
        }
    }
    
}
