/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import Test.GameTester;
import java.util.ArrayList;

/**
 *
 * @author david
 */

public class NapakalakiMain {
    
    public static void main(String[] args) {
        Napakalaki game = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        ArrayList<String> names;
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
        
        names = namesCapture.getNames();
        
        Dice.createInstance(napakalakiView);
        
        napakalakiView.setNapakalaki(game);
        napakalakiView.setVisible(true);
        
        GameTester test = GameTester.getInstance();

        game.initGame(names);
        
        // Poner el numero de jugadores con el que se quiera probar
        //test.play(game, 3); 
    }
    
    
}

