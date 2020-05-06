package AgenteCustodioIA;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class AgenteCustodioState extends SearchBasedAgentState {

	private int posicion;
	private List<Ciudadano> ciudadanosFugados;
	private int costoCamino;
	private List<Integer> recorrido;
	private HashMap<Integer, Collection<Integer>> mapaConocido;
	//agregar sensores
	@Override
	public void initState() {
		posicion=0;
		
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
		
	}
	
	@Override
	public void updateState(Perception p) {
		recorrido.add(posicion);
		
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}


	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchBasedAgentState clone() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public List<Ciudadano> getCiudadanosFugados() {
		return ciudadanosFugados;
	}

	public void setCiudadanosFugados(List<Ciudadano> ciudadanosFugados) {
		this.ciudadanosFugados = ciudadanosFugados;
	}

	public int getCostoCamino() {
		return costoCamino;
	}


	public List<Integer> getRecorrido() {
		return recorrido;
	}

	public Collection<Integer> getSucesores() {
		return mapaConocido.get(posicion);
	}

	

}
