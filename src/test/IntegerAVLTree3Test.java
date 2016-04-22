package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import avmc.AVLTree3;
import avmc.AVLTree3.AvlNode;

public class IntegerAVLTree3Test {

  AVLTree3 createAVLTree() {
    return new AVLTree3();
  }
  
  @Test
  public void simpleInsertTest() {
    AVLTree3 tree = createAVLTree();
    tree.insert(3);
    assertTrue(tree.height(tree.root()) == 0);
    assertTrue(tree.root().key == 3);
  }

  @Test
  public void orderedInsertTest() {
    AVLTree3 tree = createAVLTree();
    tree.insert(1);
    tree.insert(2);
    tree.insert(3);
    AvlNode root = tree.root();
    assertTrue(root.key == 2);
    assertTrue(root.left.key == 1);
    assertTrue(root.right.key == 3);
  }

    
  @Test
  public void disorderedInsertTest() {
    AVLTree3 tree = createAVLTree();
    tree.insert(3);
    tree.insert(1);
    tree.insert(2);
    AvlNode root = tree.root();
    assertTrue(root.key == 2);
    assertTrue(root.left.key == 1);
    assertTrue(root.right.key  == 3);
  }
  
  @Test
  public void removeRootTest() {
    AVLTree3 tree = createAVLTree();
    tree.insert(3);
    tree.insert(1);
    tree.insert(2);
    tree.remove(2);
    assertTrue(tree.root().key == 3);
    assertTrue(tree.root().left.key == 1);
    tree = createAVLTree();
    tree.insert(2);
	tree.insert(4);
	tree.insert(1);
	tree.insert(3);
	assertTrue(tree.root().key == 2);
	tree.remove(2);
	assertTrue(tree.root().key == 3);
	assertTrue(tree.root().left.key == 1);
	assertTrue(tree.root().right.key == 4);
  }
}
