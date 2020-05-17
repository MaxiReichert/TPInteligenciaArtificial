package AgenteCustodioIA;

import java.util.HashMap;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AgenteCustodioPerception extends Perception {
	
	public static int CAMBIO_POSICION_CIUDADANO=0;
	public static int NUEVO_CIUDADANO=1;
	public static int CORTE_NODO=2;
	public static int CONGESTION_NODO=3;
	
	private int tipo;
	private Ciudadano ciudadano;
	private int nodoCortado;
	private NodoCongestionado nodoCongestionado;
	
	
	@Override
	public void initPerception(Agent agent, Environment environment) {
		
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

	public NodoCongestionado getNodoCongestionado() {
		return nodoCongestionado;
	}

	public void setNodoCongestionado(NodoCongestionado nodoCongestionado) {
		this.nodoCongestionado = nodoCongestionado;
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		String tipoPercepcion;
		String idCiudadano;
		String posActualCiudadano;
		String posResidenciaCiudadano;
		
		switch(tipo) {
		case 0:
			idCiudadano = String.valueOf(ciudadano.getId());
			posActualCiudadano = String.valueOf(ciudadano.getPosicionActual());
			posResidenciaCiudadano = String.valueOf(ciudadano.getPosicionResidencia());
			str.append("CAMBIO_POSICION_CIUDADANO - ");
			str.append("(id: " + idCiudadano + ", posActual: " + posActualCiudadano + ", posResidencia: " + posResidenciaCiudadano + ")");
			break;
		case 1:
			idCiudadano = String.valueOf(ciudadano.getId());
			posActualCiudadano = String.valueOf(ciudadano.getPosicionActual());
			posResidenciaCiudadano = String.valueOf(ciudadano.getPosicionResidencia());
			str.append("NUEVO_CIUDADANO - ");
			str.append("(id: " + idCiudadano + ", posActual: " + posActualCiudadano + ", posResidencia: " + posResidenciaCiudadano + ")");
			break;
		case 2:
			str.append("CORTE_NODO - ");
			str.append("Nodo cortado: " + String.valueOf(nodoCortado));
			break;
		case 3:
			str.append("CONGESTION_NODO - ");
			str.append("Nodo congestionado: [" + String.valueOf(nodoCongestionado.getNodo()) + ", " 
												+ String.valueOf(nodoCongestionado.getEstado()) + "]");
			break;
		}

		return str.toString();
	}
	
	

}
