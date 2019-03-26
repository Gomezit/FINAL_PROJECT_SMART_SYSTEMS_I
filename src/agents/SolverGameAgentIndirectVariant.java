/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agents;


import behaviours.SolveIndirect;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;

/**
 *
 * @author andres
 */
public class SolverGameAgentIndirectVariant extends Agent {
    
     // ConfiguraciĂłn 
    @Override
    protected void setup() {
        System.out.println(" I am agent that resolve nonograms with indirect variant  >>> " + this.getLocalName());
        registerService();
        doWait(2000);
        SolveIndirect rc1 = new SolveIndirect();
        this.addBehaviour(rc1);
                
    }

    private void registerService() {
        
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(this.getAID());

        ServiceDescription sd = new ServiceDescription();
        sd.setType("ResolveNonogramsIndirectVariant");
        sd.setName("ResolveNonogramsIndirectVariant");

        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        } catch (FIPAException ex) {
            System.err.println("The agent :" + getLocalName() + "can't register the service : " + ex.getMessage());
            doDelete();
        }

    }
    
    
    
}
