package p3Arboles;

/**
 * Clase EDBinaryHeap
 * @author MariaTeresaFernandezCoro - UO263728
 */
public class EDBinaryHeap<T extends Comparable<T>> implements EDPriorityQueue<T> {

	protected T[] elementos;	// Array de elementos del monticulo binario
	protected int numElementos;	// Numero de elementos del monticulo binario

	/**
	 * Constructor
	 * @param numMaxElementos, int
	 * Inicializa el array de elementos del monticulo binario
	 */
	@SuppressWarnings("unchecked")
	public EDBinaryHeap(int numMaxElementos) {
		elementos = (T[]) new Comparable[numMaxElementos];
	}

	/**
	 * Se le pasa el elemento que se quiere insertar en la cola
	 * Realiza una llamada a filtrado ascendente
	 * @return 0 si consigue insertarlo
	 * -1 si no cabe
	 * -2 otra causa
	 * Si hay varios errores, se suman
	 */
	@Override
	public int add(T info) {
		if (numElementos == elementos.length) {
			if (info == null)
				return -3;
			return -1;
		}
		if (info == null)
			return -2;
		int i = numElementos;
		elementos[i] = info;
		numElementos++;
		filtradoAscendente(i);
		return 0;
	}

	/**
	 * Saca el elemento del monticulo binario con mayor prioridad
	 * @return el elemento con mayor prioridad (cima del monticulo)
	 * null si no hay elementos
	 */
	@Override
	public T poll() {
		if (isEmpty())
			return null;
		T ele = elementos[0];
		remove(ele);
		return ele;
	}
	
	/**
	 * Borra un elemento de la cola
	 * @param info, elemento que se quiere eliminar de la cola, de tipo generico
	 * @return 0 si estaba y lo elimina
	 * -1 si no estaba
	 * -2 otras causas
	 */
	@Override
	public int remove(T info) {
		if (info == null || isEmpty())
			return -2;
		int pos = -1;
		for (int i = 0; i < numElementos; i++) {
			if (elementos[i] == info)
				pos = i;
		}
		if (pos == -1)
			return pos;
		elementos[pos] = elementos[numElementos-1];
		numElementos--;
		if (pos*2+2 < numElementos)
			filtradoDescendente(pos);
		else
			filtradoAscendente(pos);
		return 0;
	}

	/**
	 * Indica si no hay ningun elemento
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() {
		return numElementos == 0;
	}

	/**
	 * Elimina todos los elementos de la cola
	 */
	@Override
	public void clear() {
		numElementos = 0;
	}

	/**
	 * Devuelve una cadena con la informacion de los elementos que contiene el
	 * monticulo en forma visible (recomendado inorden-derecha-izquierda tabulado)
	 * @return la cadena
	 */
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append(inOrdenDerechaTabulado(0, 0));
		return cadena.toString();
	}

	/**
	 * Crea una cadena con la informacion del monticulo binario tumbado
	 * @param p, int
	 * @param esp, int
	 * @return cadena, string
	 */
	private String inOrdenDerechaTabulado(int p, int esp) {
		String cadena = "";
		if (p < numElementos) {
			int izq = Math.abs(2 * p + 1);
			int der = Math.abs(2 * p + 2);
			cadena += inOrdenDerechaTabulado(der, esp + 1);
			for (int i = 0; i < esp; i++)
				cadena += "\t";
			cadena += elementos[p] + "\n";
			cadena += inOrdenDerechaTabulado(izq, esp + 1);
		}
		return cadena;
	}

	/**
	 * Realiza una filtrado ascendente de minimos en el monticulo
	 * @param i, indice del elemento a filtrar
	 */
	protected void filtradoAscendente(int i) {
		if (elementos[(i-1)/2].compareTo(elementos[i]) > 0) {
			T aux = elementos[(i-1)/2];
			elementos[(i-1)/2] = elementos[i];
			elementos[i] = aux;
		}
		i = (i-1)/2;
		if (i > 0)
			filtradoAscendente(i);
	}
	
	/**
	 * Realiza una filtrado descendente de minimos en el monticulo
	 * @param i, indice del elemento a filtrar
	 */
    protected void filtradoDescendente(int i) {
    	int hizq = 2*i+1;
		int hdch = 2*i+2;
		if (elementos[i].compareTo(elementos[hizq]) > 0 || elementos[i].compareTo(elementos[hdch]) > 0) {
			if (elementos[hizq].compareTo(elementos[hdch]) > 0) {
				T tmp = elementos[hdch];
				elementos[hdch] = elementos[i];
				elementos[i] = tmp;
				i = hdch;
			}
			else {
				T tmp = elementos[hizq];
				elementos[hizq] = elementos[i];
				elementos[i] = tmp;
				i = hizq;
			}
		}
		if (i*2+2 < numElementos)
			filtradoDescendente(i);
    }

}
