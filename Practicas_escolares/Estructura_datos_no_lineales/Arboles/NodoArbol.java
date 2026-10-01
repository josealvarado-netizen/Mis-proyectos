public class NodoArbol {
    private Character elemento;
    private NodoArbol izq, der;
    
    public NodoArbol() {}
    
    public NodoArbol(Character elemento, NodoArbol izq, NodoArbol der) {
    	this.elemento = elemento;
    	this.izq = izq;
    	this.der = der;
    }

	public Character getElemento() {
		return elemento;
	}

	public void setElemento(Character elemento) {
		this.elemento = elemento;
	}

	public NodoArbol getIzq() {
		return izq;
	}

	public void setIzq(NodoArbol izq) {
		this.izq = izq;
	}

	public NodoArbol getDer() {
		return der;
	}

	public void setDer(NodoArbol der) {
		this.der = der;
	}
    
    
}

    