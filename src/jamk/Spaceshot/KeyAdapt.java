/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamk.Spaceshot;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Nissinen
 */
public class KeyAdapt extends KeyAdapter{
    
    Player pelaaja;
    
    public KeyAdapt(Player ship) {
        pelaaja = ship;
}

    public void keyPressed(KeyEvent e) {
        pelaaja.keyPressed(e);    
}

public void keyReleased (KeyEvent e) {
        pelaaja.keyReleased(e);
	}
}