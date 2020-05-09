package AgenteCustodioIA;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class AgenteCustodioState extends SearchBasedAgentState {

	private int posicion;
	private ArrayList<Ciudadano> ciudadanosFugados;
	private Double costoCamino;
	private ArrayList<Integer> recorrido;
	private HashMap<Integer, Collection<Integer>> mapaConocido;
	//agregar sensores
	
	public AgenteCustodioState() {
		this.initState();
	}
	
	@Override
	public void initState() {
		posicion=0;
		costoCamino=0.0;
		
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
			{17,35,19},
			{18,33,20},
			{19,21,16},
			{20,22,31},
			{21,23,14},
			{22,24,30},
			{23,25,12},
			{24,26,157},
			{25,27},
			{26,28,8},
			{27,41}
		
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
		Ciudadano fugado1= new Ciudadano(2,16,10);
		ciudadanosFugados.add(fugado1);
	}
	
	@Override
	public void updateState(Perception p) {
		recorrido.add(posicion);
		
	}
	
	@Override
	public AgenteCustodioState clone() {
		AgenteCustodioState nuevoEstado= new AgenteCustodioState();
		nuevoEstado.setPosicion(posicion);
		ArrayList<Ciudadano> ciudadanoFugados= (ArrayList<Ciudadano>) ciudadanosFugados.clone();
		nuevoEstado.setCiudadanosFugados(ciudadanoFugados);
		nuevoEstado.setCostoCamino(costoCamino);
		ArrayList<Integer> camino= (ArrayList<Integer>) recorrido.clone();
		return nuevoEstado;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof AgenteCustodioState)) {
			return false;
		}
		 return (posicion==((AgenteCustodioState)obj).getPosicion() && ciudadanosFugados.size()==((AgenteCustodioState)obj).getCiudadanosFugados().size());
	}


	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
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


	public ArrayList<Integer> getRecorrido() {
		return recorrido;
	}

	public Collection<Integer> getSucesores() {
		return mapaConocido.get(posicion);
	}
	
	public HashMap<Integer, Collection<Integer>> getMapaConocido(){
		return this.mapaConocido;
	}

	

}
