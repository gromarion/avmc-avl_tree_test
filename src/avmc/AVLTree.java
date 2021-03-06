package avmc;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<T extends Comparable<T>> {
	Node<T> root;

	public Node<T> getRoot() {
		return root;
	}
	
	public AVLTree() {
		root = null;
	}

	public T Maximum() {
		Node<T> local = root;
		if (local == null)
			return null;
		while (local.getRight() != null)
			local = local.getRight();
		return local.getData();
	}

	public T Minimum() {
		Node<T> local = root;
		if (local == null)
			return null;
		while (local.getLeft() != null) {
			local = local.getLeft();
		}
		return local.getData();
	}

	private int depth(Node<T> node) {
		if (node == null)
			return 0;
		return node.getDepth();
		// 1 + Math.max(depth(node.getLeft()), depth(node.getRight()));
	}

	public Node<T> insert(T data) {
		root = insert(root, data);
		int balance = balanceNumber(root);
		switch (balance) {
		case 1:
			root = rotateLeft(root);
			break;
		case -1:
			root = rotateRight(root);
			break;
		default:
			break;
		}
		return root;
	}

	public Node<T> insert(Node<T> node, T data) {
		if (node == null)
			return new Node<T>(data);
		if (node.getData().compareTo(data) > 0) {
			node = new Node<T>(node.getData(), insert(node.getLeft(), data),
					node.getRight());
			// node.setLeft(insert(node.getLeft(), data));
		} else if (node.getData().compareTo(data) < 0) {
			// node.setRight(insert(node.getRight(), data));
			node = new Node<T>(node.getData(), node.getLeft(), insert(
					node.getRight(), data));
		}
		// After insert the new node, check and rebalance the current node if
		// necessary.
		int balance = balanceNumber(node);
		switch (balance) {
		case 1:
			node = rotateLeft(node);
			break;
		case -1:
			node = rotateRight(node);
			break;
		default:
			return node;
		}
		return node;
	}

	private int balanceNumber(Node<T> node) {
		int L = depth(node.getLeft());
		int R = depth(node.getRight());
		if (L - R >= 2)
			return -1;
		else if (L - R <= -2)
			return 1;
		return 0;
	}

	private Node<T> rotateLeft(Node<T> node) {
		Node<T> q = node;
		Node<T> p = q.getRight();
		Node<T> c = q.getLeft();
		Node<T> a = p.getLeft();
		Node<T> b = p.getRight();
		q = new Node<T>(q.getData(), c, a);
		p = new Node<T>(p.getData(), q, b);
		return p;
	}

	// El problema está en esta función: Cuando se chequea si la raíz del árbol se encuentra desbalanceada (-1),
	// el algoritmo rota mal los nodos. El siguiente arbol:
	//        3 q
	//       / \
	//    p 1   null c
	//     / \
	//a null  2 b
	//
	// Queda rotado de la siguiente manera:
	//
	//       1 p
	//      / \
	//   null  3 q
	//        / \
	//     b 2   null c
	//
	private Node<T> rotateRight(Node<T> node) {
		Node<T> q = node;
		Node<T> p = q.getLeft();
		Node<T> c = q.getRight();
		Node<T> a = p.getLeft();
		Node<T> b = p.getRight();
		q = new Node<T>(q.getData(), b, c);
		p = new Node<T>(p.getData(), a, q);
		return p;
	}

	public boolean search(T data) {
		Node<T> local = root;
		while (local != null) {
			if (local.getData().compareTo(data) == 0)
				return true;
			else if (local.getData().compareTo(data) > 0)
				local = local.getLeft();
			else
				local = local.getRight();
		}
		return false;
	}

	public String toString() {
		return root.toString();
	}

	public void PrintTree() {
		root.level = 0;
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<T> node = queue.poll();
			System.out.println(node);
			int level = node.level;
			Node<T> left = node.getLeft();
			Node<T> right = node.getRight();
			if (left != null) {
				left.level = level + 1;
				queue.add(left);
			}
			if (right != null) {
				right.level = level + 1;
				queue.add(right);
			}
		}
		
	}
	
	/**
	 * 
	 */

	/**
	 * @author antonio081014
	 * @time Jul 5, 2013, 9:31:32 PM
	 */
	public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

		private T data;
		private Node<T> left;
		private Node<T> right;
		public int level;
		private int depth;

		public Node(T data) {
			this(data, null, null);
		}

		public Node(T data, Node<T> left, Node<T> right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
			if (left == null && right == null)
				setDepth(1);
			else if (left == null)
				setDepth(right.getDepth() + 1);
			else if (right == null)
				setDepth(left.getDepth() + 1);
			else
				setDepth(Math.max(left.getDepth(), right.getDepth()) + 1);
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getLeft() {
			return left;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

		public Node<T> getRight() {
			return right;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}

		/**
		 * @return the depth
		 */
		public int getDepth() {
			return depth;
		}

		/**
		 * @param depth
		 *            the depth to set
		 */
		public void setDepth(int depth) {
			this.depth = depth;
		}

		@Override
		public int compareTo(Node<T> o) {
			return this.data.compareTo(o.data);
		}

		@Override
		public String toString() {
			return "Level " + level + ": " + data;
		}

	}
}
