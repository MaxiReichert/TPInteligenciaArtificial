package AgenteCustodioIA;

public class Sensor {
	
	private int posicion;
	private boolean estado;
	
	public Sensor(int posicion, boolean estado) {
		this.posicion=posicion;
		this.estado=estado;
	}
	
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
