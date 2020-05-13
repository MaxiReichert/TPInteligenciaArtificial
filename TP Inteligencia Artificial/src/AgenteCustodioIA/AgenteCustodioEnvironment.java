package AgenteCustodioIA;

import java.util.ArrayList;
import java.util.HashMap;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AgenteCustodioEnvironment extends Environment {

	private HashMap<Integer, AgenteCustodioPerception> percepciones;
	private int iteracion=0;
	
	public AgenteCustodioEnvironment() {
		this.environmentState= new AgenteCustodioEnvironmentState();
		
		percepciones= new HashMap<Integer, AgenteCustodioPerception>();
		
		AgenteCustodioPerception percepcion1= new AgenteCustodioPerception();
		percepcion1.setTipo(AgenteCustodioPerception.CAMBIO_POSCION_CIUDADANO);
		percepcion1.setCiudadano(new Ciudadano(5,24,50));
		percepciones.put(6, percepcion1);
		
		AgenteCustodioPerception percepcion2= new AgenteCustodioPerception();
		percepcion2.setTipo(AgenteCustodioPerception.NUEVO_CIUDADANO);
		percepcion2.setCiudadano(new Ciudadano(6,6,10));
		percepciones.put(13,percepcion2);
	}
	
	@Override
	public Perception getPercept() {
		iteracion++;
		AgenteCustodioPerception percepcion=percepciones.get(iteracion);
		if(percepcion!=null) {
			AgenteCustodioEnvironmentState ambiente= (AgenteCustodioEnvironmentState) this.getEnvironmentState();
			switch (percepcion.getTipo()){
				case 0:
					int nuevaPosicion=percepcion.getCiudadano().getPosicionActual();
					ambiente=actualizarPoscionCiudadano(nuevaPosicion, ambiente, percepcion.getCiudadano());
					break;
				case 1:
					ambiente.getCiudadanosInfectados().add(percepcion.getCiudadano());
					break;
			}
			return percepcion;
		}
		return null;
	}

	private AgenteCustodioEnvironmentState actualizarPoscionCiudadano(int nuevaPosicion, AgenteCustodioEnvironmentState ambiente,
			Ciudadano ciudadano) {
		for(int i=0; i<ambiente.getCiudadanosInfectados().size(); i++) {
			if(ciudadano.getId()==ambiente.getCiudadanosInfectados().get(i).getId()) {
				ambiente.getCiudadanosInfectados().get(i).setPosicionActual(nuevaPosicion);
			}
		}
		
		return ambiente;
		
	}
	
	
}
