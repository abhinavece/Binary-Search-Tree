package com.heapdev.bst;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;

	public void preOrderTraversal(Node<T> node) {
		if (root != null) {
			System.out.println(node);
			if (node.getLeftChild() != null) {
				preOrderTraversal(node.getLeftChild());
			}
			if (node.getRightChild() != null) {
				preOrderTraversal(node.getRightChild());
			}
		}
	}

	public void postOrderTraversal(Node<T> node) {
		if (root != null) {
			if (node.getLeftChild() != null) {
				postOrderTraversal(node.getRightChild());
			}
			if (node.getRightChild() != null) {
				postOrderTraversal(node.getRightChild());
			}
			System.out.println(node);
		}
	}

	@Override
	public void insert(T data) {

		if (root == null) {
			root = new Node<T>(data);
		} else {
			insertNode(data, root);
		}
	}

	@Override
	public void traversal() {
		if (root != null) {
			inOrderTraversal(root);
			preOrderTraversal(root);
			postOrderTraversal(root);
		}
	}

	private void inOrderTraversal(Node<T> node) {
		if (node.getLeftChild() != null) {
			inOrderTraversal(node.getLeftChild());
		}
		System.out.print(node.getData() + " --> ");

		if (node.getRightChild() != null) {
			inOrderTraversal(node.getRightChild());
		}
	}

	private void insertNode(T newData, Node<T> node) {
		if (newData.compareTo(node.getData()) < 0) {
			if (node.getLeftChild() != null) {
				insertNode(newData, node.getLeftChild());
			} else {
				Node<T> newNode = new Node<T>(newData);
				node.setLeftChild(newNode);
			}
		} else if (newData.compareTo(node.getData()) > 0) {
			if (node.getRightChild() != null) {
				insertNode(newData, node.getRightChild());
			} else {
				Node<T> newNode = new Node<T>(newData);
				node.setRightChild(newNode);
			}
		}
	}

	@Override
	public void delete(T data) {
		if (root != null) {
			root = deleteData(root, data);
		}
	}

	private Node<T> deleteData(Node<T> node, T data) {

		if (node == null)
			return null;

		if (data.compareTo(node.getData()) < 0) {
			node.setLeftChild(deleteData(node.getLeftChild(), data));
		} else if (data.compareTo(node.getData()) > 0) {
			node.setRightChild(deleteData(node.getRightChild(), data));
		} else {
			// we have found the node we want to remove

			if (node.getLeftChild() == null && node.getRightChild() == null) {
				// if this is a leaf Node
				System.out.println("Removing Leaf Node... ");
				return null;
			}

			if (node.getLeftChild() == null) {
				System.out.println("Removing the right child...");
				Node<T> tempNode = node.getRightChild();
				node = null;
				return tempNode;

			} else if (node.getRightChild() == null) {
				System.out.println("Removing the left child...");
				Node<T> tempNode = node.getLeftChild();
				node = null;
				return tempNode;
			}

			// This is the Node where two children exist

			System.out.println("Removing item from two children");
			Node<T> tempNode = getPredecessor(node.getLeftChild());
			node.setData(tempNode.getData());
			node.setLeftChild(deleteData(node.getLeftChild(), tempNode.getData()));
		}

		return node;
	}

	private Node<T> getPredecessor(Node<T> node) {
		if (node.getRightChild() != null) {
			return getPredecessor(node.getRightChild());
		}
		System.out.println("Predecessor is: " + node);
		return node;
	}

	@Override
	public T getMinValue() {
		if (root == null) {
			return null;
		} else {
			return getMin(root);
		}
	}

	@Override
	public T getMaxValue() {
		if (root == null) {
			return null;
		} else {
			return getMax(root);
		}
	}

	private T getMax(Node<T> node) {
		if (node.getRightChild() != null) {
			return getMax(node.getRightChild());
		}
		return node.getData();
	}

	private T getMin(Node<T> node) {
		if (node.getLeftChild() != null) {
			return getMin(node.getLeftChild());
		}
		return node.getData();
	}

}
