package AgenteCustodioIA;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AgenteCustodioEnvironment extends Environment {

	public AgenteCustodioEnvironment() {
		this.environmentState= new AgenteCustodioEnvironmentState();
	}
	
	@Override
	public Perception getPercept() {
		// Colocar las percepciones
		return null;
	}
	
}
