package p3Arboles;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Clase AVLTreeTest
 * Pruebas con JUnit de los metodos de la clase AVLTree
 * @author MariaTeresaFernandezCoro - UO263728
 */
class AVLTreeTest {

	/**
	 * Test de prueba que añade 5 nodos a un arbol AVL
	 */
	@Test
	void test() {
		AVLTree<Integer> avl = new AVLTree<Integer>();
		
		assertEquals(0, avl.addNode(10));
		assertEquals(0, avl.addNode(7));
		assertEquals(0, avl.addNode(4));
		assertEquals(0, avl.addNode(3));
		assertEquals(0, avl.addNode(1));
		
		System.out.println(avl.toString());
		assertEquals("1:BF=0\t3:BF=0\t4:BF=0\t7:BF=-1\t10:BF=0\t", avl.inOrder());
	}
	
	/**
	 * Test de prueba para la clase AVLTree
	 */
	@Test
	void testAVLTree() {
		AVLTree<Integer> avl = new AVLTree<Integer>();
		
		assertEquals(0, avl.addNode(8));
		assertEquals(0, avl.addNode(14));
		assertEquals(-2, avl.addNode(null));
		assertEquals(0, avl.addNode(18));	// RSD(8)
		assertEquals(0, avl.addNode(4));
		assertEquals(0, avl.addNode(1));	// RSI(8)
		assertEquals(0, avl.addNode(3));	// RSI(14)
		assertEquals(-1, avl.addNode(3));
		assertEquals(0, avl.addNode(7));
		assertEquals(0, avl.addNode(24));
		assertEquals(0, avl.addNode(28));	// RSD(18)
		assertEquals(0, avl.addNode(2));	// RDD(1)
		assertEquals(0, avl.addNode(0));
		assertEquals(0, avl.addNode(16));
		assertEquals(0, avl.addNode(19));
		assertEquals(0, avl.addNode(20));	// RDI(24)
		
		System.out.println(avl.toString());
		assertEquals("0:BF=0\t1:BF=-1\t2:BF=-1\t3:BF=0\t4:BF=1\t7:BF=0\t8:BF=-1\t14:BF=1\t16:BF=0\t"
				+ "18:BF=-1\t19:BF=0\t20:BF=0\t24:BF=0\t28:BF=0\t", avl.inOrder());
		
		assertEquals(0, avl.removeNode(0));		// RSD(4)
		System.out.println(avl.toString());
		assertEquals("1:BF=0\t2:BF=0\t3:BF=0\t4:BF=0\t7:BF=0\t8:BF=-1\t14:BF=0\t16:BF=0\t"
				+ "18:BF=-1\t19:BF=0\t20:BF=0\t24:BF=0\t28:BF=0\t", avl.inOrder());
		
		assertEquals(0, avl.removeNode(14));
		System.out.println(avl.toString());
		
		assertEquals("1:BF=0\t2:BF=0\t3:BF=0\t4:BF=-1\t7:BF=0\t8:BF=0\t16:BF=0\t18:BF=-1\t"
				+ "19:BF=0\t20:BF=0\t24:BF=0\t28:BF=0\t", avl.inOrder());
		assertEquals("1:BF=0\t3:BF=0\t2:BF=0\t7:BF=0\t4:BF=-1\t16:BF=0\t18:BF=-1\t20:BF=0\t"
				+ "28:BF=0\t24:BF=0\t19:BF=0\t8:BF=0\t", avl.postOrder());
		assertEquals("8:BF=0\t4:BF=-1\t2:BF=0\t1:BF=0\t3:BF=0\t7:BF=0\t19:BF=0\t18:BF=-1\t"
				+ "16:BF=0\t24:BF=0\t20:BF=0\t28:BF=0\t", avl.preOrder());
		
		assertEquals(-2, avl.removeNode(null));
		assertEquals(-1, avl.removeNode(80));
	}
	
	/**
	 * Test de prueba con mas de una rotacion tras remove
	 */
	@Test
	void testMasDeUnaRotacionEnRemove() {
		AVLTree<Integer> avl = new AVLTree<Integer>();
		
		assertEquals(0, avl.addNode(8));
		assertEquals(0, avl.addNode(5));
		assertEquals(0, avl.addNode(11));
		assertEquals(0, avl.addNode(3));
		assertEquals(0, avl.addNode(7));
		assertEquals(0, avl.addNode(10));
		assertEquals(0, avl.addNode(12));
		assertEquals(0, avl.addNode(2));
		assertEquals(0, avl.addNode(4));
		assertEquals(0, avl.addNode(6));
		assertEquals(0, avl.addNode(9));
		assertEquals(0, avl.addNode(1));
		System.out.println(avl.toString());
		
		assertEquals(0, avl.removeNode(12));	// RSI(11)+RSI(8)
		System.out.println(avl.toString());
		assertEquals(0, avl.removeNode(4));		// RSI(3)
		System.out.println(avl.toString());
		assertEquals(0, avl.removeNode(10));
		System.out.println(avl.toString());
	}
	
}
