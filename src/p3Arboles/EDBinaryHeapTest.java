package p3Arboles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Clase EDBinaryHeapTest
 * Pruebas con JUnit de los metodos de la clase EDBinaryHeap
 * @author MariaTeresaFernandezCoro-UO263728
 */
class EDBinaryHeapTest {

	/**
	 * Test metodo add con ejemplo de clase
	 */
	@Test
	void testAdd() {
		EDBinaryHeap<Integer> b = new EDBinaryHeap<Integer>(12);
		
		assertEquals(0, b.add(3));
		System.out.println(b.toString());
		assertEquals(0, b.add(1));
		System.out.println(b.toString());
		assertEquals(0, b.add(9));
		System.out.println(b.toString());
		assertEquals(0, b.add(5));
		System.out.println(b.toString());
		assertEquals(0, b.add(2));
		System.out.println(b.toString());
		assertEquals(0, b.add(8));
		System.out.println(b.toString());
		assertEquals(0, b.add(7));
		System.out.println(b.toString());
		assertEquals(0, b.add(4));
		System.out.println(b.toString());
		assertEquals(0, b.add(4));
		System.out.println(b.toString());
	}
	
	/**
	 * Test de prueba de un montículo binario de enteros
	 */
	@Test
	void test() {
		EDBinaryHeap<Integer> b = new EDBinaryHeap<Integer>(17);
		
		System.out.println("\n\n");
		
		assertEquals(null, b.poll());
		assertEquals(-2, b.remove(1));
		assertEquals(-2, b.remove(null));
		assertEquals(0, b.add(60));
		assertEquals(0, b.add(40));
		assertEquals(0, b.add(80));
		assertEquals(0, b.add(20));
		assertEquals(0, b.add(55));
		assertEquals(-1, b.remove(90));
		assertEquals(0, b.add(65));
		assertEquals(0, b.add(63));
		assertEquals(0, b.add(51));
		assertEquals(0, b.add(75));
		assertEquals(0, b.add(2));
		assertEquals(0, b.add(4));
		assertEquals(-2, b.add(null));
		assertEquals(0, b.add(90));
		assertEquals(0, b.add(100));
		assertEquals(0, b.add(41));
		assertEquals(0, b.add(42));
		assertEquals(0, b.add(50));
		assertEquals(0, b.add(22));
		assertEquals(-1, b.add(20));
		assertEquals(-3, b.add(null));
		System.out.println(b.toString());
		System.out.println("-------------------------------");
		assertEquals(0, b.remove(100));
		System.out.println(b.toString());
		System.out.println("-------------------------------");
		assertEquals(0, b.remove(60));
		System.out.println(b.toString());
		System.out.println("-------------------------------");
		assertEquals(0, b.remove(20));
		System.out.println(b.toString());
		System.out.println("-------------------------------");
		assertEquals(2, b.poll());
		System.out.println(b.toString());
	}

}
