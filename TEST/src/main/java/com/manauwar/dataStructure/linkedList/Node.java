package com.manauwar.dataStructure.linkedList;

public class Node<T> implements Comparable<T>
{
	T value;
	Node<T> link;
	
	public Node(T value, Node<T> link)
	{
		this.value = value;
		this.link = link;
	}
	
	public void setValue(T value)
	{
		this.value = value;
	}
	
	public T getValue()
	{
		return value;
	}
	
	public void setLink(Node<T> link)
	{
		this.link = link;
	}
	
	public Node<T> getLink(){
		return link;
	}

	@Override
	public int compareTo(T arg) {
		if(arg == this.value)
		return 0;
		else
			return 1;
	}
}
