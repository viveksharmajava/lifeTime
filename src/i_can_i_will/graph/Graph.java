package i_can_i_will.graph;

import java.awt.Adjustable;
import java.util.ArrayList;
import java.util.List;

/*
 * 1. Directed Graph (Digraph) Implementation
 * https://www.techiedelight.com/graph-implementation-java-using-collections/
 */
public class Graph {
    
	//A list to represent adjacency list
	List<List<Integer>> adjList = new ArrayList<>();
	//construct a graph
	Graph(List<Edge> edges){
		int v = 0;
		for(Edge edge: edges) {
			v = Math.max(v, Math.max(edge.src,edge.dest));
		}
		v= v+1;//just for safer side in some examples starting with 0 vertex in some with 1.
		  // allocate memory for the adjacency list
		System.out.println("Max vertexes ="+v);
		for(int i=0; i <= v; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		//add edges of dire
		for(Edge e : edges) {
			adjList.get(e.src).add(e.dest);
		}
		
	}
	Graph(List<Edge> edges,int vertexes){
		
		  // allocate memory for the adjacency list
		System.out.println("Max vertexes ="+vertexes);
		for(int i=0; i <= vertexes; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		//add edges of dire
		for(Edge e : edges) {
			adjList.get(e.src).add(e.dest);
		}
		
	}
	
	//function to Print adjacency list of graph
	
	public  void printGraph() {
		int c =0;
		while( c < adjList.size()) {
			for(int edge : adjList.get(c)) {
				System.out.print(c+" -->"+edge+"\t ");
			}
			c++;
			System.out.println();
		}
	}
public void dfs() {
	
}
}

class Edge{
	
	int src;
	int dest;
	public Edge(int src, int dst) {
	this.src = src;
	this.dest =dst;
   }
 }