
package nianproject;
import processing.core.PApplet;
import processing.core.PImage;

//u can only talk to 2 villagers and the old man
public class Villager extends Props {
    private String identity;
    private String type;
    private int offx, offy;
    
public Villager(PApplet app, int x, int y, String identity) {
    super(app, x, y);
    this.identity = identity;
    current = app.loadImage("imgs/oldman.png");
}

public Villager(PApplet app, int x, int y) {
    super(app, x, y);
    this.identity = "vil2";
    current = app.loadImage("imgs/vil2.png");
}

public Villager(PApplet app,int x, int y, String type, String identity) {
    super(app, x, y);
    this.identity = identity;
    this.type = type;
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
                width = 32;
                height = 52;
                offx = -16;
                offy=-5;
                break;
            case 1:
                current = app.loadImage("imgs/vil1.png");
                width = 32;
                height = 52;
                offx = -16;
                offy=-5;
                break;
            case 2:
                current = app.loadImage("imgs/vil2.png");
                width = 32;
                height = 52;
                offx = -16;
                offy=-5;
                break;
        
        }
    }
        @Override
        public void draw(){
            if (identity.equals("v1")) {
                app.image(current,x+offx,y+offy,66,70);
            } else {
                app.image(current,x+offx,y+offy,64,64);
            }
        }}