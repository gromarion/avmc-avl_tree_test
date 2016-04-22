package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import avmc.AVLTree;

public class IntegerAVLTreeTest {

	AVLTree<Integer> createAVLTree() {
		return new AVLTree();
	}
	
	@Test
	public void simpleInsertTest() {
		AVLTree<Integer> tree = createAVLTree();
		tree.insert(3);
		assertTrue(tree.getRoot().getDepth() == 1);
		assertTrue(tree.getRoot().getData().equals(3));
	}

	@Test
	public void orderedInsertTest() {
		AVLTree<Integer> tree = createAVLTree();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		AVLTree<Integer>.Node<Integer> root = tree.getRoot();
		assertTrue(root.getData().equals(2));
		assertTrue(root.getLeft().getData().equals(1));
		assertTrue(root.getRight().getData().equals(3));
	}
	
	@Test
	public void disorderedInsertTest() {
		AVLTree<Integer> tree = createAVLTree();
		tree.insert(3);
		tree.insert(1);
		tree.insert(2);
		AVLTree<Integer>.Node<Integer> root = tree.getRoot();
		assertTrue(root.getData().equals(2));
		assertTrue(root.getLeft().getData().equals(1));
		assertTrue(root.getRight().getData().equals(3));
	}
	
	@Test
	public void searchFor2Test() {
		AVLTree<Integer> tree = createAVLTree();
		tree.insert(3);
		tree.insert(1);
		tree.insert(2);
		assertTrue(tree.search(2));
		assertTrue(tree.search(1));
		assertTrue(tree.search(3));
	}
}
