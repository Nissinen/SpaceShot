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
public class Enemy extends Entity {

    private int startY;
    
    public Enemy(int x, int y) {
        super(x, y);
        startY = y;
    }
    public void update() {
        y = y+2;
        checkCollision();
        checkOffScreen();
    }
    public void draw(Graphics2D g2d) {
        g2d.drawImage(getEnemyImg(), x, y, null);
        
        /* testaa tällä osuvatko collision rajat testauksessa
        g2d.draw (getBounds());
        */
    }
        // hakee iconin kyseisellä metodilla
    public Image getEnemyImg(){
          ImageIcon ic = new ImageIcon("resources/Enemy.png");
        return ic.getImage();
    }
    public void checkCollision(){
        for (int i = 0; i< GameFrame.getBombList().size(); i++){
            Bomb bomb = GameFrame.getBombList().get(i);
            
            if (getBounds().intersects(bomb.getBounds())){
            GameFrame.removeEnemy(this);
            GameFrame.removeBomb(bomb);
        }
        }
    }
    
    public void checkOffScreen(){
        if (y >= 880){
            System.exit(0); //jos mobi menee läpi
         
          //y =startY;
        }
    }
    public Rectangle getBounds() {
                return new Rectangle(x,y, getEnemyImg().getWidth(null), getEnemyImg().getHeight(null));
            }
}
