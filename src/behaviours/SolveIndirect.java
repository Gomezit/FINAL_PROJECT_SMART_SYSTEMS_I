/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours;

import final_project_smart_systems_i.FileClass;
import final_project_smart_systems_i.ResolveIndirectVariant;
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
        ACLMessage msg = this.myAgent.receive();
        resolve = new ResolveIndirectVariant();

        if (msg != null) {

            resolve.createMatrixIndirectVariant(msg.getContent());   
            resolve.createConstraints();
            fileClass.writeFile(msg.getContent());
            JOptionPane.showMessageDialog(null,"The nonogram on indirect variant was resolve");
            
            
        }
    }
}
