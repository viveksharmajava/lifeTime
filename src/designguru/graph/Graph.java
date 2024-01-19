package designguru.graph;

import java.util.ArrayList;
import java.util.List;

//A class to represent a graph object
public class Graph {

	//A list of list represent adjacent list.
	List <List <Integer>> adjList = new ArrayList<>();
	
	Graph(List <Edge> edges){
		int n= 0;
		for(Edge e : edges) {
			n = Integer.max(n , Integer.max(e.src, e.dest));
		}
		for(int i=0; i <= n; i++) {
			adjList.add(i , new ArrayList<Integer>());
		}
		
		//add edges to the directed graph
		for(Edge e : edges) {
			adjList.get(e.src).add(e.dest);
		}
		//comment below code for undirected graph
		
		
		//		for(Edge e : edges) {
		//			adjList.get(e.dst).add(e.src);
		//		}
		
		//function to print adjacent list representation of a graph
		
		for(List <Integer> adjcents : adjList) {
			
		}
	
	}
	
	
	// Function to print adjacency list representation of a graph
    public static void printGraph(Graph graph)
    {
        int src = 0;
        int n = graph.adjList.size();
 
        while (src < n)
        {
            // print current vertex and all its neighboring vertices
            for (int dest: graph.adjList.get(src)) {
                System.out.print("(" + src + " ——> " + dest + ")\t");
            }
            System.out.println();
            src++;
        }
    }
	
}
