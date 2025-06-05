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
public class Props {
    protected int x,y;
    private static int numofprops;
    protected PImage current;
    protected PApplet app;      
    
    public Props(PApplet app, int x, int y){
        this.app=app;
        this.x=x;
        this.y=y;
        numofprops++;
       
    }
  
       
    public void changeProp(int sprite){
        System.out.println("Changed Prop to" + sprite);
    }
}

