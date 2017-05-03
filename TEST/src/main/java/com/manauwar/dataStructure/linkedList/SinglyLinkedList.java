package com.manauwar.dataStructure.linkedList;

public class SinglyLinkedList<T> {

	Node<T> head;
	Node<T> tail;

	void addFirst(T data)
	{

		if(data == null)
			return;

		Node<T> node = new Node<T>(data,null);

		if(head == null)
		{
			head = node;
			tail = node;
			System.out.println("Node added with data : "+data);
		}
		else
		{
			node.setLink(head);
			head = node;
			System.out.println("Node added with data : "+data);
		}

	}


	void addLast(T data)
	{
		if(data == null)
			return;
		Node<T> node = new Node<T>(data,null);

		if(head == null)
		{
			head = node;
			tail = node;
			System.out.println("Node added with data : "+data);
		}
		else 
		{
			tail.setLink(node);
			tail = node;
			System.out.println("Node added with data : "+data);
		}

	}
	
	
	void addAfter(T after, T data){
		
		if(data == null)
			return;
		
		Node<T> temp = head;
		Node<T> refNode = null;
		
		while(true)
		{
			if(temp == null)
				break;
			
			if(temp.compareTo(after) == 0)
			{
				refNode = temp;
				break;
			}
			
			
			temp = temp.getLink();
		}
		
		Node<T> newNode = new Node<T>(data,null);
		
//		if(tail == refNode)
//		{
//			refNode.setLink(newNode);
//			tail = newNode;
//		}
		if(refNode != null)
		{
			newNode.setLink(refNode.getLink());
			refNode.setLink(newNode);
			System.out.println("Node added with data : "+data);
		}
		else
		{
			System.out.println("Unable to find the given element");
		}
		
	}
	

	public void traverse(){
        
        Node<T> tmp = head;
        while(true){
            if(tmp == null){
                break;
            }
            System.out.println(tmp.getValue());
            tmp = tmp.getLink();
        }
	}


	public static void main(String[] args) {

		SinglyLinkedList<String> ll  = new SinglyLinkedList<>();
		ll.addFirst("Data1");
	
		
		ll.addAfter("Data1", "Data2");
		ll.addAfter("Data2", "Data3");
		ll.addAfter("Data4", "Data4");
		
		ll.addFirst("Data5");
//		ll.traverse();
		
		
	}

}


