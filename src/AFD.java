
import java.util.ArrayList;
import java.util.HashMap;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roberto
 */
public class AFD {
    Thomson AFND;
    ArrayList<Integer> K;//ESTADOS
    ArrayList<String>sigma;//ALFABETO
    int s;//ESTADO INICIAL
    ArrayList<Integer>F;//ESTADO FINAL
    HashMap<Integer,ArrayList<Transition>> delta;//DELTA

    public AFD(Thomson AFND) {
        this.AFND = AFND;
    }
    
    private ArrayList<Integer> clausuraEpsilon(int s){
        ArrayList<Integer> estadoInicial = new ArrayList<>();
        estadoInicial.add(s);
        for (int i = 0; i < 10/*s.transicion.size()*/; i++) {
            
            if (true/*s.transicion.l=='_'*/) {
                if(true/*!estadoInicial.contains(s.transicion.target)*/){
                    estadoInicial.add(i/*s.transicion.target*/);
                }
            }
        }
        return estadoInicial;
    }
    
    private ArrayList<ArrayList<Integer>> conversion(ArrayList<Integer> estado, ArrayList<ArrayList<Integer>> estadosAFD){
        
    }
}
