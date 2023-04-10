package p3Arboles;

/**
 * Clase EDPriorityQueue
 * @author MariaTeresaFernandezCoro - UO263728
 */
public interface EDPriorityQueue<T extends Comparable<T>> {

	/**
	 * Se le pasa el elemento que se quiere insertar en la cola
	 * Realiza una llamada a filtrado ascendente
	 * @param elemento de tipo generico a insertar
	 * @return 0 si consigue insertarlo
	 * -1 si no cabe
	 * -2 otra causa
	 * Si hay varios errores, se suman
	 */
	public int add(T elemento);

	/**
	 * Saca el elemento del monticulo binario con mayor prioridad
	 * @return el elemento con mayor prioridad (cima del monticulo)
	 * null si no hay elementos
	 */
	public T poll();
	
	/**
	 * Borra un elemento de la cola
	 * @param elemento a eliminar de la cola, de tipo generico
	 * @return 0 si estaba y lo elimina
	 * -1 si no estaba
	 * -2 otras causas
	 */
	public int remove(T elemento);

	/**
	 * Indica si no hay ningun elemento
	 * @return boolean
	 */
	public boolean isEmpty();
	
	/**
	 * Elimina todos los elementos de la cola
	 */
	public void clear();
	
	/**
	 * Devuelve una cadena con la informacion de los elementos que contiene el
	 * monticulo en forma visible (recomendado inorden-derecha-izquierda tabulado)
	 * @return la cadena
	 */
	public String toString();
	
}

