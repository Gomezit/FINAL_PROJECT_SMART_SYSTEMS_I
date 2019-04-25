/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours;

import final_project_smart_systems_i.FileClass;
import final_project_smart_systems_i.ResolveDirectVariant;
import final_project_smart_systems_i.SolveRow;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.ControllerException;
import jade.wrapper.PlatformController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author andres
 */
public class SolveDirect extends CyclicBehaviour{
    
    
    private ResolveDirectVariant resolve;
    private int numAgentsToCreate;
    ACLMessage reply;
    String linesSolved="";

    @Override
    public void action() {

        ACLMessage msg = this.myAgent.receive();
        
        reply = new ACLMessage(ACLMessage.REQUEST);
        reply.addReceiver(new AID("ag1",AID.ISLOCALNAME));
        
        resolve = new ResolveDirectVariant();

        if (msg != null) {
             
            numAgentsToCreate = resolve.createMatrixDirectVariant(msg.getContent()).length;
            
            createAgentsByLineNonogram();
            
//          boolean solution =  resolve.resolveNonogram();
//          System.out.println(resolve.showMatrix());
            reply.setContent(resolve.resolve(msg.getContent()));
            myAgent.send(reply);
            
            JOptionPane.showMessageDialog(null,"The nonogram on direct variant was resolve.");            
            
            
        }
    }

    private void createAgentsByLineNonogram() {
        
        //AGENTS FOR SOLVE ROWS
        for (int i = 0; i < numAgentsToCreate; i++) {
            
            String nameAgentToCreate = "SolverLineAgent" + i;
        
            PlatformController container = myAgent.getContainerController();

            try {
                
                container.createNewAgent(nameAgentToCreate, "agents.SolverLineAgentNonogram", null).start();
                System.out.println("Agent created");
                
                ACLMessage line = new ACLMessage(ACLMessage.REQUEST);
                line.addReceiver(new AID("SolverLineAgent" + i,AID.ISLOCALNAME));
                
                //int rowIndex, int N, List<Integer> constraints
                
                line.setContent("hi");
                myAgent.send(line);
                
                String solvedLine = myAgent.blockingReceive().getContent();
                linesSolved += solvedLine+"\n";
                
                
                
            } catch (ControllerException e) {

                Logger.getLogger(SolveDirect.class.getName()).log(Level.SEVERE,null,e);
            }
            
        }       
            
    }   
    
}
