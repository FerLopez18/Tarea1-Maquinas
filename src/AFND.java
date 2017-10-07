
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernanda
 */

public class AFND {
    Stack<Thomson> stack;
    ER ER;

    public AFND(ER ER) {
        this.ER = ER;
        this.stack = new Stack<Thomson>();
        this.transformar();
        
    }
    
    private void transformar(){
        int s=0;
        for (int i = 0; i < ER.lengthER(); i++) {
            
            //System.out.println(ER.charAtER(i));
            
            char c = ER.charAtER(i);
            if(this.ER.esDelAlfabetoDeER(c)){
                //Thomson de un caracter
                //System.out.println("Thomson de un caracter" + " " + c);
                Thomson th = new Thomson(c,s);
                s = th.sizeK();
                this.stack.push(th);
                th.imprimirThc();
  
            }
            else{
                switch(c){
                    case '.': 
                        //Thomson de concatenacion
                        System.out.println("Thomson de concatenacion");
                        Thomson pop = stack.pop();
                        Thomson pop0 = stack.pop();
                        //this.renombrarEstados(pop, pop0);
                        Thomson thConc = new Thomson(pop,pop0, c);
                        this.stack.push(thConc);
                        thConc.imprimirThc();
                        s=thConc.sizeK();
                       
                        break;
                    case '|':
                        //Thomson de or
                        System.out.println("//Thomson de or");
                        Thomson pop1 = stack.pop();
                        Thomson pop2 = stack.pop();
                        Thomson thOr = new Thomson(pop1,pop2, c);
                        thOr.imprimirThc();
                        this.stack.push(thOr);
                        s=thOr.sizeK();
                        break;
                        
                    case '*':
                        //Thomson de *
                        System.out.println("//Thomson de *");
                        Thomson thEst = new Thomson(stack.pop());
                        thEst.imprimirThc();
                        this.stack.push(thEst);
                        s=thEst.sizeK();
                        break;
                    
                }
                
                        
                            
            }
            
            
        }
    }

 
    
}
