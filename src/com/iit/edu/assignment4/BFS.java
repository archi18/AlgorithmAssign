package com.iit.edu.assignment4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

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

		System.out.println("BFS Path traversal :: " + traverseGraphBFS(graph, visited, 0));
	}

	static String traverseGraphBFS(int[][] graph, int[] visited, int j) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(new Integer(j));
		visited[j] = 1;
		String str = "";
		while (!queue.isEmpty()) {
			int currentNode = queue.remove();
			str += currentNode;
			List<Integer> list = findAdjacentNode(currentNode, graph, visited);
			queue.addAll(list);
		}
		return str;
	}

	static void connectEdge(int i, int j, int[][] graph) {
		graph[i][j] = 1;
		graph[j][i] = 1;
	}

	static List<Integer> findAdjacentNode(int i, int[][] graph, int[] visited) {
		List<Integer> list = new ArrayList<Integer>();
		for (int j = 0; j < graph[0].length; j++) {
			if (i == j)
				continue;
			else if (graph[i][j] == 1 && visited[j] != 1) {
				System.out.println("Adjesent node to " + i + " :: " + j);
				list.add(new Integer(j));
				visited[j] = 1;
			}
		}

		return list;
	}
}
