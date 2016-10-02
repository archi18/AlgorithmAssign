package com.iit.edu.assignment5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
	static int key[];
	static int V[];
	static int pi[];
	static int[][] graph; 
	static int weight[][];
	final static int VERTEX_SIZE=9;
	public static void main(String[] args) {
		
		graph 	= new int[VERTEX_SIZE][VERTEX_SIZE];
		weight  = new int[VERTEX_SIZE][VERTEX_SIZE];
		V   	= new int[VERTEX_SIZE];
		key 	= new int[VERTEX_SIZE];
		pi  	= new int[VERTEX_SIZE];

		for(int i=0; i<VERTEX_SIZE; i++)
			V[i]=i;
		
		graph=generategraph(graph);
		getMSTPrims(V, graph, 0);
		
		for(int i=0; i <VERTEX_SIZE; i++){
			System.out.println(pi[i]+" --> "+i);
		}
		
	}
	
	static void getMSTPrims(int[] vertex, int[][] graph, int r){
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(10, new Comparator<Integer>() {

			@Override
			public int compare(Integer elem1, Integer elem2) {
				if(key[elem1] > key[elem2]){
					return 1;
				}
				if(key[elem1] <= key[elem2]){
					return -1;
				}
				return 0;
			}
		});
		
		for(int i=0; i<vertex.length; i++){
			key[i] = Integer.MAX_VALUE;
			pi[i]  = -1;
		}
		
		key[r] =0;
		
		for(int i=0; i<VERTEX_SIZE; i++)
			priorityQueue.add(vertex[i]);
		
		
		
		while(!priorityQueue.isEmpty()){
			System.out.println("Element in Queue "+priorityQueue);
			int u = priorityQueue.remove();
			List<Integer> adjecentlist = findAdjacentNode(u, graph);
			Iterator<Integer> it = adjecentlist.iterator();
			
			while(it.hasNext()){
				int v= it.next().intValue();
				if(priorityQueue.contains(v) && weight[u][v]<key[v]){	
					System.out.println("for ("+u+")====> ("+v+")");
					pi[v]= u;
					key[v] = weight[u][v];
					System.out.println("updating p["+v+"] = "+u);
					priorityQueue.remove(v);
					priorityQueue.add(v);
				}
				
			}
		}
	}
	
	
	static List<Integer> findAdjacentNode(int i, int[][] graph) {
		List<Integer> list = new ArrayList<Integer>();
		for (int j = 0; j < graph[0].length; j++) {
			if (i == j)
				continue;
			else if (graph[i][j] == 1) {
			//	System.out.println("Adjesent node to " + i + " :: " + j);
				list.add(new Integer(j));
			}
		}

		return list;
	}
	
	static int[][] generategraph(int[][] graph){
		connectEdge(0, 1,4, graph);
		connectEdge(0, 7,8, graph);
		
		connectEdge(1, 2,8, graph);
		connectEdge(1, 7,11, graph);
		
		connectEdge(2, 3,7, graph);
		connectEdge(2, 5,4, graph);
		connectEdge(2, 8,2, graph);
		
		connectEdge(3, 4,9, graph);
		connectEdge(3, 5,14, graph);
		
		connectEdge(4, 5,10, graph);
		
		connectEdge(5, 6, 2, graph);
		
		connectEdge(6, 7, 1, graph);
		connectEdge(6, 8,6, graph);
		
		connectEdge(7, 8,7, graph);
		
		return graph;
	}
	
	static void connectEdge(int i, int j, int w, int[][] graph) {
		graph[i][j] = 1;
		graph[j][i] = 1;
		
		weight[i][j] = w;
		weight[j][i] = w;
	}

}
