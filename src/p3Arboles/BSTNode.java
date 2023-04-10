package p3Arboles;

/**
 * Clase BSTNode
 * @author MariaTeresaFernandezCoro - UO263728
 */
public class BSTNode<T extends Comparable<T>> {
	
	private T info;				// informacion del nodo
	private BSTNode<T> left;	// nodo hijo izquierdo
	private BSTNode<T> right;	// nodo hijo derecho

	/**
	 * Constructor de la clase
	 * @param objeto de tipo generico T, es un objeto comparable
	 */
	public BSTNode(T objeto) {
		this.info = objeto;
	}

	/** 
	 * Asigna la informacion que se quiere meter en el nodo
	 * @param info, objeto de tipo generico
	 */ 
	protected void setInfo(T info) {
		this.info = info;
	}

	/**
	 * Obtiene la informacion que almacena el nodo
	 * @return info, objeto de tipo generico
	 */
	public T getInfo() {
		return this.info;
	}

	/** 
	 * Establece el nodo que se quiere enlazar en el subarbol izquierdo 
	 * @param nodo, nodo objeto de tipo generico
	 */ 
	public void setLeft(BSTNode<T> nodo) {	//protected
		this.left = nodo;
	}

	/** 
	 * Establece el nodo que se quiere enlazar en el subarbol derecho
	 *  @param nodo, nodo objeto de tipo generico
	 */ 
	public void setRight(BSTNode<T> nodo){
		this.right = nodo;
	}

	/** 
	 * Obtiene el subarbol izquierdo
	 * @return left, nodo objeto de tipo generico
	 */ 
	public BSTNode<T> getLeft() {
		return this.left;
	}

	/** 
	 * Obtiene el subarbol derecho
	 * @return right, nodo objeto de tipo generico
	 */ 
	public BSTNode<T> getRight() {
		return this.right;
	}

	/**
	 * Devuelve un String con la informacion del nodo 
     * @return la informacion del nodo
	 */
	public String toString() {
		return info.toString();
	}
	
}
