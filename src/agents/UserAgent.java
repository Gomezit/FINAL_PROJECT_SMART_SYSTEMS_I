/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agents;


import final_project_smart_systems_i.BoardGame;
import jade.core.AID;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author andres
 */
public class UserAgent extends GuiAgent {

    BoardGame boardGame;

    @Override
    protected void onGuiEvent(GuiEvent ge) {
        
        //Indirect
        if (ge.getType() == 0) {

            AID id = new AID((String) ge.getParameter(0), AID.ISLOCALNAME);
            ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);

            msg.addReceiver(id);

            msg.setContent((String) ge.getParameter(1));
            this.send(msg);

        }       
        
    }
    
    public void addMessage(String message){
        
        this.boardGame.jTextAreaBoard.setText(message);
        
    }
    
    @Override
    protected void setup() {        

        boardGame = new BoardGame(this, this.getLocalName());
        boardGame.setVisible(true);
                
    }

    public LinkedList<String> searchServices(String nameService) {

        DFAgentDescription dfd = new DFAgentDescription();
        LinkedList<String> namesAgents = new LinkedList<>();

        try {
            DFAgentDescription[] result = DFService.search(this, dfd);
            System.out.println("All found agents" + result.length);

            for (int i = 0; i < result.length; i++) {

                Iterator iter = result[i].getAllServices();

                while (iter.hasNext()) {

                    ServiceDescription sd = (ServiceDescription) iter.next();
                    if (sd.getName().equalsIgnoreCase("ResolveNonogramsIndirectVariant") || 
                            sd.getName().equalsIgnoreCase("ResolveNonogramsDirectVariant")) {

                        namesAgents.add(result[i].getName().getLocalName());

                    }
                }
                System.out.println("The agents was register with service 'ResolveNonograms' :  " + result[i].getName().getLocalName());
            }
        } catch (Exception fe) {
            System.err.println(getLocalName() + " search with DF unsuccessded - " + fe.getMessage());
            doDelete();
        }

        return namesAgents;

    }

}
