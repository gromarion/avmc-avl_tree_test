package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import avmc.AVLTree2;

public class IntegerAVLTree2Test {

	AVLTree2<Integer> createAVLTree() {
		return new AVLTree2<Integer>();
	}
	
//	@Test
//	public void simpleInsertTest() {
//		AVLTree2<Integer> tree = createAVLTree();
//		tree.insert(3);
//		assertTrue(tree.getRoot().getDepth() == 1);
//		assertTrue(tree.getRoot().getData().equals(3));
//	}

//	@Test
//	public void orderedInsertTest() {
//		AVLTree2<Integer> tree = createAVLTree();
//		tree.insert(1);
//		tree.insert(2);
//		tree.insert(3);
//		AVLTree2<Integer>.Node<Integer> root = tree.getRoot();
//		assertTrue(root.getData().equals(2));
//		assertTrue(root.getLeft().getData().equals(1));
//		assertTrue(root.getRight().getData().equals(3));
//	}
	
//	@Test
//	public void disorderedInsertTest() {
//		AVLTree2<Integer> tree = createAVLTree();
//		tree.insert(3);
//		tree.insert(1);
//		tree.insert(2);
//		AVLTree2<Integer>.Node<Integer> root = tree.getRoot();
//		assertTrue(root.getData().equals(2));
//		assertTrue(root.getLeft().getData().equals(1));
//		assertTrue(root.getRight().getData().equals(3));
//	}
//	
//	@Test
//	public void searchFor2Test() {
//		AVLTree2<Integer> tree = createAVLTree();
//		tree.insert(3);
//		tree.insert(1);
//		tree.insert(2);
//		assertTrue(tree.search(2));
//		assertTrue(tree.search(1));
//		assertTrue(tree.search(3));
//	}
	
	@Test
	public void findMinTest() {
		AVLTree2<Integer> tree = createAVLTree();
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		assertTrue(tree.findMin().equals(4));
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		assertTrue(tree.findMin().equals(1));
	}
	
	@Test
	public void findMaxTest() {
		AVLTree2<Integer> tree = createAVLTree();
		tree.insert(3);
		tree.insert(2);
		tree.insert(1);
		assertTrue(tree.findMax().equals(3));
		tree.insert(6);
		tree.insert(5);
		tree.insert(4);
		assertTrue(tree.findMax().equals(6));
	}
	
	@Test
	public void test() {
		AVLTree2<Integer> tree = createAVLTree();
		tree.insert(2);
		tree.insert(4);
		tree.insert(1);
		tree.insert(3);
		assertTrue(tree.getDepth(tree.root) == 3);
		assertTrue(tree.root.getElement().equals(2));
		tree.remove(2);
		assertTrue(tree.getDepth(tree.root) == 2);
		assertTrue(tree.root.getElement().equals(3));
	}
	
	/* Métodos públicos
	 * public boolean checkOrderingOfTree(AVLTree2.AvlNode<Integer> current)
	 * -- public int getDepth(AVLTree2.AvlNode<Integer> n)
	 * public boolean checkBalanceOfTree(AVLTree2.AvlNode<Integer> current)
	 * public boolean contains(T x)
	 * public void remove( T x ) 
	 * isEmpty
	 * makeEmpty
	 * max/min
	 * height
	 */
}
