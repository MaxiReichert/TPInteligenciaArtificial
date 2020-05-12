package AgenteCustodioIA;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AgenteCustodioPerception extends Perception {
	
	public static int CAMBIO_POSCION_CIUDADANO=0;
	public static int NUEVO_CIUDADANO=1;
	public static int CORTE_CALLE=2;
	
	private int tipo;
	private Ciudadano ciudadano;
	private int nodoCortado;
	
	

	@Override
	public void initPerception(Agent agent, Environment environment) {
		// TODO Auto-generated method stub
		
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public int getNodoCortado() {
		return nodoCortado;
	}

	public void setNodoCortado(int nodoCortado) {
		this.nodoCortado = nodoCortado;
	}
	
	
	
	

}
