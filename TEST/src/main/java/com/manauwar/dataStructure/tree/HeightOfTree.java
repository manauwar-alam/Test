package com.manauwar.dataStructure.tree;

public class HeightOfTree {
	
	public Integer getHeightOfNodeInTree(Node root,Integer height, Integer data)
	{
		if(root == null)
			return 0;
		if(root.data == data)
			return height;
		
		Integer level =  getHeightOfNodeInTree(root.left, height+1, data);
		if(level != 0)
			return level;
		
		return getHeightOfNodeInTree(root.right, height+1, data);
		
	}

}
