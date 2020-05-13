package AgenteCustodioIA;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Avanzar extends SearchAction {
	
	private int nodo;
	private Double costo=1.0;
	private int distancia=100;
	
	public Avanzar(int nodo) {
		this.nodo=nodo;
	}

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		AgenteCustodioState agentState= (AgenteCustodioState) s;
		
		ArrayList<Integer> sucesores= new ArrayList<Integer>();
		sucesores.addAll(agentState.getSucesores());
		if(sucesores !=null) {
			int index= sucesores.indexOf(nodo);
			if(index >=0) {
				agentState.setPosicion(nodo);
				agentState.setCostoCamino(agentState.getCostoCamino()+this.costo);
				agentState.setDistanciaReocrrida(agentState.getDistanciaReocorrida()+this.distancia);
				return agentState;
			}
		}
		
		return null;
	}

	@Override
	public Double getCost() {
		return this.costo;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		this.execute((SearchBasedAgentState) ast);
		return est;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
