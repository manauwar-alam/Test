package com.manauwar.dataStructure.linkedList;

public class Node<T> implements Comparable<T>
{
	T value;
	Node<T> next;
	
	public Node(T value, Node<T> next)
	{
		this.value = value;
		this.next = next;
	}
	
	public void setValue(T value)
	{
		this.value = value;
	}
	
	public T getValue()
	{
		return value;
	}
	
	public void setNext(Node<T> next)
	{
		this.next = next;
	}
	
	public Node<T> getNext(){
		return next;
	}

	@Override
	public int compareTo(T arg) {
		if(arg == this.value)
		return 0;
		else
			return 1;
	}
}
