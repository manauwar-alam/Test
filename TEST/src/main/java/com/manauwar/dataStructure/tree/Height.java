package com.manauwar.dataStructure.tree;

public class Height {
	
	public Integer getHeightOfNode(Node root,Integer height, Integer data)
	{
		if(root == null)
			return 0;
		if(root.data == data)
			return height;
		
		Integer level =  getHeightOfNode(root.left, height+1, data);
		if(level != 0)
			return level;
		
		return getHeightOfNode(root.right, height+1, data);
		
	}
	
	public Integer getHeightOfTree(Node root)
	{
		
		if(root == null)
		{
			return 0;
		}
		else
		{
			Integer height = (1 + Math.max(getHeightOfTree(root.left), getHeightOfTree(root.right)));
			return height;
		}
		
	}
	
	

}
