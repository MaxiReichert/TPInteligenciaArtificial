package AgenteCustodioIA;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AgenteCustodioMain {

	public static void main(String[] args) throws PrologConnectorException{
		AgenteCustodio agente= new AgenteCustodio("Amplitud");
		
		AgenteCustodioEnvironment ambiente= new AgenteCustodioEnvironment();
		
		SearchBasedAgentSimulator simulator= new SearchBasedAgentSimulator(ambiente, agente);
		
		simulator.start();
		System.out.println("hola");
	}
}
