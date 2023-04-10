package p3Arboles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Clase BSTreeTest
 * Pruebas con JUnit de los metodos de la clase BSTree
 * @author MariaTeresaFernandezCoro-UO263728
 */
class BSTreeTest {

	/**
	 * Test de prueba para los metodos de la clase BSTree
	 */
	@Test
	void testBSTree() {
		BSTree<Integer> bstree = new BSTree<Integer>();
		
		assertEquals(-1,bstree.removeNode(4));
		assertNull(bstree.searchNode(4));
		assertEquals(0,bstree.addNode(4));
		assertEquals("4\t",bstree.preOrder());
		assertNull(bstree.searchNode(null));
		assertEquals(4,bstree.searchNode(4));
		assertEquals(0,bstree.addNode(2));
		assertEquals("4\t2\t",bstree.preOrder());
		assertEquals(0,bstree.addNode(3));
		assertEquals("4\t2\t3\t",bstree.preOrder());
		assertEquals(0,bstree.addNode(6));
		assertEquals("4\t2\t3\t6\t",bstree.preOrder());
		assertEquals(-1,bstree.addNode(3));
		assertEquals(0,bstree.addNode(5));
		assertEquals("4\t2\t3\t6\t5\t",bstree.preOrder());
		assertEquals(0,bstree.addNode(1));
		assertEquals("4\t2\t1\t3\t6\t5\t",bstree.preOrder());
		assertEquals(0,bstree.addNode(7));
		assertEquals("4\t2\t1\t3\t6\t5\t7\t",bstree.preOrder());
		assertEquals(-2,bstree.addNode(null));
		assertNull(bstree.searchNode(8));
		assertEquals(6,bstree.searchNode(6));
		
		assertEquals("4\t2\t1\t3\t6\t5\t7\t",bstree.preOrder());
		assertEquals("1\t2\t3\t4\t5\t6\t7\t",bstree.inOrder());
		assertEquals("1\t3\t2\t5\t7\t6\t4\t",bstree.postOrder());
		
		assertEquals(-1,bstree.removeNode(50));
		assertEquals(0,bstree.removeNode(7));
		assertEquals("4\t2\t1\t3\t6\t5\t",bstree.preOrder());
		assertNull(bstree.searchNode(7));
		assertEquals(-1,bstree.removeNode(7));
		assertEquals(0,bstree.removeNode(4));
		assertEquals("3\t2\t1\t6\t5\t",bstree.preOrder());
		assertEquals(-2,bstree.removeNode(null));
		assertEquals(0,bstree.removeNode(1));
		assertEquals("3\t2\t6\t5\t",bstree.preOrder());
	}
	
	/**
	 * Test de prueba para un arbol con altura minima de 13 nodos
	 */
	@Test
	void test() {
		BSTree<Integer> bstree = new BSTree<Integer>();
		
		assertEquals(0,bstree.addNode(7));
		assertEquals(0,bstree.addNode(4));
		assertEquals(0,bstree.addNode(5));
		assertEquals(0,bstree.addNode(6));
		assertEquals(0,bstree.addNode(2));
		assertEquals(0,bstree.addNode(3));
		assertEquals(0,bstree.addNode(1));
		assertEquals(0,bstree.addNode(11));
		assertEquals(0,bstree.addNode(9));
		assertEquals(0,bstree.addNode(10));
		assertEquals(0,bstree.addNode(8));
		assertEquals(0,bstree.addNode(12));
		assertEquals(0,bstree.addNode(13));
		
		System.out.println(bstree.preOrder());
		System.out.println(bstree.inOrder());
		System.out.println(bstree.postOrder());
		System.out.println(bstree.toString());
		assertEquals("1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12\t13\t",bstree.inOrder());
		
		assertEquals(0,bstree.removeNode(7));
		System.out.println(bstree.toString());
		assertEquals("1\t2\t3\t4\t5\t6\t8\t9\t10\t11\t12\t13\t",bstree.inOrder());
		assertEquals(0,bstree.removeNode(6));
		System.out.println(bstree.toString());
		assertEquals("1\t2\t3\t4\t5\t8\t9\t10\t11\t12\t13\t",bstree.inOrder());
	}
		
	/**
	 * Test de prueba para el metodo remove de la clase BSTree
	 */
	@Test
	void testRemove() {
		BSTree<Integer> b = new BSTree<Integer>();
			
		assertEquals(-1,b.removeNode(8));
			
		assertEquals(0,b.addNode(10));
		assertEquals(0,b.addNode(15));
		assertEquals(0,b.addNode(5));
		assertEquals(0,b.addNode(8));
		assertEquals(0,b.addNode(1));
		assertEquals(0,b.addNode(18));
		assertEquals(0,b.addNode(14));
		assertEquals(0,b.addNode(12));
		System.out.println(b.toString());
		assertEquals("\t\t18\n\t15\n\t\t14\n\t\t\t12\n10\n\t\t8\n\t5\n\t\t1\n",b.toString());
		assertEquals("1\t5\t8\t10\t12\t14\t15\t18\t",b.inOrder());
			
		assertEquals(-2,b.removeNode(null));
			
		assertEquals(-1,b.removeNode(25));
			
		assertEquals(0,b.removeNode(18));
		System.out.println(b.toString());
		assertEquals("1\t5\t8\t10\t12\t14\t15\t",b.inOrder());
			
		assertEquals(0,b.removeNode(14));
		System.out.println(b.toString());
		assertEquals("1\t5\t8\t10\t12\t15\t",b.inOrder());
		
		assertEquals(0,b.removeNode(10));
		System.out.println(b.toString());
		assertEquals("1\t5\t8\t12\t15\t",b.inOrder());
		assertEquals(8,b.searchNode(8));
		assertNull(b.searchNode(10));
			
		assertEquals(0,b.removeNode(5));
		System.out.println(b.toString());
		assertEquals("1\t8\t12\t15\t",b.inOrder());
			
		assertEquals(0,b.removeNode(8));
		System.out.println(b.toString());
		assertEquals("1\t12\t15\t",b.inOrder());
		assertEquals(1,b.searchNode(1));
		assertNull(b.searchNode(8));
			
		assertEquals(0,b.removeNode(1));
		System.out.println(b.toString());
		assertEquals("12\t15\t",b.inOrder());
		assertEquals(15,b.searchNode(15));
		assertNull(b.searchNode(1));
			
		assertEquals(0,b.removeNode(12));
		System.out.println(b.toString());
		assertEquals("15\t",b.inOrder());
			
		assertEquals(0,b.removeNode(15));
		System.out.println(b.toString());
		assertEquals("",b.inOrder());
	}
	
}
