/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernanda
 */
public class T1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String regex = "(a.b|a.b.a)*";
        String postfixER = InfixToPostfix.infixToPostfix(regex);
        
        System.out.println("ER: " + regex);
        System.out.println("Postfix: "+ postfixER);
        ER er = new ER(postfixER);
        
        AFND afnd = new AFND(er);
     
    }
    
}
