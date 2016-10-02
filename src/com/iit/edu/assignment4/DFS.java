package com.iit.edu.assignment4;

import java.util.Stack;

public class DFS {

	public static void main(String[] args) {
		int[][] graph = new int[7][7];
		int[] visited = new int[7];
		connectEdge(0, 1, graph);
		connectEdge(0, 6, graph);
		connectEdge(1, 3, graph);
		connectEdge(1, 6, graph);
		connectEdge(1, 2, graph);
		connectEdge(1, 3, graph);
		connectEdge(2, 4, graph);
		connectEdge(3, 4, graph);
		connectEdge(6, 4, graph);
		connectEdge(6, 3, graph);
		connectEdge(6, 5, graph);

		System.out.println("DFS Path Traversal is :: " + traverseGraphDFS(graph, visited, 0));
	}

	static String traverseGraphDFS(int[][] graph, int[] visited, int j) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(new Integer(j));
		visited[j] = 1;
		String str = "";
		int currentNode = j;
		while (!stack.isEmpty()) {
			findAdjacentNode(currentNode, graph, visited, stack);
			currentNode = stack.pop();
			str += currentNode;
		}
		return str;
	}

	static void connectEdge(int i, int j, int[][] graph) {
		graph[i][j] = 1;
		graph[j][i] = 1;
	}

	static void findAdjacentNode(int i, int[][] graph, int[] visited, Stack<Integer> stack) {
		for (int j = 0; j < graph[0].length; j++) {
			if (i == j)
				continue;
			else if (graph[i][j] == 1 && visited[j] != 1) {
				System.out.println("Adjesent node to " + i + " :: " + j);
				visited[j] = 1;
				stack.push(j);
				findAdjacentNode(j, graph, visited, stack);
			}
		}
	}
}
