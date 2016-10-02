package com.iit.edu.tree;
public class BinTree {
	public BinTree left=null;
    public BinTree right=null;
    public int data;
    static BinTree root=null;
	public BinTree newNode; 
	
    
    public void insertNewBinNode(int data){
		newNode = new BinTree();
		newNode.data=data;
		if(root==null){
			root= newNode;
		}
		else{
			insertNodeToTree(newNode, root);
		}
	}
    
    private void insertNodeToTree(BinTree newNode, BinTree rootNode) {
		BinTree tempNode=rootNode;
		BinTree parNode=null;
		do{
			parNode=tempNode;
			if(newNode.data < tempNode.data)
				tempNode=tempNode.left;
			else
				tempNode=tempNode.right;			
		}while(tempNode!=null);		
		if(newNode.data< parNode.data){
			parNode.left=newNode;
		}else{
			parNode.right=newNode;
		}		
	}
    
    public BinTree getRootNode(){
		return root;
	}
}
