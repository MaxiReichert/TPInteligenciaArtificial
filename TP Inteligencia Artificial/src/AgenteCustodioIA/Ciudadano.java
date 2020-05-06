package AgenteCustodioIA;

public class Ciudadano {

	private int posicionActual;
	private int posicionResidencia;
	
	
	
	public Ciudadano(int posicionActual, int posicionResidencia) {
		super();
		this.posicionActual = posicionActual;
		this.posicionResidencia = posicionResidencia;
	}
	
	public int getPosicionActual() {
		return posicionActual;
	}
	public void setPosicionActual(int posicionActual) {
		this.posicionActual = posicionActual;
	}
	public int getPosicionResidencia() {
		return posicionResidencia;
	}
	public void setPosicionResidencia(int posicionResidencia) {
		this.posicionResidencia = posicionResidencia;
	}
	
	
}
