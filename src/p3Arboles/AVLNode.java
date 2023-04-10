package p3Arboles;

/**
 * Clase AVLNode
 * Deriva de la clase BSTNode
 * @author MariaTeresaFernandezCoro - UO263728
 */
public class AVLNode<T extends Comparable<T>> extends BSTNode<T> {

	protected int height;			// almacena la altura del nodo
	protected int balanceFactor;	// almacena el factor de balance del nodo

	/**
	 * Constructor
	 * Llama al padre y añade la informacion pasada como parametro
	 * @param nodo de tipo generico
	 */
	public AVLNode(T nodo) {
		super(nodo);
	} 

	/**
	 * Obtiene la altura del arbol del cual es raiz el nodo en cuestion
	 * @return height, int
	 */
	public int getHeight() {
		return this.height;
	} 

	/**
	 * Obtiene el factor de balance segun el equilibrio del arbol del cual es raiz
	 * @return balanceFactor, int
	 */
	public int getBF() {
		return this.balanceFactor;
	}

	/**
	 * Actualiza la altura del nodo en el arbol utilizando la altura de los hijos y
	 * si es preciso actualiza el factor de balance
	 */
	protected void updateHeight() {
		int alturaIzq;
		if (getLeft() == null)
			alturaIzq = -1;
		else
			alturaIzq = getLeft().getHeight();
		int alturaDcha;
		if (getRight() == null)
			alturaDcha = -1;
		else
			alturaDcha = getRight().getHeight();
		// Actualizo la altura
		if (alturaIzq > alturaDcha)
			this.height = alturaIzq+1;
		else
			this.height = alturaDcha+1;
		// Actualizo el factor de balance
		this.balanceFactor = alturaDcha-alturaIzq;
	}

	/**
	 * Obtiene el hijo del subarbol izquierdo del nodo
	 * Llama al padre para obtener el valor
	 * @return el hijo izquierdo, AVLNode de tipo generico
	 */
	public AVLNode<T> getLeft() {
		return (AVLNode<T>) super.getLeft();
	}

	/**
	 * Obtiene el hijo del subarbol derecho del nodo
	 * Llama al padre para obtener el valor
	 * @return el hijo derecho, AVLNode de tipo generico
	 */
	public AVLNode<T> getRight() {
		return (AVLNode<T>) super.getRight();
	}

	/**
	 * Devuelve un String con la informacion del nodo
	 * Llama al padre para obtener la informacion 
     * @return la informacion del nodo
	 */
	public String toString() { 
		return super.toString()+":BF="+ getBF(); 
	} 
	
}
