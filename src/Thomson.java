
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
    private ArrayList<Character> sigma;
    private int s;
    private ArrayList<Integer> F;
    private HashMap<Integer, ArrayList<Transition>> delta;

    Thomson(char c, int s) {
        this.K = new ArrayList<>();
        this.sigma = new ArrayList<>();
        this.F = new ArrayList<>();
        this.delta = new HashMap<>();
        this.construirThc(c, s);

    }

    Thomson(Thomson pop, Thomson pop0, char op) {
        this.K = new ArrayList<>();
        this.sigma = new ArrayList<>();
        this.F = new ArrayList<>();
        this.delta = new HashMap<>();
        if (op == '|') {
            this.construirThOr(pop, pop0);
        } else {
            this.construirThConc(pop, pop0);
        }
    }

    Thomson(Thomson pop) {
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

    public Set<Integer> keySetDelta() {
        return delta.keySet();
    }

    public ArrayList<Transition> getTransitions(Object key) {
        return delta.get(key);
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

    private void construirThc(char c, int s) {
        this.K.add(s);
        this.K.add(s + 1);
        this.sigma.add(c);
        this.s = s;
        this.F.add(s + 1);
        ArrayList<Transition> t = new ArrayList<>();
        t.add(new Transition(c, s + 1));
        this.delta.put(s, t);
        this.delta.put(s + 1, null);
    }

    public void imprimirThc() {
        System.out.print("K={");
        for (int i = 0; i < K.size(); i++) {
            if (i == K.size() - 1) {
                System.out.print(K.get(i));
            } else {
                System.out.print(K.get(i) + ",");
            }

        }
        System.out.println("}");

        System.out.print("Sigma={");
        for (int i = 0; i < this.sigma.size(); i++) {
            if (i == this.sigma.size() - 1) {
                System.out.print(this.sigma.get(i));
            } else {
                System.out.print(this.sigma.get(i) + ",");
            }

        }
        System.out.println("}");
        System.out.println("Delta:");

        for (Integer key : this.delta.keySet()) {
            if (this.delta.get(key) != null) {
                for (Transition t : this.delta.get(key)) {
                    System.out.println("(q" + key + "," + t.getL() + ",q" + t.getTarget() + ")");
                }
            }

        }

        System.out.println("s=q" + this.s);
        System.out.print("F={");
        for (int i = 0; i < this.F.size(); i++) {
            if (i == this.F.size() - 1) {
                System.out.print("q" + this.F.get(i));
            } else {
                System.out.print("q" + this.F.get(i) + ",");
            }

        }
        System.out.println("}");

        System.out.println("");
    }

    private void construirThOr(Thomson pop, Thomson pop0) {

        /*
        Union de K de pop y pop 0, más un nodo inicial s1 y un nodo final f
         */
        for (int i = 0; i < pop0.sizeK(); i++) {
            this.K.add(pop0.getK(i));
        }
        for (int i = 0; i < pop.sizeK(); i++) {
            this.K.add(pop.getK(i));
        }
        int s1 = this.K.size();
        this.K.add(s1);
        int f = s1 + 1;
        this.K.add(f);

        /*
        Sigma
         */
        for (int i = 0; i < pop0.sizesigma(); i++) {
            this.sigma.add(pop0.getSigma(i));

        }
        for (int i = 0; i < pop.sizesigma(); i++) {
            this.sigma.add(pop.getSigma(i));
        }

        /*
        Union de las relaciones de transicion
         */
        for (Integer key : pop0.keySetDelta()) {
            ArrayList<Transition> transition = new ArrayList<>();
            if (pop0.getTransitions(key) != null) {
                for (Transition t : pop0.getTransitions(key)) {
                    transition.add(t);
                }
            }

            this.delta.put(key, transition);

        }
        for (Integer key : pop.keySetDelta()) {
            ArrayList<Transition> transition = new ArrayList<>();
            if (pop.getTransitions(key) != null){
                for (Transition t : pop.getTransitions(key)) {
                    transition.add(t);
                }
            }
                
            this.delta.put(key, transition);
        }
        ArrayList<Transition> taux = new ArrayList<>();
        taux.add(new Transition('-',pop0.getS()));
        taux.add(new Transition('-',pop.getS()));
        this.delta.put(s1,taux);
        
        ArrayList<Transition> taux1 = new ArrayList<>();
        taux1.add(new Transition('-',f));

        this.delta.put(pop0.getF(0),taux1);
        this.delta.put(pop.getF(0), taux1);
        /*
        s
         */
        this.s = s1;
        /*
        f
         */
        this.F.add(f);

    }

    private void construirThConc(Thomson pop, Thomson pop0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int ultimoEstado() {
        return this.K.get(K.size() - 1);

    }

}
