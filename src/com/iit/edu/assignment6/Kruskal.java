package com.iit.edu.assignment6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Kruskal {
	static int[][] graph;
	static int V[];
	static int weight[][];
	static Set<Integer> resultSet;
	static List<Edge> resultMST;
	static int VisitedEdge[][];
	final static int VERTEX_SIZE=9;
	
	public static void main(String[] args) {
		graph 		= new int[VERTEX_SIZE][VERTEX_SIZE];
		weight  	= new int[VERTEX_SIZE][VERTEX_SIZE];
		VisitedEdge = new int[VERTEX_SIZE][VERTEX_SIZE];
		V   		= new int[VERTEX_SIZE];
		resultSet 	= new HashSet<Integer>();
		resultMST 	= new ArrayList<Edge>();
		PriorityQueue<Edge> priorityQueue = createPriorityQueueForEdges();		
		for(int i=0; i<VERTEX_SIZE; i++)
			V[i]=i;
		graph=generategraph(graph);
		for(int v=0; v<VERTEX_SIZE; v++){
			List<Integer> adjecentlist = findAdjacentNode(v, graph);
			Iterator<Integer> it = adjecentlist.iterator();
			while(it.hasNext()){
				int u=it.next();
				priorityQueue.add(new Edge(v, u, weight[v][u]));
			}
		}
		Edge currentEdge;
		while(!priorityQueue.isEmpty()){
			currentEdge= priorityQueue.poll();
			boolean checkCicuit = willCreateCircuit(graph, VisitedEdge, currentEdge);
			if(!checkCicuit){
				resultMST.add(currentEdge);
				visitEdge(VisitedEdge, currentEdge.from, currentEdge.to);	
			}
		}
		Edge edge;
		Iterator<Edge> it=resultMST.iterator();
		while(it.hasNext()){
			edge=it.next();
			System.out.println("( "+edge.from+","+edge.to+" ) ==>"+edge.wight);
		}
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
	
	static PriorityQueue<Edge> createPriorityQueueForEdges(){
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>(VERTEX_SIZE, new Comparator<Edge>() {

			@Override
			public int compare(Edge elem1, Edge elem2) {
				if(elem1.wight > elem2.wight){
					return 1;
				}
				if(elem1.wight <= elem2.wight){
					return -1;
				}
				return 0;
			}
		});
		
		return priorityQueue;
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
	
	static boolean willCreateCircuit(int[][] graph, int[][] VisitedEdge, Edge edge){
		boolean isCircuit = false;
		int visited[]=new int[VERTEX_SIZE];
		String makeSetFrom = new CycleDetectDFS().traverseGraphDFS(graph, visited, VisitedEdge, edge.from);
		String makeSetTo = new CycleDetectDFS().traverseGraphDFS(graph, visited, VisitedEdge, edge.to);
		if(makeSetFrom ==null || makeSetTo == null)
			return isCircuit;
	
		for(int i=0;i<(makeSetFrom.length()-1); i++){
			if(makeSetTo.contains(String.valueOf(makeSetFrom.charAt(i)))){
				isCircuit=true;
				break;
			}
		}
		
		System.out.println("for Edge ("+edge.from +", "+edge.to+" )");
		System.out.println(edge.from +" from set :: "+makeSetFrom);
		System.out.println(edge.to+" to set :: "+makeSetTo);
		System.out.println("is circut :: "+isCircuit);
		return isCircuit;
	}
	
	static void visitEdge(int[][] visitedEdge,int from, int to){
		visitedEdge[from][to] =1;
		visitedEdge[to][from] =1;
	}
}
