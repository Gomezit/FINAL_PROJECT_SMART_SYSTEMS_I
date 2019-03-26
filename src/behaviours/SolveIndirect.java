/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours;

import agents.UserAgent;
import final_project_smart_systems_i.FileClass;
import final_project_smart_systems_i.ResolveIndirectVariant;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

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
            //fileClass.writeFile(msg.getContent());
            System.out.println("the Game for indirect variant was resolve");
            
        }

    }

}
