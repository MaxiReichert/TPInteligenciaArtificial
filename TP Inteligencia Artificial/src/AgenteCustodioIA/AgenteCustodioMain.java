package AgenteCustodioIA;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AgenteCustodioMain {

	public static AgenteCustodioState main(String string) throws PrologConnectorException{
		AgenteCustodio agente= new AgenteCustodio(string);
		
		AgenteCustodioEnvironment ambiente= new AgenteCustodioEnvironment();
		
		SearchBasedAgentSimulator simulator= new SearchBasedAgentSimulator(ambiente, agente);
		
		simulator.start();
		return (AgenteCustodioState) agente.getAgentState();
	}
}
