
package nianproject;
import processing.core.PApplet;
import processing.core.PImage;

public class Character {
    private int x,y;
    private PApplet app;
    private String direction;
    private String lastdirection = "down";
    
    
    private PImage didle,widle,ridle,lidle;
    private PImage current;
    private PImage[] downwalk, upwalk,rwalk,lwalk;
    private int frame, frameside;
    private int tick, tickside;
    
    public Character(PApplet app, int x,int y){
        this.app = app;
        this.x = x;
        this.y = y;
        
        didle = app.loadImage("imgs/yDidle.png");
        downwalk = new PImage[] {app.loadImage("imgs/ydown.png"),app.loadImage("imgs/ydown2.png")};
        widle = app.loadImage("imgs/ywidle.png");
        upwalk = new PImage[] {app.loadImage("imgs/yup.png"),app.loadImage("imgs/yup2.png")};
        ridle = app.loadImage("imgs/yridle.png");
        rwalk = new PImage[] {app.loadImage("imgs/yright.png"),app.loadImage("imgs/yright2.png")};
        lidle = app.loadImage("imgs/ylidle.png");
        lwalk = new PImage[] {app.loadImage("imgs/yleft.png"),app.loadImage("imgs/yleft2.png")};
        frame = 0;
        frameside = 0;
        tick = 0;
        tickside=0;
    }
    
    public void move(int dx, int dy){
        x += dx;
        y += dy; 
        
        if (dy<0){ 
            direction="up";
            lastdirection = direction;
        }
        else if (dy>0) { 
            direction="down";
            lastdirection = direction;
        }
        else if (dx<0) {
            direction = "left";
            lastdirection = direction;
        }
        else if (dx>0) {
            direction = "right";
            lastdirection = direction;
        }
        else {
            direction = "idle";
            frame = 0;
            tick = 0;
        }
     
    }
    
    
    public void draw(){
  
        
        if (!direction.equals("idle")){
            tick++;
            tickside++;
            if (tickside>=10){
                frameside = (frameside + 1) % 2;
                tickside = 0;
            }
            if (tick >= 15){
                frame = (frame + 1) % 2;
                tick = 0;
            }
            
            switch (direction) {
                case "down":
                    current = downwalk[frame];
                    break;
                case "up":
                    current = upwalk[frame];
                    break;    
                case "right":
                    current = rwalk[frameside];
                    break;  
                case "left":
                    current = lwalk[frameside];
                    break;
            }
        
        } else {
                switch (lastdirection) {
                case "down":
                    current = didle;
                    break;
                case "up":
                    current = widle;
                    break;    
                case "right":
                    current = ridle;
                    break;  
                case "left":
                    current = lidle;
                    break;
            }
            
        
        }
        app.image(current,x,y,64,64);
    }
    
}
