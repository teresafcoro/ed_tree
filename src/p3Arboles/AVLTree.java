package p3Arboles; 

/** 
 * Clase AVLTree
 * Deriva de la clase BSTree
 * @author MariaTeresaFernandezCoro - UO263728
 */ 
public class AVLTree<T extends Comparable<T>> extends BSTree <T> {

	/**
	 * Añade un nodo al arbol AVL
	 * Llama a un metodo recursivo
	 * @param nodo de tipo generico a añadir
	 * @return 0 si lo añade
	 * -1 si ya existe el nodo
	 * -2 en otro caso
	 */
	public int addNode(T nodo) {
		if (nodo == null)
			return -2;
		else if (searchNode(nodo) != null)
			return -1;
		setRoot(addNodoRecursivo((AVLNode<T>) getRoot(), nodo));
		return 0;
	}
	
	/**
	 * Añade un nodo al arbol AVL
	 * Metodo recursivo
	 * @param raiz, AVLNode de tipo generico
	 * @param nodo de tipo generico a añadir
	 * @return el nodo a añadir, AVLNode de tipo generico
	 */
	private AVLNode<T> addNodoRecursivo(AVLNode<T> raiz, T nodo) {
		if (raiz == null)
			return new AVLNode<T>(nodo);
		else if (nodo.compareTo(raiz.getInfo()) == 0)
			return updateAndBalanceIfNecesary(raiz);
		else if (nodo.compareTo(raiz.getInfo()) < 0) {
			raiz.setLeft(addNodoRecursivo(raiz.getLeft(), nodo));
			return updateAndBalanceIfNecesary(raiz);
		}
		else if (nodo.compareTo(raiz.getInfo()) > 0) {
			raiz.setRight(addNodoRecursivo(raiz.getRight(), nodo));
			return updateAndBalanceIfNecesary(raiz);
		}
		return raiz;
	}

	/**
	 * Se le pasa la raiz del arbol a actualizar
	 * Su altura y factor de balance
	 * Balancear si fuese necesario
	 * @param nodo, AVLNode de tipo generico
	 * @return la raiz del arbol tras posibles modificaciones
	 */
	private AVLNode<T> updateAndBalanceIfNecesary(AVLNode<T> raiz) {
		raiz.updateHeight();
		if (raiz.getBF() == -2) {
			if (raiz.getLeft().getBF() == 1)
				return doubleLeftRotation(raiz);
			return singleLeftRotation(raiz);
		}
		if (raiz.getBF() == 2) {
			if (raiz.getRight().getBF() == -1)
				return doubleRightRotation(raiz);
			return singleRightRotation(raiz);
		}
		return raiz;
	}
	
	/**
	 * Se le pasa la raiz del arbol a balancear con rotacion simple izquierda
	 * @param nodo, AVLNode de tipo generico
	 * @return la raiz del nuevo arbol que ha balanceado, AVLNode de tipo generico
	 */
	private AVLNode<T> singleLeftRotation(AVLNode<T> nodo){
		AVLNode<T> aux = nodo.getLeft();
		nodo.setLeft(aux.getRight());
		updateAndBalanceIfNecesary(nodo);
		aux.setRight(nodo);
        return updateAndBalanceIfNecesary(aux);
	}

	/**
	 * Se le pasa la raiz del arbol a balancear con rotacion doble izquierda
	 * @param nodo, AVLNode de tipo generico
	 * @return la raiz del nuevo arbol que ha balanceado, AVLNode de tipo generico
	 */
	private AVLNode<T> doubleLeftRotation(AVLNode<T> nodo) {
		nodo.setLeft(singleRightRotation(nodo.getLeft()));
        return singleLeftRotation(nodo);
	}

	/**
	 * Se le pasa la raiz del arbol a balancear con rotacion simple derecha
	 * @param nodo, AVLNode de tipo generico
	 * @return la raiz del nuevo arbol que ha balanceado, AVLNode de tipo generico
	 */
	private AVLNode<T> singleRightRotation(AVLNode<T> nodo){
		AVLNode<T> aux = nodo.getRight();
		nodo.setRight(aux.getLeft());
		updateAndBalanceIfNecesary(nodo);
		aux.setLeft(nodo);
        return updateAndBalanceIfNecesary(aux);
	} 

	/**
	 * Se le pasa la raiz del arbol a balancear con rotacion doble derecha
	 * @param nodo, AVLNode de tipo generico
	 * @return la raiz del nuevo arbol que ha balanceado, AVLNode de tipo generico
	 */
	private AVLNode<T> doubleRightRotation(AVLNode<T> nodo) {
		nodo.setRight(singleLeftRotation(nodo.getRight()));
        return singleRightRotation(nodo);
	}
	
	/**
	 * Elimina un nodo del arbol
	 * @param nodo de tipo generico
	 * @return 0 si lo elimina
	 */
	public int removeNode(T nodo) {
		if (nodo == null)
			return -2;
		else if (searchNode(nodo) == null)
			return -1;
		setRoot(removeNodeRecursivo((AVLNode<T>) getRoot(), nodo));
		return 0;
	}
	
	/**
	 * Elimina un nodo del arbol
	 * Metodo recursivo
	 * @param raiz, AVLNode de tipo generico
	 * @param nodo, objeto a añadir de tipo generico
	 * @return el nodo a eliminar, AVLNode de tipo generico
	 */
	private AVLNode<T> removeNodeRecursivo(AVLNode<T> raiz, T nodo) {
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
			else {
				raiz.setInfo(getMaxRecursivo(raiz.getLeft()));
				raiz.setLeft(removeNodeRecursivo(raiz.getLeft(), raiz.getInfo()));
			}
		}
		return updateAndBalanceIfNecesary(raiz);
	}

}
