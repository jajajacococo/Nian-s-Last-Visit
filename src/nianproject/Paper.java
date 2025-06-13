/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nianproject;

import processing.core.PApplet;
import java.util.*;
import java.io.*;
/**
 *
 * @author Jacob Zheng
 */
public class Paper extends Item{
 private Scanner read;
 private String[] paper = new String[3];
 protected String text;
 private String placeholder;
 private int index=0;
    
public Paper(PApplet app, int x, int y, int index ){
        super(app,x,y);
        current = app.loadImage("imgs/paper.png");
        text = read(index).replace("\\n", "\n");
        
}

    public void drawHitbox() {
    app.noFill();
    app.stroke(0, 255, 0); // Green outline
    app.rect(x, y, width, height);}
    
    public String read(int ind){
        try {
            read = new Scanner(new File("papers.txt"));
            
            while(read.hasNext()){
                placeholder = read.nextLine();
                paper[index] = placeholder;
                index++;
            }
        } catch(IOException e){
            System.out.print("error");
        }
        return paper[ind];
    }
    
    @Override
        public void changeProp(int sprite){
        switch (sprite){
            case 0:
                current = app.loadImage("imgs/paper.png");
                offx =3 ;
                offy = 10;
                width= 32;
                height= 20;
                break;
        }
    
    }
        @Override
        public void draw(){
            app.image(current,x-offx,y-offy);
        }
}
