package AgenteCustodioIA;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.logging.Logger;

import com.sun.javafx.collections.MapAdapterChange;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AgenteCustodioEnvironment extends Environment {

	private HashMap<Integer, AgenteCustodioPerception> percepciones;
	private int iteracion=0;
	
	public AgenteCustodioEnvironment() {
		this.environmentState= new AgenteCustodioEnvironmentState();
		
		percepciones= new HashMap<Integer, AgenteCustodioPerception>();
		
		
		AgenteCustodioPerception percepcion1= new AgenteCustodioPerception();
		percepcion1.setTipo(AgenteCustodioPerception.CORTE_NODO);
		percepcion1.setNodoCortado(15);
		percepciones.put(3, percepcion1);
		
		
		AgenteCustodioPerception percepcion6= new AgenteCustodioPerception();
		percepcion6.setTipo(AgenteCustodioPerception.CAMBIO_POSICION_CIUDADANO);
		percepcion6.setCiudadano(new Ciudadano(5,24,50));
		percepciones.put(6, percepcion6);
		
		AgenteCustodioPerception percepcion13= new AgenteCustodioPerception();
		percepcion13.setTipo(AgenteCustodioPerception.NUEVO_CIUDADANO);
		percepcion13.setCiudadano(new Ciudadano(6,6,10));
		percepciones.put(13,percepcion13);
	}
	
	@Override
	public Perception getPercept() {
		iteracion++;
		AgenteCustodioPerception percepcion=percepciones.get(iteracion);
		if(percepcion!=null) {
			AgenteCustodioEnvironmentState ambiente= (AgenteCustodioEnvironmentState) this.getEnvironmentState();
			switch (percepcion.getTipo()){
				case 0: //CAMBIO_POSICION_CIUDADANO
					int nuevaPosicion=percepcion.getCiudadano().getPosicionActual();
					ambiente=actualizarPosicionCiudadano(nuevaPosicion, ambiente, percepcion.getCiudadano());
					break;
				case 1: //NUEVO_CIUDADANO
					ambiente.getCiudadanosInfectados().add(percepcion.getCiudadano());
					break;
				case 2: //CORTE_NODO
					ambiente = actualizarMapa(ambiente, percepcion.getNodoCortado());
			}
			return percepcion;
		}
		return null;
	}

	private AgenteCustodioEnvironmentState actualizarMapa(AgenteCustodioEnvironmentState ambiente, int nodoCortado) {
		
		HashMap<Integer, Collection<Integer>> mapa = ambiente.getMapa();
		
		//elimino los sucesores del nodoCortado
		ArrayList<Integer> sucesores= new ArrayList<Integer>();
		mapa.put(nodoCortado, sucesores);
		
		//busco en el resto de nodos donde aparece el nodoCortado en la lista de sucesores y lo elimino
		for (Entry<Integer, Collection<Integer>> entry : mapa.entrySet()) {
			Integer key = entry.getKey();
			if(mapa.get(key).contains(nodoCortado)) {
				Collection<Integer> nuevosSucesores = mapa.get(key);
				nuevosSucesores.remove(nodoCortado);
				mapa.put(key, nuevosSucesores);
			}
		}
		
		//seteo el mapa actualizado
		ambiente.setMapa(mapa);
		return ambiente;
	}

	private AgenteCustodioEnvironmentState actualizarPosicionCiudadano(int nuevaPosicion, AgenteCustodioEnvironmentState ambiente,
			Ciudadano ciudadano) {
		for(int i=0; i<ambiente.getCiudadanosInfectados().size(); i++) {
			if(ciudadano.getId()==ambiente.getCiudadanosInfectados().get(i).getId()) {
				ambiente.getCiudadanosInfectados().get(i).setPosicionActual(nuevaPosicion);
			}
		}
		
		return ambiente;
		
	}
	
	@Override
    public String toString() {
        return environmentState.toString();
    }
	
	
}
