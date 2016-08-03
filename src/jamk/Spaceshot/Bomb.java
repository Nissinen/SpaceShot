/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamk.Spaceshot;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Nissinen
 */
public class Bomb extends Entity {

    public Bomb(int x, int y) {
        super(x, y);
    }
    public void update() {
        y = y-3;
    }
    public void draw (Graphics2D g2d) {
        g2d.drawImage(getBombImg(), x+12, y-20, null);
    }
    public Image getBombImg(){
          ImageIcon ic = new ImageIcon("resources/Bomb.png");
        return ic.getImage();
    }
    public Rectangle getBounds() {
                return new Rectangle(x,y, getBombImg().getWidth(null), getBombImg().getHeight(null));
            }
}
