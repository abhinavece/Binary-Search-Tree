package com.heapdev.bst;

/**
 * 
 * @author Abhinav
 * 
 *         Implementing Binary Search tree for User Defined dataType ::
 *         Facebook, Linkedin uses same way for quick search results
 *
 */

public class Person implements Comparable<Person> {

	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// @Override
	// public int compareTo(Person person) {
	// return name.compareTo(person.getName());
	// }

	@Override
	public int compareTo(Person person) {
		return age - person.getAge();
	}

	@Override
	public String toString() {
		return name + " => " + age;
	}

}
