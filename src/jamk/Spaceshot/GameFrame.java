/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamk.Spaceshot;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Nissinen
 */
public class GameFrame extends JPanel implements ActionListener{
    
    Timer mainTimer;
   Player player;
   
   int enemyCount = 5;
   int level = 1;
    //luodaan taulukko vihollisille
  static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  static ArrayList<Bomb> bombs = new ArrayList<Bomb>();
  Random rand = new Random();
   
    public GameFrame() {
        setFocusable(true);
        
        player = new Player(300,700);
        
        addKeyListener(new KeyAdapt(player));
       
        //lisätään olioita taulukkoon
        mainTimer = new Timer(10, this);
        mainTimer.start();
      
        startGame();
    }
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
        ImageIcon ic = new ImageIcon("resources/Background.png");
        g2d.drawImage(ic.getImage(),0,0,null);
        
        player.draw(g2d);
        
        //tulostetaan piikit ja piirretään näytölle
        for (int i = 0; i < enemies.size(); i++) {
            Enemy tempEnemy = enemies.get(i);
            tempEnemy.draw(g2d);
        }
        for (int i = 0; i < bombs.size(); i++) {
            Bomb tempBomb = bombs.get(i);
            tempBomb.draw(g2d);
        }
        
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent ae) {
       repaint();
       player.update();
       
       for(int i = 0; i< enemies.size(); i++) {
           Enemy tempEnemy = enemies.get(i);
           tempEnemy.update();
       }
       for (int i = 0; i < bombs.size(); i++) {
            Bomb tempBomb = bombs.get(i);
            tempBomb.update();
        }
       
       checkEnd();
       
    }
    public static void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }
    
    public static void removeEnemy(Enemy enem){
        enemies.remove(enem);
    }
 
    //static myös taulukkoon!
    public static ArrayList<Enemy> getEnemyList(){
        return enemies;
    }
    public static void addBomb(Bomb bomb) {
        bombs.add(bomb);
    }
    
    public static void removeBomb(Bomb bomb){
        bombs.remove(bomb);
    }
 
    //static myös taulukkoon!
    public static ArrayList<Bomb> getBombList(){
        return bombs;
    }
    public void startGame () {
        enemyCount = level * 5;
        
         for (int i = 0; i < enemyCount; i++) {
            addEnemy(new Enemy(rand.nextInt(550), -10 + -rand.nextInt(800)));
        }   
       }
         public void checkEnd (){
             if (enemies.size() == 0){
                 level++;
                 enemyCount = enemyCount + 5;
                 enemies.clear();
                 bombs.clear();
                 JOptionPane.showMessageDialog(null,"Next level");
                 startGame();
             }
    }
}


