package com.iit.edu.assignment6;

import java.util.Stack;

public class CycleDetectDFS {
	static String traverseGraphDFS(int[][] graph, int[] visited, int[][] VisitedEdge, int j) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(new Integer(j));
		visited[j] = 1;
		String str = "";
		int currentNode = j;
		while (!stack.isEmpty()) {
			findAdjacentNode(currentNode, graph, visited, VisitedEdge, stack);
			currentNode = stack.pop();
			str += currentNode;
		}
		return str;
	}

	static void findAdjacentNode(int i, int[][] graph, int[] visited,int[][] VisitedEdge, Stack<Integer> stack) {
		for (int j = 0; j < graph[0].length; j++) {
			if (i == j)
				continue;
			else if (graph[i][j] == 1 && visited[j] != 1 && VisitedEdge[i][j]==1) {
				visited[j] = 1;
				stack.push(j);
				findAdjacentNode(j, graph, visited,VisitedEdge, stack);
			}
		}
	}	
}
