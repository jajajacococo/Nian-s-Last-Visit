/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nianproject;

import processing.core.PApplet;

/**
 *
 * @author nz090
 */
public class Item extends Props{
    protected int offx, offy;
    
    public Item(PApplet app, int x, int y ){
        super(app,x,y);
        current = app.loadImage("imgs/rcloth2.png");
}
    public void drawHitbox() {
    app.noFill();
    app.stroke(0, 255, 0); // Green outline
    app.rect(x, y, width, height);}

        
   
    @Override
        public void changeProp(int sprite){
        switch (sprite){
            case 0:
                current = app.loadImage("imgs/rcloth2.png");
                offx =3 ;
                offy = 10;
                width= 32;
                height= 20;
                break;
            case 1:
                current = app.loadImage("imgs/rlantern.png");
                offx =10 ;
                offy = 5;
                width= 32;
                height= 30;
                break;
            case 2:
                current = app.loadImage("imgs/rsuit.png");
                offx =12 ;
                offy = 5;
                width= 35;
                height= 50;
                break;
            case 3:
                current = app.loadImage("imgs/candle.png");
                offx =15 ;
                offy = 15;
                width= 19;
                height= 29;
                break;
            case 4:
                current = app.loadImage("imgs/candle2.png");
                offx =15 ;
                offy = 15;
                width= 18;
                height= 29;
                break;
            case 5:
                current = app.loadImage("imgs/fcracker.png");
                offx =5 ;
                offy = 5;
                width= 40;
                height= 40;
                break;
        }
    
    }
        @Override
        public void draw(){
            app.image(current,x-offx,y-offy);
        }
}
