package p3Arboles;

/**
 * Clase BSTree
 * @author MariaTeresaFernandezCoro - UO263728
 */
public class BSTree<T extends Comparable<T>> {

	private BSTNode<T> raiz; // nodo raiz del arbol

	/**
	 * Obtiene la raiz del arbol
	 * @return raiz, nodo de tipo generico
	 */
	protected BSTNode<T> getRoot() {
		return this.raiz;
	}

	/**
	 * Asigna la raiz del arbol
	 * @param nodo, nodo de tipo generico
	 */
	protected void setRoot(BSTNode<T> nodo) {
		this.raiz = nodo;
	}

	/** 
	 * Añade un nodo al arbol
	 * Llama a un metodo recursivo
	 * @param nodo, objeto comparable que hay que insertar 
	 * @return 0 y un codigo de error negativo si lo inserta  
	 * -1 si ya existe
	 * -2 otra causa 
	 */ 
	public int addNode(T nodo) {
		if (nodo == null)
			return -2;
		else if (searchNode(nodo) != null)
			return -1;
		setRoot(addNodeRecursivo(raiz, nodo));
		return 0;
	}
	
	/**
	 * Añade un nodo al arbol
	 * Metodo recursivo
	 * @param raiz, BSTNode de tipo generico
	 * @param nodo, objeto a añadir de tipo generico
	 * @return el nodo a añadir, BSTNode de tipo generico
	 */
	private BSTNode<T> addNodeRecursivo(BSTNode<T> raiz, T nodo) {
		if (raiz == null)
			return new BSTNode<T>(nodo);
		else if (nodo.compareTo(raiz.getInfo()) < 0)
			raiz.setLeft(addNodeRecursivo(raiz.getLeft(), nodo)); 
		else if (nodo.compareTo(raiz.getInfo()) > 0)
			raiz.setRight(addNodeRecursivo(raiz.getRight(), nodo));
		return raiz;
	}

	/** 
	 * Se le pasa un objeto comparable que se busca 
	 * Llama a un metodo recursivo
	 * @param nodo de tipo generico a encontrar
	 * @return el objeto encontrado que cumple que es "equals" con el 
	 * buscado, null si no lo encuentra por cualquier motivo
	 */ 
	public T searchNode(T nodo) {
		if (nodo != null)
			return searchNodeRecursivo(raiz, nodo);
		return null;
	}
	
	/** 
	 * Se le pasa un objeto comparable que se busca 
	 * Metodo recursivo
	 * @param raiz, BSTNode de tipo generico
	 * @param nodo de tipo generico a encontrar
	 * @return el objeto encontrado que cumple que es "equals" con el 
	 * buscado, null si no lo encuentra por cualquier motivo 
	 */ 
	private T searchNodeRecursivo(BSTNode<T> raiz, T nodo) {
		if (raiz == null)
			return null;
		else if (!equals(raiz, nodo)) {
			if (nodo.compareTo(raiz.getInfo()) < 0)
				return searchNodeRecursivo(raiz.getLeft(), nodo);
			else
				return searchNodeRecursivo(raiz.getRight(), nodo);
		}
		return raiz.getInfo();
	}

	/**
	 * Comprueba si dos nodos son iguales
	 * @param raiz, BSTNode de tipo generico
	 * @param nodo de tipo generico
	 * @return true si lo son
	 * false en otro caso
	 */
	private boolean equals(BSTNode<T> raiz, T nodo) {
		if (nodo.compareTo(raiz.getInfo()) == 0)
			return true;
		return false;
	}
	
	/** 
	 * Genera un String con el recorrido en pre-orden
	 * Raíz-Subárbol izquierdo-Subárbol derecho
	 * (toString de los nodos separados por tabuladores)
	 * Llama a un metodo recursivo
	 * @return el recorrido en preorden, String
	 */ 
	public String preOrder() {
		return preOrderRecursivo(raiz);
	}
	
	/**
	 * Genera un String con el recorrido en pre-orden
	 * Raíz-Subárbol izquierdo-Subárbol derecho
	 * (toString de los nodos separados por tabuladores)
	 * Metodo recursivo
	 * @param nodo, BSTNode de tipo generico
	 * @return preorden, String 
	 */
	private String preOrderRecursivo(BSTNode<T> nodo) {
		String preorden = "";
		if (nodo == null)
			return "";
		preorden += (nodo.toString() + "\t");
		preorden += preOrderRecursivo(nodo.getLeft());
		preorden += preOrderRecursivo(nodo.getRight());
		return preorden;
	}

	/** 
	 * Genera un String con el recorrido en post-orden
	 * Subárbol izquierdo-Subárbol derecho-Raíz
	 * (toString de los nodos separados por tabuladores)
	 * Llama a un metodo recursivo
	 * @return el recorrido en postorden, String
	 */ 
	public String postOrder() {
		return postOrderRecursivo(raiz);
	}
	
	/**
	 * Genera un String con el recorrido en post-orden
	 * Subárbol izquierdo-Subárbol derecho-Raíz 
	 * (toString de los nodos separados por tabuladores)
	 * Metodo recursivo
	 * @param nodo, BSTNode de tipo generico
	 * @return postorden, String 
	 */
	private String postOrderRecursivo(BSTNode<T> nodo) {
		String postorden = "";
		if (nodo == null)
			return "";
		postorden += postOrderRecursivo(nodo.getLeft());
		postorden += postOrderRecursivo(nodo.getRight());
		postorden += (nodo.toString() + "\t");
		return postorden;
	}	

	/** 
	 * Genera un String con el recorrido en in-orden
	 * Subárbol izquierdo-Raíz-Subárbol derecho
	 * (toString de los nodos separados por tabuladores)
	 * Llama a un metodo recursivo
	 * @return el recorrido en inorden, String
	 */ 
	public String inOrder() {
		return inOrderRecursivo(raiz);
	}
	
	/**
	 * Genera un String con el recorrido en in-orden
	 * Subárbol izquierdo-Raíz-Subárbol derecho 
	 * (toString de los nodos separados por tabuladores)
	 * Metodo recursivo
	 * @param nodo, BSTNode de tipo generico
	 * @return inorden, String 
	 */
	private String inOrderRecursivo(BSTNode<T> nodo) {
		String inorden = "";
		if (nodo == null)
			return "";
		inorden += inOrderRecursivo(nodo.getLeft());
		inorden += (nodo.toString() + "\t");
		inorden += inOrderRecursivo(nodo.getRight());
		return inorden;
	}

	/** 
	 * Se le pasa el objeto que se quiere borrar
	 * Llama a un metodo recursivo
	 * @param nodo de tipo generico 
	 * @return 0 si lo ha borrado 
	 * -1 si no existe
	 * -2 otra causa 
	 */ 
	public int removeNode(T nodo) {
		if (nodo == null)
			return -2;
		else if (searchNode(nodo) == null)
			return -1;
		setRoot(removeNodeRecursivo(raiz, nodo));
		return 0;
	}
	
	/**
	 * Elimina un nodo del arbol
	 * Metodo recursivo
	 * @param raiz, BSTNode de tipo generico
	 * @param nodo, objeto a añadir de tipo generico
	 * @return el nodo a eliminar, BSTNode de tipo generico
	 */
	private BSTNode<T> removeNodeRecursivo(BSTNode<T> raiz, T nodo) {
		if (raiz == null)
			return null;
		else if (nodo.compareTo(raiz.getInfo()) < 0)
			raiz.setLeft(removeNodeRecursivo(raiz.getLeft(), nodo)); 
		else if (nodo.compareTo(raiz.getInfo()) > 0)
			raiz.setRight(removeNodeRecursivo(raiz.getRight(), nodo));
		else {
			if (raiz.getLeft() == null && raiz.getRight() == null)
				return null;
			else if (raiz.getLeft() == null)
				return raiz.getRight();
			else if (raiz.getRight() == null)
				return raiz.getLeft();
			else {
				raiz.setInfo(getMaxRecursivo(raiz.getLeft()));
				raiz.setLeft(removeNodeRecursivo(raiz.getLeft(), raiz.getInfo()));
			}
		}
		return raiz;
	}

	/**
	 * Busca el nodo mayor del subarbol con raiz pasada como parametro
	 * @param nodo, BSTNode de tipo generico
	 * @return el nodo mayor, tipo generico
	 */
	protected T getMaxRecursivo(BSTNode<T> nodo) {
		if (nodo == null)
			return null;
		else if (nodo.getRight() == null)
			return nodo.getInfo();
		return getMaxRecursivo(nodo.getRight());
	}
	
	/**
	 * Devuelve un String con la informacion del arbol 
     * @return la informacion del arbol
	 */
	public String toString() {
		return tumbarArbol(raiz, 0);
	}

	/**
	 * Genera un String con el arbol "tumbado" (la raiz a la izquierda y las ramas
	 * hacia la derecha) Es un recorrido InOrden-Derecha-Izquierda, tabulando para
	 * mostrar los distintos niveles Utiliza el toString de la informacion
	 * almacenada
	 * @param p, La raiz del arbol a mostrar tumbado
	 * @param esp, El espaciado en numero de tabulaciones para indicar la profundidad
	 * @return El String generado
	 */
	protected String tumbarArbol(BSTNode<T> p, int esp) {
		StringBuilder cadena = new StringBuilder();
		if (p != null) {
			cadena.append(tumbarArbol(p.getRight(), esp + 1));
			for (int i = 0; i < esp; i++)
				cadena.append("\t");
			cadena.append(p + "\n");
			cadena.append(tumbarArbol(p.getLeft(), esp + 1));
		}
		return cadena.toString();
	}

}
