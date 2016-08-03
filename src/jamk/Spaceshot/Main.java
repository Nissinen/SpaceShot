   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamk.Spaceshot;

import javax.swing.JFrame;

/**
 *
 * @author Nissinen
 */


//Luo ikkunan
public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("Spaceshot");
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new GameFrame());
        frame.setVisible(true);
    }
}
