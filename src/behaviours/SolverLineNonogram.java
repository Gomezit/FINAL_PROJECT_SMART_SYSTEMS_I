/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours;

import final_project_smart_systems_i.SolveRow;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author andres
 */
public class SolverLineNonogram extends OneShotBehaviour{
    
    SolveRow solveRow;

    @Override
    public void action() {
        
        ACLMessage msg = this.myAgent.blockingReceive();

        ACLMessage reply = new ACLMessage(ACLMessage.REQUEST);
        reply.addReceiver(new AID("ag3",AID.ISLOCALNAME));
        
        
        
        reply.setContent("Hi, i am " + myAgent.getLocalName());
        myAgent.send(reply);
        
    }
    
}
