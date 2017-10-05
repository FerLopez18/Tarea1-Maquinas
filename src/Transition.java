/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernanda
 */
public class Transition {
    String l;
    Integer target;
    
    public Transition(String lab, Integer target) 
    { this.l = lab; this.target = target; }
    
    public String toString() {
      return "-" + l + "-> " + target;
    }
  }
    

