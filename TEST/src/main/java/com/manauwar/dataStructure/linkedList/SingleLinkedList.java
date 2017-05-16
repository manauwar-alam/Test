package com.manauwar.dataStructure.linkedList;

public class SingleLinkedList<T> {

	Node<T> head;
	Node<T> tail;

	void addFirst(T data)
	{

		if(data == null)
		{
			System.out.println("Cannot insert null data");
			return;
		}
		
		Node<T> node = new Node<T>(data,null);

		if(head == null)
		{
			head = node;
			tail = node;
//			System.out.println("Node added with data : "+data);
		}
		else
		{
			node.setNext(head);
			head = node;
//			System.out.println("Node added with data : "+data);
		}

	}


	void addLast(T data)
	{
		if(data == null)
		{
			System.out.println("Cannot insert null data");
			return;
		}
		
		

		if(head == null)
		{
			addFirst(data);
		}
		else 
		{
			
			Node<T> node = new Node<T>(data,null);
			tail.setNext(node);
			tail = node;
//			System.out.println("Node added with data : "+data);
		}

	}
	
	
	void addAfter(T after, T data) {
		
		if(data == null)
			return;
		
		Node<T> currentNode = head;
		Node<T> refNode = null;
		
		while(true)
		{
			if(currentNode == null)
				break;
			
			if(currentNode.compareTo(after) == 0)
			{
				refNode = currentNode;
				break;
			}
			
			
			currentNode = currentNode.getNext();
		}
		
		Node<T> newNode = new Node<T>(data,null);
		

		if(refNode != null)
		{
			newNode.setNext(refNode.getNext());
			refNode.setNext(newNode);
//			System.out.println("Node added with data : "+data);
		}
		else
		{
			System.out.println("Unable to find the given element");
		}
		
	}
	

	public void traverse() {
        
		
		System.out.println("\nThe size of Linked List is : "+getSize());
		
        Node<T> currentNode = head;
        while(true){
            if(currentNode == null){
                break;
            }
            System.out.print(" "+currentNode.getValue()+" ");
            currentNode = currentNode.getNext();
        }
        
//        System.out.println("\n");
	}
	
	
	public int getSize()
	{
		Node<T> currentNode = head;
		int count = 1;
		
		if(currentNode == null)
			return 0;
		else
		{
			while(currentNode.getNext() != null)
			{
				count++;
				
				currentNode = currentNode.getNext();
			}
			
			return count;
		}
		
		
	}
	
	public void addAtPosition(int pos, T data)
	{
		if(pos == 0)
		{
			addFirst(data);
		}
		else if(pos == getSize()+1)
		{
			addLast(data);
		}
		else if(pos > getSize()+1)
		{
			System.out.println("Node Position is out of range cannot insert");
		}
		else
		{
			int count = 1;
			Node<T> node = new Node<T>(data, null);
			Node<T> currentNode = head;
						
			while(currentNode != null)
			{
				count++;
				if(count == pos)
					break;
				currentNode = currentNode.getNext();
			}
			
			node.setNext(currentNode.getNext());
			currentNode.setNext(node);
//			System.out.println("Node added with data : "+data);
			
		}
		
		
		
	}

	
	public void reverseList()
	{
		Node<T> currentNode = head;
		Node<T> previousNode = null;
		Node<T> nextNode = null;
		
		while(currentNode != null)
		{
			nextNode = currentNode.getNext();
			currentNode.setNext(previousNode);
			previousNode = currentNode;
			currentNode = nextNode;
			
		}
		
		head = previousNode;
		System.out.println("\n The reverse Linked List is");
	}
	
	
	
	public void reverseRecursion(Node<T> ptrOne,Node<T> ptrTwo, Node<T> prevNode)
	{
		
		if(ptrTwo!=null)
		{
				if(ptrTwo.next!=null){
					Node<T> t1 = ptrTwo;
					Node<T> t2 = ptrTwo.next;
					ptrOne.next = prevNode;
					prevNode = ptrOne;
					reverseRecursion(t1,t2, prevNode);
				}
				else{
					ptrTwo.next = ptrOne;
					ptrOne.next = prevNode;
					System.out.println("\n Reverse Through Recursion");
					head = ptrTwo;
				}
		}
		else if(ptrOne!=null)
		{
			System.out.println("\n Reverse Through Recursion");
			head = ptrTwo;
		}
	}
	

	public static void main(String[] args) {

		SingleLinkedList<String> ll  = new SingleLinkedList<>();
		ll.addFirst("Data1");
		ll.addFirst("Data2");
		ll.addFirst("Data3");
		ll.addFirst("Data4");
		ll.addFirst("Data5");
	
		ll.addAfter("Data1", "Data6");
		ll.addAfter("Data2", "Data7");
		ll.addAfter("Data5", "Data8");
		
		ll.addFirst("Data9");
		
		ll.addAtPosition(4, "posData4");
		ll.addAtPosition(8, "posData8");
		ll.addAtPosition(15, "posData15");

		ll.traverse();
		
		ll.reverseList();
		ll.traverse();
		
		
	}

}


