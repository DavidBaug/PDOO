/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author user
 */
public abstract class BadConsequence {
/*
    
    private String text;
    private int levels ;
    private int nVisibleTreasures;
    private int nHiddenTreasures ;
    private  boolean death;

    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList<>();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList<>();
    
    @Override
    public String toString() {
        return "BadConsequence{" + "text=" + text + ", levels=" + levels + ", nVisibleTreasures=" + nVisibleTreasures + ", nHiddenTreasures=" + nHiddenTreasures + ", death=" + death + ", specificHiddenTreasures=" + specificHiddenTreasures + ", specificVisibleTreasures=" + specificVisibleTreasures + '}';
    }

    public String getText() {
        return text;
    }

    public int getLevels() {
        return levels;
    }

    public int getnVisibleTreasures() {
        return nVisibleTreasures;
    }

    public int getnHiddenTreasures() {
        return nHiddenTreasures;
    }

    public boolean isDeath() {
        return death;
    }

    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.levels = levels;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
    }
    public BadConsequence(String text, boolean death){
        this.text = text;
        this.death = death;
        levels = Player.MAXLEVEL;
        nVisibleTreasures = MAXTREASURES;
        nHiddenTreasures = MAXTREASURES;
    }

    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,
    ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;
        specificHiddenTreasures = tHidden;
        specificVisibleTreasures = tVisible;
    }
    
    
    public void substractVisibleTreasure(Treasure t){
        if(nVisibleTreasures!=0)
            nVisibleTreasures--;
        else if(!specificVisibleTreasures.isEmpty())
            specificVisibleTreasures.remove(t.getType());   
    }
    
    public void substractHiddenTreasure(Treasure t){
        if(nHiddenTreasures!=0)
            nHiddenTreasures--;
        else if(!specificHiddenTreasures.isEmpty())
            specificHiddenTreasures.remove(t.getType());   
    }
    
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h){
        BadConsequence bc = new BadConsequence(text,death);
        
        ArrayList<TreasureKind> playerV = new ArrayList<>();
        ArrayList<TreasureKind> playerH = new ArrayList<>();
        ArrayList<TreasureKind> specificV = new ArrayList<>(specificVisibleTreasures);
        ArrayList<TreasureKind> specificH = new ArrayList<>(specificHiddenTreasures);

        //Copiamos el tipo de los tesoros del jugador y de bc
        for(Treasure t:v){
            playerV.add(t.getType());
        }
        for(Treasure t:h){
            playerH.add(t.getType());
        }
        
        //Ajustamos el tamaño de la bc
        if(nVisibleTreasures>=playerV.size()){ bc.nVisibleTreasures=playerV.size(); }  
        else{ bc.nVisibleTreasures=nVisibleTreasures;}
        
        if(nHiddenTreasures>=playerH.size()){ bc.nHiddenTreasures=playerH.size(); }  
        else{ bc.nHiddenTreasures=nHiddenTreasures;}
        
        
        //Ajustamos la bc respecto al jugador
        if(!specificVisibleTreasures.isEmpty()){
            boolean encontrado;
            for(TreasureKind tks:specificV){
                encontrado = false;
                for(TreasureKind tkp:playerV){
                    if(tks==tkp && !encontrado){
                        bc.specificVisibleTreasures.add(tkp);
                        playerV.remove(tkp);
                        encontrado=true;
                    }
                }
            }
        }
        
        if(!specificHiddenTreasures.isEmpty()){
            boolean encontrado;
            for(TreasureKind tks:specificH){
                encontrado = false;
                for(TreasureKind tkp:playerH){
                    if(tks==tkp && !encontrado){
                        bc.specificHiddenTreasures.add(tkp);
                        playerH.remove(tkp);
                        encontrado=true;
                    }
                }
            }
        }

        return bc;
    } */
    
    static final int MAXTREASURES = 10;
    private String text;
    private int levels;  
    
    public BadConsequence(String text, int levels){
        this.text=text;
        this.levels=levels;
    }
    
    public BadConsequence(String text){
        text=text;
    }
    
    public BadConsequence(BadConsequence bc){
        text=bc.getText();
        levels=bc.getLevels();
    }
        
    public String getText(){
        return text;
    }
    public int getLevels(){
        return levels;
    }
    
//    public boolean getDeath(){
//        return false;
//    }    

//    public boolean isEmpty(){   
//        boolean resultado=false;
//        
//        if(text=="Error text vacio"){
//            resultado=true;
//        }
//
//        return resultado;
//    }
   
//    public void cuantoMalRollo(){
//        if(isEmpty())
//            System.out.println("Mal rollo cumplido");
//        else
//            System.out.println("Mal rollo no cumplido");
//    }
    
    public abstract BadConsequence adjustToFitTreasureList(ArrayList<Treasure> visibleTreasures, ArrayList<Treasure> hiddenTreasures);
    public abstract int getNVisibleTreasures();
    public abstract int getNHiddenTreasures();
    public abstract boolean isDeath();
    public abstract ArrayList<TreasureKind> getSpecificHiddenTreasures();
    public abstract ArrayList<TreasureKind> getSpecificVisibleTreasures();
    public abstract void substractHiddenTreasure(Treasure t);
    public abstract void substractVisibleTreasure(Treasure t);
    public abstract boolean isEmpty();


    
}
