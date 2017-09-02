/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 *
 * @author user
 */
public class CardDealer {
   
    private static final CardDealer instance = new CardDealer();
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Cultist> unusedCultist;
    private ArrayList<Cultist> usedCultist;
    
    private CardDealer() { 
        unusedTreasures = new ArrayList<>();
        usedTreasures = new ArrayList<>();
        unusedMonsters = new ArrayList<>();
        usedMonsters = new ArrayList<>();
        unusedCultist = new ArrayList<>();
        usedCultist = new ArrayList<>();
        
     }
    
    public static CardDealer getInstance() {
        return instance;
    }
    
    public void initTreasureCardDeck(){
        //¡Si, mi amo!
        Treasure t = new Treasure("¡Si, mi amo!", 4, TreasureKind.HELMET,"si");
        unusedTreasures.add(t);
        
        //Botas de investigación
        t = new Treasure("Botas de investigación", 3, TreasureKind.SHOES,"investiga");
        unusedTreasures.add(t);
        
        //Capucha de Cthulhu
        t = new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET,"capucha");
        unusedTreasures.add(t);
        
        //A prueba de balas
        t = new Treasure("A prueba de babas", 2, TreasureKind.ARMOR,"babas");
        unusedTreasures.add(t);
        
        //Botas de lluvia ácida
        t = new Treasure("Botas de lluvia ácida", 1, TreasureKind.BOTHHANDS,"botaslluvia");
        unusedTreasures.add(t);
        
        //Casco minero
        t = new Treasure("Casco minero", 2, TreasureKind.HELMET,"cascominero");
        unusedTreasures.add(t);
        
        //Ametralladora ACME
        t = new Treasure("Ametralladora ACME", 4, TreasureKind.BOTHHANDS,"acme");
        unusedTreasures.add(t);
        
        //Camiseta de la ETSIIT
        t = new Treasure("Camiseta de la ETSIIT", 1, TreasureKind.ARMOR,"etsiit");
        unusedTreasures.add(t);
        
        //Clavo de rail ferroviario
        t = new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND,"clavorail");
        unusedTreasures.add(t); 
        
        //Cuchillo de sushi arcano
        t = new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND,"shushi");
        unusedTreasures.add(t);
        
        //Fez alópodo
        t = new Treasure("Fez alópodo", 3, TreasureKind.HELMET,"fez");
        unusedTreasures.add(t);
        
        //Hacha prehistórica
        t = new Treasure("Hacha prehistorica", 2, TreasureKind.ONEHAND,"fez");
        unusedTreasures.add(t);
        
        //El aparato del Pr. Tesla
        t = new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR,"tesla");
        unusedTreasures.add(t);
       
        //Gaita
        t = new Treasure("Gaita", 4, TreasureKind.BOTHHANDS,"gaita");
        unusedTreasures.add(t);
        
        //Insecticida
        t = new Treasure("Insecticida", 2, TreasureKind.ONEHAND,"insecticida");
        unusedTreasures.add(t);
        
        //Escopeta de tres cañones
        t = new Treasure("Escopeta de tres cañones", 4, TreasureKind.BOTHHANDS,"escopeta");
        unusedTreasures.add(t);
        
        //Garabato místico
        t = new Treasure("Garabato mistico", 2, TreasureKind.ONEHAND,"garabato");
        unusedTreasures.add(t);
        
        //La rebeca metalica
        t = new Treasure("La rebeca metalica", 2, TreasureKind.ARMOR,"rebeca");
        unusedTreasures.add(t);
        
        //Lanzallamas
        t = new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS,"lanzallamas");
        unusedTreasures.add(t);
        
        //Necro-comicón
        t = new Treasure("Necro-comicon", 1, TreasureKind.ONEHAND,"comicon");
        unusedTreasures.add(t);
        
        //Necronomicón
        t = new Treasure("Necronomicon", 5, TreasureKind.BOTHHANDS,"necronomicon");
        unusedTreasures.add(t);
        
        //Linterna a dos manos
        t = new Treasure("Linterna a dos manos", 3, TreasureKind.BOTHHANDS,"linterna");
        unusedTreasures.add(t);
        
        //Necro-gnomicón
        t = new Treasure("Necro-gnomicon", 2, TreasureKind.ONEHAND,"nomicon");
        unusedTreasures.add(t);
        
        //Necrotelecom
        t = new Treasure("Necrotelecom", 2, TreasureKind.HELMET,"telecom");
        unusedTreasures.add(t);
        
        //Mazo de los antiguos
        t = new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND,"mazo");
        unusedTreasures.add(t);
        
        //Necro-playboycón
        t = new Treasure("Necro-playboycon", 3, TreasureKind.ONEHAND,"playboy");
        unusedTreasures.add(t);
        
        //Porra preternatural
        t = new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND,"porra");
        unusedTreasures.add(t);
        
        //Shogulador
        t = new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS,"shogulator");
        unusedTreasures.add(t);
        
        //Varita de atizamiento
        t = new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND,"varita");
        unusedTreasures.add(t);
        
        //Tentáculo de pega
        t = new Treasure("Tentaculo de pega", 2, TreasureKind.HELMET,"tentaculo");
        unusedTreasures.add(t);
        
        //Zapato deja-amigos
        t = new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES,"zapato");
        unusedTreasures.add(t);
        
        shuffleTreasures();
          
    }
    
    public void initMonsterCardDeck(){
        
        //3 Byakhees de bonanza
        BadConsequence bc = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize p = new Prize(2,1);
        Monster m = new Monster("3 Byakhees de bonanza", 8, p, bc,1);
        unusedMonsters.add(m);
        
        //Tenochtitlan
        bc = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        p = new Prize(1,1);
        m = new Monster("Tenochtitlan", 2, p, bc,23);
        unusedMonsters.add(m);
        
        //El sopor de Dunwich
        bc = new SpecificBadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0,  new ArrayList(Arrays.asList(TreasureKind.SHOES)),  new ArrayList(Arrays.asList()));
        p = new Prize(1,1);
        m = new Monster("El sopor de Dunwich", 2, p, bc,10);
        unusedMonsters.add(m);
        
        //Demonios de Magaluf
        bc = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo" +
                 "Descarta 1 mano visible y 1 mano oculta",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        p = new Prize(4,1);
        m = new Monster("Demonios de Magaluf", 2, p, bc,4);
        unusedMonsters.add(m);
        
        //El Gorrón en el Umbral
        bc = new NumericBadConsequence("Pierdes todos tus tesoros visibles", 0, BadConsequence.MAXTREASURES, 0);
        p = new Prize(3,1);
        m = new Monster("El Gorron en el Umbral", 13, p, bc,6);
        unusedMonsters.add(m);

        //H.P. Munchcraft
        bc = new SpecificBadConsequence("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        p = new Prize(2,1);
        m = new Monster("H.P. Munchcraft", 6, p, bc,14);
        unusedMonsters.add(m);
        
        //Necrofago
        bc = new SpecificBadConsequence("Sientes bichos bjo la ropa. Descarta la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        p = new Prize(1,1);
        m = new Monster("Necrofago", 13, p, bc,17);
        unusedMonsters.add(m);
        
        //El rey de rosado
        bc = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        p = new Prize(4,2);
        m = new Monster("El rey de rosado", 11, p, bc,9);
        unusedMonsters.add(m);
        
        //Flecher
        bc = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles.",2,0,0);
        p = new Prize(1,1);
        m = new Monster("Flecher",2,p,bc,13);
        unusedMonsters.add(m);
        
        //Los Hondos
        bc = new DeathBadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto.",true);
        p = new Prize(2,1);
        m = new Monster("Los Hondos",8,p,bc,16);
        unusedMonsters.add(m);
        
        //Semillas Cthulhu
        bc = new NumericBadConsequence("Pierdas 2 niveles y 2 tesoros ocultos.",2,0,2);
        p = new Prize(2,1);
        m = new Monster("Semillas Cthulhu",4, p, bc,20);
        unusedMonsters.add(m);
        
        //Dameargo
        bc = new SpecificBadConsequence("Te intas escaquear. Pierdes una mano visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList()));
        p = new Prize(2,1);
        m = new Monster("Dameargo", 1, p, bc,3);
        unusedMonsters.add(m);
        
        //Pollipolipo volante
        bc = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles",3,0,0);
        p = new Prize(2,1);
        m = new Monster("Pollipolipo volante", 3, p, bc,18);
        unusedMonsters.add(m);
        
        //Yskhtihyssg Goth
        bc = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre" +
                "Estas muerto", true);
        p = new Prize(3,1);
        m = new Monster("Yskhtihyssg Goth", 14, p, bc,26);
        unusedMonsters.add(m);
        
        //Familia feliz
        bc = new DeathBadConsequence("La familia te atrapa. Estas muerto", true);
        p = new Prize(3,1);
        m = new Monster("Familia feliz", 1, p, bc,11);
        unusedMonsters.add(m);
        
        //Roboggoth
        bc = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro a 2 manos visible.",2,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),new ArrayList(Arrays.asList()));
        p = new Prize(2,1);
        m = new Monster("Roboggoth",8,p,bc,19);
        unusedMonsters.add(m);
        
        
        //El Espia Sordo
        bc = new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        p = new Prize(1,1);
        m = new Monster("El espia sordo", 5, p, bc,5);
        unusedMonsters.add(m);
        
        //Tongue
        bc = new NumericBadConsequence("Menudo susto te llevas. Pierdes dos niveles y "+
                "5 tesoros visibles", 2,5,0);
        p = new Prize(2,1);
        m = new Monster("Tongue", 19, p, bc,25);
        unusedMonsters.add(m);
        
        //Bicefalo
        bc = new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.",
         3,
         new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)),
         new ArrayList());
        p = new Prize(2,1);
        m = new Monster("Bicefalo", 21, p, bc,2);
        unusedMonsters.add(m);
        
        
        shuffleMonsters();

    }
    
    private void initCultistCardDeck(){
        unusedCultist.add(new Cultist("Sectario",1));
        unusedCultist.add(new Cultist("Sectario",2));
        unusedCultist.add(new Cultist("Sectario",1));
        unusedCultist.add(new Cultist("Sectario",2));
        unusedCultist.add(new Cultist("Sectario",1));
        unusedCultist.add(new Cultist("Sectario",1));
    }
    
    private void shuffleCultists(){
        Collections.shuffle(unusedCultist);
    }
    
    public Cultist nextCultist(){
        Cultist c;
        if(unusedCultist.isEmpty()){
            for(Cultist uc:usedCultist)
                unusedCultist.add(uc);
            usedCultist.clear();
            this.shuffleCultists();
        }
        return unusedCultist.remove(0);
    }
    
    public void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    
    public void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    
    public Treasure nextTreasure(){
        Treasure t;
        if(unusedTreasures.isEmpty()){
            for(Treasure ut:usedTreasures)
                unusedTreasures.add(ut);
            usedTreasures.clear();
            this.shuffleTreasures();
        }
        return unusedTreasures.remove(0);
    }
    
    public Monster nextMonster(){
        Monster m;
        if(unusedMonsters.isEmpty()){
            for(Monster um:usedMonsters)
                unusedMonsters.add(um);
            usedMonsters.clear();
            this.shuffleMonsters();
        }
        return unusedMonsters.remove(0);
        /*Monster m;
        if(unusedMonsters.isEmpty()){
            rebuildMonster();
           
            m = unusedMonsters.get(0);
            
            usedMonsters.add(m);
            unusedMonsters.remove(m);
            
            m=usedMonsters.get(0);
            
        }else{
            m = unusedMonsters.get(0);
            
            usedMonsters.add(m);
            unusedMonsters.remove(m);
            
            m=usedMonsters.get(0);
        }
        
        return m;*/
    }
    
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    
  
    public void initCards(){
        initTreasureCardDeck();
        initMonsterCardDeck();
        initCultistCardDeck();
        shuffleCultists();
        shuffleTreasures();
        shuffleMonsters();
    }
    
    
    
    
}
