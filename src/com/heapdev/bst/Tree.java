package com.heapdev.bst;

public interface Tree<T> {

	public void traversal();

	public void insert(T data);

	public void delete(T Data);

	public T getMaxValue();
	
	public T getMinValue();

}
