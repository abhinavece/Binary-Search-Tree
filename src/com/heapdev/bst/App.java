package com.heapdev.bst;

public class App {

	public static void main(String[] args) {

		// Tree<Integer> bst = new BinarySearchTree<>();
		// bst.insert(4);
		// bst.insert(2);
		// bst.insert(7);
		// bst.insert(8);
		// bst.insert(5);
		// bst.insert(1);
		// bst.insert(6);

		// Tree<String> bst = new BinarySearchTree<>();
		// bst.insert("Abhinav");
		// bst.insert("Vivek");
		// bst.insert("abhinav");
		// bst.insert("Sanchay");
		// bst.insert("Anand");
		// bst.insert("Yuvraj");

		// System.out.println("Max value: " + bst.getMaxValue());
		// System.out.println("Min value: " + bst.getMinValue());
		//
		// bst.traversal();
		// bst.delete(7);

		Tree<Person> personBst = new BinarySearchTree<>();
		personBst.insert(new Person("Abhinav", 26));
		personBst.insert(new Person("Ajeet", 21));
		personBst.insert(new Person("Saroj", 23));
		personBst.insert(new Person("Kuldeep", 32));
		personBst.insert(new Person("Deepak", 28));
		personBst.insert(new Person("Raja", 42));

		personBst.traversal();

	}

}
