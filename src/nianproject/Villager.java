
package nianproject;
import processing.core.PApplet;
import processing.core.PImage;

//u can only talk to 2 villagers and the old man
public class Villager extends Props {
    private String identity;
    
    public Villager(PApplet app, int x, int y, String identity ){
        super(app,x,y);
        this.identity = identity;
        current = app.loadImage("imgs/oldman.png");
        
    
    }
    @Override
        public void changeProp(int sprite){
        switch (sprite){
            case 0:
                current = app.loadImage("imgs/oldman.png");
                break;
            case 1:
                current = app.loadImage("imgs/shed.png");
                break;
            case 2:
                current = app.loadImage("imgs/marketstand.png");
                break;
            case 3:
                current = app.loadImage("imgs/house.png");
                break;
            case 4:
                current = app.loadImage("imgs/forge.png");
                break;
            case 5:
                current = app.loadImage("imgs/church.png");
                break;
            case 6:
                current = app.loadImage("");
                break;
            case 7:
                current = app.loadImage("");
                break;
            case 8:
                current = app.loadImage("");
                break;
            case 9:
                current = app.loadImage("");
                break;
            case 10:
                current = app.loadImage("");
                break;
            case 11:
                current = app.loadImage("");
                break;
        
        }
    
    }
        @Override
        public void draw(){
            app.image(current,x,y,64,64);
        }}