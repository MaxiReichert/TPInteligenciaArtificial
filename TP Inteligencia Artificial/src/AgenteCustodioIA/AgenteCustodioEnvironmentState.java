package AgenteCustodioIA;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import frsf.cidisi.faia.state.EnvironmentState;

public class AgenteCustodioEnvironmentState extends EnvironmentState{

	private HashMap<Integer, Collection<Integer>> mapa;
	private ArrayList<Ciudadano> ciudadanosInfectados;
	
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
	
	public AgenteCustodioEnvironmentState () {
		this.initState();
	}
	
	@Override
	public AgenteCustodioEnvironmentState clone() {
		AgenteCustodioEnvironmentState nuevoAmbiente= new AgenteCustodioEnvironmentState();
		nuevoAmbiente.setMapa(mapa);
		ArrayList<Ciudadano> ciudadanoInfectados= (ArrayList<Ciudadano>) ciudadanosInfectados.clone();
		nuevoAmbiente.setCiudadanosInfectados(ciudadanoInfectados);
		return nuevoAmbiente;
		
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
		ciudadanosInfectados.add(new Ciudadano(1,15,15));
		ciudadanosInfectados.add(new Ciudadano(2,16,10));
		ciudadanosInfectados.add(new Ciudadano(3,5,5));
		ciudadanosInfectados.add(new Ciudadano(4,31,38));
		ciudadanosInfectados.add(new Ciudadano(5,19,50));
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Ciudadano> getCiudadanosInfectados(){
		return ciudadanosInfectados;
	}
	
	public void setCiudadanosInfectados(ArrayList<Ciudadano> ciudadanosInfectados) {
		this.ciudadanosInfectados=ciudadanosInfectados;
	}
	
	public void setMapa(HashMap<Integer, Collection<Integer>> mapa) {
		this.mapa=mapa;
	}

}
