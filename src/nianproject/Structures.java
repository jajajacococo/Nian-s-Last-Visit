package nianproject;
import processing.core.PApplet;
import processing.core.PImage;
public class Structures extends Props {
    protected int offx, offy;
    
    public Structures(PApplet app, int x, int y ){
        super(app,x,y);
        current = app.loadImage("imgs/smolhouse.png");
        offx = 15;
        offy = 30;
        width= 125;
        height=81;
}

        
   
    @Override
        public void changeProp(int sprite){
        switch (sprite){
            case 0:
                current = app.loadImage("imgs/smolhouse.png");
                offx = 15;
                offy = 30;
                width= 125;
                height=81;
                break;
            case 1:
                current = app.loadImage("imgs/storage.png");
                offx = 15;
                offy = 30;
                width= 85;
                height=75;
                break;
            case 2:
                current = app.loadImage("imgs/nightmarket.png");
                offx = 15;
                offy = 30;
                width= 60;
                height=55;
                break;
            case 3:
                current = app.loadImage("imgs/blacksmith.png");
                offx = 20;
                offy = 45;
                width= 120;
                height=100;
                break;
            case 4:
                current = app.loadImage("imgs/smolchurch.png");
                offx = 25;
                offy = 50;
                width= 95;
                height=51;
                break;
            case 5:
                current = app.loadImage("imgs/well.png");
                offx = 30;
                offy = 60;
                width= 40;
                height=25;
                break;
            case 6:
                current = app.loadImage("imgs/bighouse.png");
                offx = 30;
                offy = 40;
                width= 150;
                height=128;
                break;
            
        }
    
    }
        @Override
        public void draw(){
            app.image(current,x-offx,y-offy);
        }}