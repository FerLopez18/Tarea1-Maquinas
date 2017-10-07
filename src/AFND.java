
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
        
        for (int i = 0; i < ER.lengthER(); i++) {
            
            System.out.println(ER.charAtER(i));
            
            char c = ER.charAtER(i);
            if(this.ER.esDelAlfabetoDeER(c)){
                //Thomson de un caracter
                System.out.println("Thomson de un caracter" + " " + c);
            }
            else{
                switch(c){
                    case '.': 
                        //Thomson de concatenacion
                        System.out.println("Thomson de concatenacion");
                        break;
                    case '|':
                        //Thomson de or
                        System.out.println("//Thomson de or");
                        break;
                        
                    case '*':
                        //Thomson de *
                        System.out.println("//Thomson de *");
                        break;
                    
                }
                        
                            
            }
            
            
        }
    }

    
    
    
    
}
