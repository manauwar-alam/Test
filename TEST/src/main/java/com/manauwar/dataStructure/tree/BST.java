package com.manauwar.dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
	
	public Node root;
	
	public BST(Node root) {
		
		this.root = root;
	}
	
	
	public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
	
	public void levelOrderTraverdalUsingQueue(Node root){
 		Queue q = new LinkedList();
 		int levelNodes =0; 
		if(root==null) return;
 		q.add(root);
 		while(!q.isEmpty()){
 			levelNodes = q.size();
 			while(levelNodes>0){
				Node n = (Node)q.remove();
				System.out.print(" " + n.data);
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
				levelNodes--;
			}
			System.out.println("");
		}
	}
	
	
	
	public void insert(int data) {
		
		Node newNode = new Node(data);
		
//		if(root==null)
//		{
//			root = newNode;
//			return;
//		}
		
		Node current = root;
		Node parent = null;
		
		while(true)
		{
			parent = current;
			
			if(data < current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	
	public boolean find(int id){
		Node current = root;
		
		while(current!=null){
			
			if(current.data == id){
				return true;
			}else if(current.data>id){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		
		return false;
	}
	
	
	public Node getSuccessor(Node deleleNode)
	{
		Node successsor =null;
		Node successsorParent =null;
		Node current = deleleNode.right;
		
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}
	

}
