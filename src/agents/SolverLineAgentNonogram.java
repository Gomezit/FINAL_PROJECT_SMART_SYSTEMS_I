/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agents;

import behaviours.SolveDirect;
import behaviours.SolverLineNonogram;
import jade.core.Agent;

/**
 *
 * @author andres
 */
public class SolverLineAgentNonogram extends Agent{
    
    
        @Override
        protected void setup(){
        
        System.out.println(" I am agent that solve one line nonogram  >>> " + this.getLocalName());
        SolverLineNonogram rc1 = new SolverLineNonogram();
        this.addBehaviour(rc1);
       
        }
    
    
}
