
package nianproject;
import processing.core.PApplet;
import processing.core.PImage;

//u can only talk to 2 villagers and the old man
public class Villager extends Props {
    private String identity;
    private String type;
    
public Villager(PApplet app, int x, int y, String identity) {
    super(app, x, y);
    this.identity = identity;
    current = app.loadImage("imgs/oldman.png");
    width = 64;
    height = 64;
}

public Villager(PApplet app, int x, int y) {
    super(app, x, y);
    current = app.loadImage("imgs/vil2.png");
    width = 64;
    height = 64;
}

public Villager(PApplet app,int x, int y, String type, String identity) {
    super(app, x, y);
        this.identity = identity;
    this.type = type;
    width = 64;
    height = 64;
    current = app.loadImage("imgs/vil1.png");
}   

public void drawHitbox() {
    app.noFill();
    app.stroke(0, 255, 0); // Green outline
    app.rect(x, y, width, height);}

    @Override
        public void changeProp(int sprite){
        switch (sprite){
            case 0:
                current = app.loadImage("imgs/oldman.png");
                
                break;
            case 1:
                current = app.loadImage("imgs/vil1.png");
                break;
            case 2:
                current = app.loadImage("imgs/vil2.png");
                break;
        
        }
    }
        @Override
        public void draw(){
            app.image(current,x,y,64,64);
        }}