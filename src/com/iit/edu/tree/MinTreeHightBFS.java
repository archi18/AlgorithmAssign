package com.iit.edu.tree;
import java.util.LinkedList;
import java.util.Queue;

public class MinTreeHightBFS {

	public static void main(String[] args){
		BinTree binTree=new BinTree();
		binTree.insertNewBinNode(20);
		binTree.insertNewBinNode(10);
		binTree.insertNewBinNode(30);
		binTree.insertNewBinNode(5);
		binTree.insertNewBinNode(15);
		binTree.insertNewBinNode(25);
		binTree.insertNewBinNode(40);
		binTree.insertNewBinNode(35);
		binTree.insertNewBinNode(50);
		binTree.insertNewBinNode(2);
		binTree.insertNewBinNode(18);

		System.out.println("Mim Hops  "+traverseGraphBFS(binTree.getRootNode()));
		
	}
	static int traverseGraphBFS(BinTree root){
		BinTree currentNode=null;
		Queue<BinTree> queue= new LinkedList<BinTree>();
		queue.add(root);
		int hop=0;
		BinTree tempNode = root;
		while(!queue.isEmpty()){
			 currentNode = queue.remove();
			 if(currentNode.left==null && currentNode.right==null)
				 break; 
			 queue.add(currentNode.left);
			 queue.add(currentNode.right);
		}	
		
		
		while(tempNode.left!=null || tempNode.right!=null){
			if(currentNode.data == tempNode.data)
				return hop;
			else if(currentNode.data>tempNode.data)
				tempNode=tempNode.right;
			else
				tempNode=tempNode.left;
			hop++;
		}
		
		return hop;
	}
	
	
}
