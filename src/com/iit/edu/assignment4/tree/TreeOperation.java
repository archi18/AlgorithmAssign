package com.iit.edu.assignment4.tree;

public class TreeOperation {
	static TreeNode rootNode=null;
	public TreeNode newNode; 
	
	public void addTreeNode(int data){
		newNode = new TreeNode(null, null, data);
		if(rootNode==null){
			rootNode= newNode;
			System.out.println("Root Node Created");
		}
		else{
			addTreeNode(newNode, rootNode);
		}
	}

	private void addTreeNode(TreeNode newNode, TreeNode rootNode) {
		TreeNode tempNode=rootNode;
		TreeNode parNode=null;
		do{
			parNode=tempNode;
			if(newNode.data < tempNode.data)
				tempNode=tempNode.left;
			else
				tempNode=tempNode.right;
			
		}while(tempNode!=null);
		
		if(newNode.data< parNode.data){
			parNode.left=newNode;
			System.out.println(newNode.data+"Data inserted at left side of parent node "+parNode.data);
		}else{
			parNode.right=newNode;
			System.out.println(newNode.data+"Data inserted at right side of parent node "+parNode.data);
		}
			
	}
	public void displayTree(){
		displayTree(rootNode);
	}
	public void displayTree(TreeNode rootNode){
		TreeNode tempNode=rootNode;
			if(tempNode.left==null){
				System.out.println("Node is "+tempNode.data);
				return;
			}else
				displayTree(tempNode.left);
			System.out.println("Node is :: "+tempNode.data);
			if(tempNode.right==null){
				System.out.println("Node is "+tempNode.data);
				return;
			}
			else
				displayTree(tempNode.right);
		
	}
	
	public TreeNode getRootNode(){
		return rootNode;
	}
	
}
