package AgenteCustodioIA;

public class Ciudadano {

	private int posicionActual;
	private int posicionResidencia;
	private int id;
	
	
	public Ciudadano(int id, int posicionActual, int posicionResidencia) {
		super();
		this.id=id;
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
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	
}
