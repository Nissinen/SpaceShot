/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamk.Spaceshot;

import java.awt.Graphics2D;

/**
 *
 * @author Nissinen
 */
public class Entity {
    
    int x, y;
    
    public Entity(int x,int y) {
        this.x = x;
        this.y = y;
    }
    
    public void update() {
        
    }
    public void draw(Graphics2D g2d) {
        
    }
    public int getLocation(){
        return this.x + this.y;
    }
    
}
