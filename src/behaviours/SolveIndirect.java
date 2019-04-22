/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours;

import final_project_smart_systems_i.FileClass;
import final_project_smart_systems_i.ResolveIndirectVariant;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author andres
 */
public class SolveIndirect extends CyclicBehaviour {

    FileClass fileClass;
    ResolveIndirectVariant resolve;

    @Override
    public void action() {

        fileClass = new FileClass();
        
        ACLMessage msg = myAgent.receive();
       
        ACLMessage reply = new ACLMessage(ACLMessage.REQUEST);
        reply.addReceiver(new AID("ag1",AID.ISLOCALNAME));
        
        resolve = new ResolveIndirectVariant();

        if (msg != null) {

            resolve.createMatrixIndirectVariant(msg.getContent()); 
            System.out.println(resolve.createColumnsConstraints());
            System.out.println(resolve.createRowsConstraints()); 
            reply.setContent(resolve.createColumnsConstraints().toString() + "\n" + resolve.createRowsConstraints().toString());
            fileClass.writeFile(resolve.createColumnsConstraints().toString() + "\n" + resolve.createRowsConstraints().toString());
            JOptionPane.showMessageDialog(null,"The nonogram on indirect variant was resolve.");
            
            myAgent.send(reply);
            
        }
    }
}
