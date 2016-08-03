/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamk.Spaceshot;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Nissinen
 */
public class Player extends Entity {
    
    //pelaajan x ja y akseli
    int velX = 0;
    int velY = 0;
    int speed = 3;
    
    public Player ( int x , int y) {
        super(x, y);
        
    }
    //päivittää x ja y coordinaatit
    public void update () {
        x = x + velX;
        y = y +velY;
        
        checkCollision();
    }
    public void draw(Graphics2D g2d) {
        g2d.drawImage(getPlayerImg(), x, y, null);
        /*tekee rajat testaukseen
        g2d.draw (getBounds());
                */
    }
    
    // hakee iconin kyseisellä metodilla
    public Image getPlayerImg(){
          ImageIcon ic = new ImageIcon("resources/Player.png");
        return ic.getImage();
    }
    
    //mitä tapahtuu kun nappulaa painetaan tee offscreen metodi joka palauttaa aluksen alkupisteeseen sen ylittäessä rajat.
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
            
          
        if (key == KeyEvent.VK_LEFT){
                //märää nopeuden
                velX = -speed; 
                //pysäyttää välillä
                if ( x<10) {
                    velX = 0;
                }      
            }

            else if (key == KeyEvent.VK_RIGHT){
                velX = speed;
                //pysäyttää välillä
                        if ( x>550) {
                    velX = 0;
                        }
            }
            else if (key == KeyEvent.VK_UP){
                //märää nopeuden
                velY = -speed; 
                if ( x>540 || x<10) {
                    velX = 0;
                }
            }
            else if (key == KeyEvent.VK_DOWN){
                velY = speed;
                if ( x>540 || x<10) {
                    velX = 0;
                }
            }
            else if (key == KeyEvent.VK_SPACE){
                GameFrame.addBomb(new Bomb(x, y));
                if ( x>540 || x<10) {
                    velX = 0;
                   }
            }
    } 
   
    //mitä tapahtuu kun nappula vapautetaan
    public void keyReleased(KeyEvent e) {
      int key = e.getKeyCode();
            
            if (key == KeyEvent.VK_LEFT){
                
                velX = 0;
            }
            else if (key == KeyEvent.VK_RIGHT){
                velX = 0;
       }
            else if (key == KeyEvent.VK_UP){
                velY = 0;
       }

            else if (key == KeyEvent.VK_DOWN){
                velY = 0;
       }
    }
            public void checkCollision(){
               ArrayList<Enemy> enemies = GameFrame.getEnemyList();
               
               for (int i = 0; i < enemies.size(); i++) {
                Enemy tempEnemy = enemies.get(i);
                if (getBounds().intersects(tempEnemy.getBounds())){
                    JOptionPane.showMessageDialog(null,"Game over! Your score was, pistä score");
                    System.exit(0);                   
                }
            }
          }
                
            public Rectangle getBounds() {
                return new Rectangle(x,y, getPlayerImg().getWidth(null), getPlayerImg().getHeight(null));
            }
}


