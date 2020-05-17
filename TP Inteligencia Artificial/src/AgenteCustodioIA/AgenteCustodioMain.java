package AgenteCustodioIA;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import javafx.scene.web.WebEngine;

public class AgenteCustodioMain {

	public static AgenteCustodioState main(String estrategia) throws PrologConnectorException{
		AgenteCustodio agente= new AgenteCustodio(estrategia);
		
		AgenteCustodioEnvironment ambiente= new AgenteCustodioEnvironment();
		
		SearchBasedAgentSimulator simulator= new SearchBasedAgentSimulator(ambiente, agente);
		
		simulator.start();
		return (AgenteCustodioState) agente.getAgentState();
	}
}
