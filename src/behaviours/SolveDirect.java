/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours;

import final_project_smart_systems_i.FileClass;
import final_project_smart_systems_i.ResolveDirectVariant;
import final_project_smart_systems_i.ResolveIndirectVariant;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author andres
 */
public class SolveDirect extends CyclicBehaviour{
    
    
    FileClass fileClass;
    ResolveDirectVariant resolve;

    @Override
    public void action() {

        fileClass = new FileClass();
        ACLMessage msg = this.myAgent.receive();
        
        ACLMessage reply = new ACLMessage(ACLMessage.REQUEST);
        reply.addReceiver(new AID("ag1",AID.ISLOCALNAME));
        
        resolve = new ResolveDirectVariant();

        if (msg != null) {
             
            resolve.createMatrixDirectVariant(msg.getContent());            
            boolean solution =  resolve.resolveNonogram();
            System.out.println(resolve.showMatrix());
            reply.setContent(resolve.showMatrix());
            JOptionPane.showMessageDialog(null,solution ? "The nonogram on direct variant was resolve." : "The nonogram on direct variant was resolve.");            
            
            myAgent.send(reply);
        }
    }
    
}
