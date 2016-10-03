package com.iit.edu.assignment5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstras {

	static int d[];
	static int V[];
	static int pi[];
	static int[][] graph; 
	static int weight[][];
	final static int VERTEX_SIZE=5;
	public static void main(String[] args) {
		
		graph 	= new int[VERTEX_SIZE][VERTEX_SIZE];
		weight  = new int[VERTEX_SIZE][VERTEX_SIZE];
		V   	= new int[VERTEX_SIZE];
		d 		= new int[VERTEX_SIZE];
		pi  	= new int[VERTEX_SIZE];

		for(int i=0; i<VERTEX_SIZE; i++)
			V[i]=i;
		
		graph=generategraph(graph);
		getMSTPrims(V, graph, 0);
		
		for(int i=0; i <VERTEX_SIZE; i++){
			System.out.println(pi[i]+" --> "+i);
		}
		
	}
	
	static void getMSTPrims(int[] vertex, int[][] graph, int s){
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(10, new Comparator<Integer>() {

			@Override
			public int compare(Integer elem1, Integer elem2) {
				if(d[elem1] > d[elem2]){
					return 1;
				}
				if(d[elem1] <= d[elem2]){
					return -1;
				}
				return 0;
			}
		});
		String S=null;
		
		getInitializeSingleSource(vertex, s);
		S="";
		for(int i=0; i<VERTEX_SIZE; i++)
			priorityQueue.add(vertex[i]);
		
		
		
		while(!priorityQueue.isEmpty()){
			System.out.println("Element in Queue "+priorityQueue);
			int u = priorityQueue.remove();
			
			S= S+String.valueOf(u);
			
			List<Integer> adjecentlist = findAdjacentNode(u, graph);
			Iterator<Integer> it = adjecentlist.iterator();
			
			while(it.hasNext()){
				int v= it.next().intValue();
				if(priorityQueue.contains(v) && weight[u][v]<d[v]){	
					relax(u, v, weight);
					priorityQueue.remove(v);
					priorityQueue.add(v);
				}
				
			}
		}
		
		System.out.println(S);
	}
	
	static void getInitializeSingleSource(int[] vertex, int s){
		for(int i=0; i<vertex.length; i++){
			d[i] = Integer.MAX_VALUE;
			pi[i]  = -1;
		}
		d[s] =0;
	}
	
	static void relax(int u, int v, int[][] w){
		if(d[v]> (d[u]+w[u][v])){
			d[v]  = d[u] + w[u][v];
			pi[v] = u;
		}
	}
	
	static List<Integer> findAdjacentNode(int i, int[][] graph) {
		List<Integer> list = new ArrayList<Integer>();
		for (int j = 0; j < graph[0].length; j++) {
			if (i == j)
				continue;
			else if (graph[i][j] == 1) {
			//	System.out.println("Adjacent node to " + i + " :: " + j);
				list.add(new Integer(j));
			}
		}

		return list;
	}
	
	static int[][] generategraph(int[][] graph){
		connectEdge(0, 1,10, graph);
		connectEdge(0, 2,5, graph);
		
		connectEdge(1, 2,2, graph);
		connectEdge(2, 1,3, graph);
		
		connectEdge(1, 3,1, graph);
		connectEdge(3, 4,4, graph);
		connectEdge(4, 3,6, graph);
		
		connectEdge(2, 4,2, graph);
		connectEdge(2, 3,9, graph);
		
		connectEdge(4, 0,7, graph);		
		return graph;
	}
	
	static void connectEdge(int i, int j, int w, int[][] graph) {
		graph[i][j] = 1;
		weight[i][j] = w;
	}

}
