package AgenteCustodioIA;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import frsf.cidisi.faia.state.EnvironmentState;

public class AgenteCustodioEnvironmentState extends EnvironmentState{

	private HashMap<Integer, Collection<Integer>> mapa;
	private List<Ciudadano> ciudadanosInfectados;
	
	//terminar de completar con el resto de los nodos
	public static final Integer[][] posiciones= new Integer [][] {
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
	
	
	@Override
	public Object clone() {
		return mapa.clone();
		
	}
	
	@Override
	public void initState() {
		
		mapa= new HashMap<Integer, Collection<Integer>>();
		for(int i=0; i<posiciones.length; i++) {
			ArrayList<Integer> sucesores= new ArrayList<Integer>();
			for(int j=0; j<posiciones[i].length; j++){
				sucesores.add(posiciones[i][j]);
			}
			mapa.put(i, sucesores);
		}
		
		ciudadanosInfectados= new ArrayList<Ciudadano>();
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
