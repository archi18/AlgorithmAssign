package com.iit.edu.assignment4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.iit.edu.assignment4.tree.TreeNode;
import com.iit.edu.assignment4.tree.TreeOperation;

public class MinTreeHightBFS {

	public static void main(String[] args) {
		TreeOperation treeOperation = new TreeOperation();
		treeOperation.addTreeNode(20);
		treeOperation.addTreeNode(10);
		treeOperation.addTreeNode(30);
		treeOperation.addTreeNode(5);
		treeOperation.addTreeNode(15);
		treeOperation.addTreeNode(25);
		treeOperation.addTreeNode(40);
		treeOperation.addTreeNode(35);
		treeOperation.addTreeNode(50);
		treeOperation.addTreeNode(2);
		treeOperation.addTreeNode(18);

		// treeOperation.displayTree();

		System.out.println("Minimum depth of tree " + traverseGraphBFS(treeOperation.getRootNode()));

	}

	static int traverseGraphBFS(TreeNode treeNode) {
		TreeNode currentNode = null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(treeNode);
		int count = 0;
		while (!queue.isEmpty()) {
			currentNode = queue.remove();
			count++;
			if (currentNode.getLeft() == null && currentNode.getRight() == null)
				break;
			List<TreeNode> list = findAdjacentNode(currentNode);
			queue.addAll(list);
		}
		System.out.println("last node " + currentNode.getData());
		return findDepthOfnode(currentNode, treeNode);
	}

	static List<TreeNode> findAdjacentNode(TreeNode treeNode) {
		List<TreeNode> treeList = new ArrayList<TreeNode>();
		treeList.add(treeNode.getLeft());
		treeList.add(treeNode.getRight());
		return treeList;

	}

	static int findDepthOfnode(TreeNode treeNode, TreeNode rootNode) {
		int count = 0;
		TreeNode tempNode = rootNode;
		while (tempNode.getLeft() != null || tempNode.getRight() != null) {
			if (treeNode.getData() == tempNode.getData())
				return count;
			else if (treeNode.getData() < tempNode.getData())
				tempNode = tempNode.getLeft();
			else
				tempNode = tempNode.getRight();
			count++;
		}
		return count;
	}
}
