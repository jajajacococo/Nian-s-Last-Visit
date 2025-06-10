package nianproject;
import processing.core.PApplet;
import processing.core.PImage;
public class Structures extends Props {
    protected int offx, offy;
    
    public Structures(PApplet app, int x, int y ){
        super(app,x,y);
        current = app.loadImage("imgs/smallhouse2.png");
        offx = 15;
        offy = 30;
        width= 125;
        height=81;
}
        
   
    @Override
        public void changeProp(int sprite){
        switch (sprite){
            case 0:
                current = app.loadImage("imgs/smallhouse2.png");
                offx = 15;
                offy = 30;
                width= 125;
                height=81;
                break;
            case 1:
                current = app.loadImage("imgs/shed.png");
                System.out.print("hcanged");
                offx = 15;
                offy = 30;
                width= 125;
                height=81;
                break;
            case 2:
                current = app.loadImage("imgs/marketstand.png");
                break;
            case 3:
                current = app.loadImage("imgs/forge.png");
                break;
            case 4:
                current = app.loadImage("imgs/church.png");
                break;
            case 5:
                current = app.loadImage("imgs/waterwell.png");
                break;
            
        }
    
    }
        @Override
        public void draw(){
            app.image(current,x-offx,y-offy);
        }
}
