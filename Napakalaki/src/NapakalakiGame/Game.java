/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import napakalaki.Dice;
import napakalaki.Napakalaki;
import GUI.*;
import java.util.ArrayList;
import napakalaki.*;


public class Game {
    public static void main(String[] args){
        ArrayList<String> names;
        
        Napakalaki game = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        
        Dice.createInstance(napakalakiView);
       
  
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
        names = namesCapture.getNames();
        
        game.initGame(names);
        napakalakiView.setNapakalaki(game); 
        napakalakiView.setVisible(true);        
    }
}
