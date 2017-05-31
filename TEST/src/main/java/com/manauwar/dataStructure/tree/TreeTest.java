package com.manauwar.dataStructure.tree;

public class TreeTest {

	public static void main(String[] args) {

		Node root = new Node(12);
		BST tree = new BST(root);
		
		for(int i=1; i<=10;i++)
		{
			tree.insert(i);
		}
		
		for(int i=13; i<=20;i++)
		{
			tree.insert(i);
		}
		
		HeightOfTree heigntOfNode = new HeightOfTree();
		Integer heignt = heigntOfNode.getHeightOfNodeInTree(root, 1, 10);
		System.out.println("Heignt of node 7 is : "+heignt);
	}

}
