package AgenteCustodioIA;

public class NodoCongestionado {
	private int nodo;
	private boolean estado;
	
	public NodoCongestionado(int nodo, boolean estado) {
		super();
		this.nodo = nodo;
		this.estado = estado;
	}

	public int getNodo() {
		return nodo;
	}

	public void setNodo(int nodo) {
		this.nodo = nodo;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
