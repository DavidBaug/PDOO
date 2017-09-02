/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author david
 */
public class DeathBadConsequence extends NumericBadConsequence{
    boolean death;
    
    public DeathBadConsequence(String text, boolean death) {
        super(text);
        this.death = death;
    }
    
    @Override
    public boolean isDeath(){
        return this.death;
    }
    
    @Override
    public boolean isEmpty(){   
        return true;
    }

    @Override
    public void cuantoMalRollo(){
        if(isEmpty())
            System.out.println("Has muerto, Mal rollo cumplido");
        else
            System.out.println("Mal rollo no cumplido");
    }
}
