package AgenteCustodioIA;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Multar extends SearchAction {
	
	private int idCiudadanoEliminado;
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		AgenteCustodioState agentState= (AgenteCustodioState) s;
		
		ArrayList<Ciudadano> ciudadanosFugados= new ArrayList<Ciudadano>();
		ArrayList<Sensor> sensores= new ArrayList<Sensor>();
		int posCiudadanoEliminado=-1;
		sensores= agentState.getSensores();
		ciudadanosFugados= agentState.getCiudadanosFugados();
		if(!ciudadanosFugados.isEmpty()) {
			for(int i=0; i<ciudadanosFugados.size(); i++) {
				if(agentState.getPosicion()==ciudadanosFugados.get(i).getPosicionActual()) {
					idCiudadanoEliminado=ciudadanosFugados.get(i).getId();
					posCiudadanoEliminado=ciudadanosFugados.get(i).getPosicionActual();
					ciudadanosFugados.remove(i);
					agentState.setCiudadanosFugados(ciudadanosFugados);
				}
			}
			for(int i=0; i<sensores.size(); i++) {
				if(posCiudadanoEliminado==sensores.get(i).getPosicion()) {
					sensores.get(i).setEstado(false);
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
		if(this.execute((SearchBasedAgentState) ast)!=null) {
			AgenteCustodioEnvironmentState estadoAmbiente= (AgenteCustodioEnvironmentState) est;
			
			ArrayList<Ciudadano> ciudadanosInfectados= estadoAmbiente.getCiudadanosInfectados();
			for(int i=0; i<ciudadanosInfectados.size(); i++) {
				if(idCiudadanoEliminado==ciudadanosInfectados.get(i).getId()) {
					int posicionActual=ciudadanosInfectados.get(i).getPosicionResidencia();
					ciudadanosInfectados.get(i).setPosicionActual(posicionActual);
					estadoAmbiente.setCiudadanosInfectados(ciudadanosInfectados);
				}
			} 
			return estadoAmbiente;
		}
			
		
	
		return est;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Multar";
	}

}
