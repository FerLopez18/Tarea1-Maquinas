
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernanda
 */
public class Thomson {

    private ArrayList<Integer> K;
    private ArrayList<Character>sigma;
    private int s;
    private ArrayList<Integer>F;
    private HashMap<Integer,ArrayList<Transition>> delta;

    Thomson(char c) {
        this.K = new ArrayList<>();
        this.sigma = new ArrayList<>();
        this.F = new ArrayList<>();
        this.delta = new HashMap<>();
        this.construirThc(c);
        this.imprimirThc();
    }

    Thomson(Thomson pop, Thomson pop0, char op) {
        if(op =='|'){
            System.out.println("or");
            this.construirThOr(pop, pop0);
        }
        else{
            this.construirThConc(pop, pop0);
        }
    }
    
    Thomson(Thomson pop){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }
    
    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int sizeF() {
        return F.size();
    }

    public Integer getF(int index) {
        return F.get(index);
    }

    public boolean addF(Integer e) {
        return F.add(e);
    }

    public Integer removeF(int index) {
        return F.remove(index);
    }

    public int sizeK() {
        return K.size();
    }

    public Integer getK(int index) {
        return K.get(index);
    }

    public boolean addK(Integer e) {
        return K.add(e);
    }

    public Integer setK(int index, Integer element) {
        K.set(index, element);
        if(s==index){
            s = element;
        }
        
        for (int i = 0; i < this.sizeF(); i++) {
            if(this.getF(i) == index){
                F.set(i, element);
            }
            
        }
        
        for (int i = 0; i < this.delta.size(); i++) {
            if(delta.get(i)!=null){
                for (Transition transition : delta.get(i)) {
                    if(transition.getTarget() == index){
                        transition.setTarget(element);
                    }
                }
                this.delta.put(element, delta.get(i));
                delta.remove(index);
            }
            
        }
        return 1;
    }
    
    public Integer removeK(int index) {
        return K.remove(index);
    }

    public int sizesigma() {
        return sigma.size();
    }

    public Character getSigma(int index) {
        return sigma.get(index);
    }

    public boolean addSigma(Character e) {
        return sigma.add(e);
    }

    public Character removeSigma(int index) {
        return sigma.remove(index);
    }

    private void construirThc(char c) {
        this.K.add(0);
        this.K.add(1);
        this.sigma.add(c);
        this.s = 0;
        this.F.add(1);
        ArrayList<Transition> t=new ArrayList<>();
        t.add(new Transition(c,1));
        this.delta.put(0, t);
    }
    
    public void imprimirThc(){
        System.out.print("K={");
        for (int i = 0; i < K.size(); i++) {
            if(i==K.size()-1){
                System.out.print(K.get(i));
            }
            else{
                System.out.print(K.get(i)+",");
            }
                
        }
        System.out.println("}");

        System.out.print("Sigma={");
        for (int i = 0; i < this.sigma.size(); i++) {
            if(i==this.sigma.size()-1){
                System.out.print(this.sigma.get(i));
            }
            else{
                System.out.print(this.sigma.get(i)+",");
            }
                
        }
        System.out.println("}");
        System.out.println("Delta:");
        
        for (int i = 0; i < this.delta.size(); i++) {
            ArrayList<Transition> transition = delta.get(i);
            if(transition !=null){
                for (Transition transition1 : transition) {
                System.out.println("(q"+i+","+transition1.getL()+ ",q"+transition1.getTarget()+")");
            }
                
            }
            
            
        }
        System.out.println("s=q"+this.s);
        System.out.print("F={");
        for (int i = 0; i < this.F.size(); i++) {
            if(i==this.F.size()-1){
                System.out.print("q"+this.F.get(i));
            }
            else{
                System.out.print("q"+this.F.get(i)+",");
            }
                
            
        }
        System.out.println("}");
    }

    private void construirThOr(Thomson pop, Thomson pop0) {
        System.out.println("ns");
    }

    private void construirThConc(Thomson pop, Thomson pop0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
        
    

 
    
    
  

}
