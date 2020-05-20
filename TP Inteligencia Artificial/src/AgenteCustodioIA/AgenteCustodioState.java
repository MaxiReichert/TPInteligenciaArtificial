package AgenteCustodioIA;

import java.util.List;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import javafx.scene.web.WebView;

public class AgenteCustodioState extends SearchBasedAgentState {

	private int posicion;
	private ArrayList<Ciudadano> ciudadanosFugados;
	private Double costoCamino;
	private int distanciaRecorrida;
	private ArrayList<Integer> recorrido;
	private HashMap<Integer, Collection<Integer>> mapaConocido;
	private ArrayList<Sensor> sensores;
	private HashMap<Integer, Boolean> nodosCongestionados;
	
	public AgenteCustodioState() {
		this.initState();
	}
	
	@Override
	public void initState() {
		posicion=0;
		costoCamino=0.0;
		distanciaRecorrida=0;
		
		Integer[][] posiciones= new Integer [][] {
			{1,17},
			{2},
			{3,15},
			{4},
			{5,13},
			{6},
			{11},
			{8,10},
			{9},
			{8,10,27},
			{26,7},
			{12,25},
			{13,5},
			{14,23},
			{15,3},
			{16,21},
			{17,1},
			{18,0},
			{17,37,19},
			{18,35,20},
			{19,21,16},
			{20,22,33},
			{21,23,14},
			{22,24,31},
			{23,25,12},
			{24,26,29},
			{25,27},
			{26,28,8},
			{27,43},
			{44,30},
			{31,24},
			{32,41},
			{33,22},
			{34,39},
			{35,20},
			{36,50},
			{37},
			{18,52},
			{38,34},
			{48},
			{32},
			{46},
			{30},
			{28,64},
			{43,63},
			{44,42},
			{45,61},
			{46,40},
			{47,59},
			{48,38},
			{49,57},
			{50,36},
			{51,53,37},
			{55,54},
			{53,75},
			{54,74},
			{55,51},
			{56,72},
			{57,49},
			{58,70},
			{59,47},
			{60,68},
			{61,45},
			{62,66},
			{63,43,65},
			{64,85},
			{65},
			{66,62},
			{67,83},
			{68,60},
			{69,81},
			{70,58},
			{71,79},
			{72,56},
			{73,74},
			{74,54,76},
			{75,95},
			{76,94},
			{77,73},
			{78,92},
			{79,71},
			{80,90},
			{81,69},
			{82,88},
			{83,67},
			{84,86,65},
			{85,106},
			{86,84},
			{87,104},
			{88,82},
			{89,101},
			{90,80},
			{91,99},
			{92,78},
			{93,97},
			{94,96,76},
			{95,117},
			{96,116},
			{97,93},
			{98,114},
			{99,91},
			{100},
			{101,111},
			{102},
			{103,110},
			{104,87},
			{105,107,86},
			{106,108},
			{107,127},
			{108,105},
			{109,125},
			{112,102},
			{113,123},
			{100},
			{121,113},
			{114,98},
			{115,119},
			{116,96,118},
			{130,117},
			{118,131},
			{119,115},
			{120,133},
			{121,113},
			{122,129},
			{123,111},
			{124,137},
			{125,109},
			{126,108,139},
			{124},
			{135,128},
			{148,118,131},
			{132,148},
			{133,120},
			{134,146},
			{135,122},
			{136,143},
			{137},
			{138,142},
			{139,126},
			{140,127},
			{159,139,141},
			{142,138},
			{143,157},
			{144,155},
			{145},
			{146,134},
			{147,153},
			{148,132},
			{149,151},
			{150,130},
			{151,150},
			{152},
			{153,147},
			{154},
			{155,145},
			{156},
			{157,144},
			{158},
			{159,141},
			{140}
		};
		
		mapaConocido= new HashMap<Integer, Collection<Integer>>();
		for(int i=0; i<posiciones.length; i++) {
			ArrayList<Integer> sucesores= new ArrayList<Integer>();
			for(int j=0; j<posiciones[i].length; j++){
				sucesores.add(posiciones[i][j]);
			}
			mapaConocido.put(i, sucesores);
		}
		
		recorrido=new ArrayList<Integer>();
		
		ciudadanosFugados=new ArrayList<Ciudadano>();
		ciudadanosFugados.add(new Ciudadano(2,16,10));
		ciudadanosFugados.add(new Ciudadano(4,31,38));
		ciudadanosFugados.add(new Ciudadano(5,19,50));
		
		sensores= new ArrayList<Sensor>();
		sensores.add(new Sensor(6,false));
		sensores.add(new Sensor(20,false));
		sensores.add(new Sensor(114,false));
		sensores.add(new Sensor(142,false));
		
		nodosCongestionados = new HashMap<Integer, Boolean>();
		for(int i=0; i<posiciones.length; i++) {
			nodosCongestionados.put(i, false);
		}
	}
	
	@Override
	public void updateState(Perception p) {
		recorrido.add(posicion);
		
		if(p!=null) {
			AgenteCustodioPerception percepcion= (AgenteCustodioPerception) p;
			switch(percepcion.getTipo()) {
				case 0: //CAMBIO_POSICION_CIUDADANO
					ActualizarPosicionCiudadano(percepcion.getCiudadano());
					break;
				case 1:	//NUEVO_CIUDADANO
					ActualizarSensor(percepcion.getCiudadano());
					break;
				case 2: //CORTE_NODO
					actualizarMapa(percepcion.getNodoCortado());
					break;
				case 3: //CONGESTION_NODO
					actualizarNodosCongestionados(percepcion.getNodoCongestionado());
			}
		}
		
	}
	

	private void actualizarNodosCongestionados(NodoCongestionado nodoCongestionado) {
		nodosCongestionados.put(nodoCongestionado.getNodo(), nodoCongestionado.getEstado());
		
	}

	private void actualizarMapa(int nodoCortado) {
		
		//elimino los sucesores del nodoCortado
		ArrayList<Integer> sucesores= new ArrayList<Integer>();
		mapaConocido.put(nodoCortado, sucesores);
		
		//busco en el resto de nodos donde aparece el nodoCortado en la lista de sucesores y lo elimino
		for (Entry<Integer, Collection<Integer>> entry : mapaConocido.entrySet()) {
			Integer key = entry.getKey();
			if(mapaConocido.get(key).contains(nodoCortado)) {
				Collection<Integer> nuevosSucesores = mapaConocido.get(key);
				nuevosSucesores.remove(nodoCortado);
				mapaConocido.put(key, nuevosSucesores);
			}
		}
		
		//seteo el mapa actualizado
		this.setMapaConocido(mapaConocido);
		
		
	}

	private void ActualizarSensor(Ciudadano ciudadano) {
		this.ciudadanosFugados.add(ciudadano);
		for(int i=0; i<this.getSensores().size(); i++) {
			if(ciudadano.getPosicionActual()==this.getSensores().get(i).getPosicion()) {
				this.getSensores().get(i).setEstado(true);
			}
		}
		
	}

	private void ActualizarPosicionCiudadano(Ciudadano ciudadano) {
		for(int i=0; i<this.getCiudadanosFugados().size(); i++) {
			if(ciudadano.getId()==this.getCiudadanosFugados().get(i).getId()) {
				this.getCiudadanosFugados().get(i).setPosicionActual(ciudadano.getPosicionActual());
			}
		}
		
	}

	@Override
	public AgenteCustodioState clone() {
		AgenteCustodioState nuevoEstado= new AgenteCustodioState();
		nuevoEstado.setPosicion(posicion);
		ArrayList<Ciudadano> ciudadanoFugados= (ArrayList<Ciudadano>) ciudadanosFugados.clone();
		nuevoEstado.setCiudadanosFugados(ciudadanoFugados);
		nuevoEstado.setCostoCamino(costoCamino);
		ArrayList<Integer> camino= (ArrayList<Integer>) recorrido.clone();
		HashMap<Integer, Collection<Integer>> mapaClone = (HashMap<Integer, Collection<Integer>>) mapaConocido.clone();
		nuevoEstado.setMapaConocido(mapaClone);
		HashMap<Integer, Boolean> nodosCongestionadosClone = (HashMap<Integer, Boolean>) nodosCongestionados.clone();
		nuevoEstado.setNodosCongestionados(nodosCongestionadosClone);
		
		return nuevoEstado;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof AgenteCustodioState)) {
			return false;
		}
		 return (posicion==((AgenteCustodioState)obj).getPosicion() && ciudadanosFugados.size()==((AgenteCustodioState)obj).getCiudadanosFugados().size());
	}


	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public ArrayList<Ciudadano> getCiudadanosFugados() {
		return ciudadanosFugados;
	}

	public void setCiudadanosFugados(ArrayList<Ciudadano> ciudadanosFugados) {
		this.ciudadanosFugados = ciudadanosFugados;
	}

	public Double getCostoCamino() {
		return costoCamino;
	}
	
	public void setCostoCamino(Double costoCamino) {
		this.costoCamino=costoCamino;
		
	}
	
	public void setRecorrido(ArrayList<Integer> recorrido) {
		this.recorrido=recorrido;
		
	}


	public ArrayList<Integer> getRecorrido() {
		return recorrido;
	}

	public Collection<Integer> getSucesores() {
		return mapaConocido.get(posicion);
	}
	
	public HashMap<Integer, Collection<Integer>> getMapaConocido(){
		return this.mapaConocido;
	}
	
	public void setMapaConocido(HashMap<Integer, Collection<Integer>> mapaConocido) {
		this.mapaConocido = mapaConocido;
	}

	public int getDistanciaRecorrida() {
		return this.distanciaRecorrida;
	}
	
	public void setDistanciaRecorrida(int distanciaRecorrida) {
		this.distanciaRecorrida=distanciaRecorrida;
	}

	public ArrayList<Sensor> getSensores() {
		return sensores;
	}

	public void setSensores(ArrayList<Sensor> sensores) {
		this.sensores = sensores;
	}
	
	public HashMap<Integer, Boolean> getNodosCongestionados() {
		return nodosCongestionados;
	}

	public void setNodosCongestionados(HashMap<Integer, Boolean> nodosCongestionados) {
		this.nodosCongestionados = nodosCongestionados;
	}

	@Override
	public String toString() {
		String agentState = "Nodo " + String.valueOf(this.posicion);

		agentState += " - Recorrido: ";
		for (int nodo : recorrido) {
			agentState += String.valueOf(nodo) + "-"; 
		}
		
		agentState += "\n  Costo camino: " + String.valueOf(costoCamino);
		/*
		agentState += "\n  Mapa: " + mapaConocido.toString();
		
		agentState += "\n  Nodos congestionados: ";
		for(int i=0; i<nodosCongestionados.size(); i++) {
			if(nodosCongestionados.get(i))
			agentState += nodosCongestionados.toString() + " ";
		}

		agentState += "\n  Ciudadanos fugados: ";
		for (Ciudadano ciudadano : ciudadanosFugados) {
			agentState += "(" + String.valueOf(ciudadano.getId()) + ", " 
						+ String.valueOf(ciudadano.getPosicionActual()) + ", " 
						+ ciudadano.getPosicionResidencia() + ") - ";
		}

		agentState += "Sensores: ";
		for (Sensor sensor : sensores) {
			agentState += "(" + String.valueOf(sensor.isEstado()) + ", " + String.valueOf(sensor.getPosicion()) + ") - "; 
		}*/

		return agentState;
	}
	

}
