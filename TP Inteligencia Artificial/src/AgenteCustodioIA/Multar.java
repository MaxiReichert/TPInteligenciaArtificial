package AgenteCustodioIA;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Multar extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		AgenteCustodioState agentState= (AgenteCustodioState) s;
		
		ArrayList<Ciudadano> ciudadanosFugados= new ArrayList<Ciudadano>();
		ciudadanosFugados= agentState.getCiudadanosFugados();
		if(!ciudadanosFugados.isEmpty()) {
			for(int i=0; i<ciudadanosFugados.size(); i++) {
				if(agentState.getPosicion()==ciudadanosFugados.get(i).getPosicionActual()) {
					ciudadanosFugados.remove(i);
					agentState.setCiudadanosFugados(ciudadanosFugados);
				}
			}
			return agentState;
		}
		
		
		return null;
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
	this.execute((SearchBasedAgentState) ast);
	
	
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
