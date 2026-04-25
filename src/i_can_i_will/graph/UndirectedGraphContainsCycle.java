package i_can_i_will.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
//https://www.techiedelight.com/check-undirected-graph-contains-cycle-not/
public class UndirectedGraphContainsCycle {

	public static void main(String[] args) {
		  // List of graph edges
        List<Edge> edges = Arrays.asList(
                                new Edge(0, 1), new Edge(0, 2), new Edge(0, 3),
                                new Edge(1, 4), new Edge(1, 5), new Edge(4, 8),
                                new Edge(4, 9), new Edge(3, 6), new Edge(3, 7),
                                new Edge(6, 10), new Edge(6, 11), new Edge(5, 9)
                                // edge (5, 9) introduces a cycle in the graph
                            );
 
        // total number of nodes in the graph (0 to 11)
        int n = 12;
 
        // build a graph from the given edges
        UndirectedGraph graph = new UndirectedGraph(edges, n);
 
        // Perform BFS traversal in connected components of a graph
        if (detectCycleBFS(graph, 0, n)) {
            System.out.println("The graph contains a cycle");
        }
        else {
            System.out.println("The graph doesn't contain any cycle");
        }
        edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 6), new Edge(0, 7),
                new Edge(1, 2), new Edge(1, 5), new Edge(2, 3),
                new Edge(2, 4), new Edge(7, 8), new Edge(7, 11),
                new Edge(8, 9), new Edge(8, 10), new Edge(10, 11)
                // edge (10, 11) introduces a cycle in the graph
            );
		
		// total number of nodes in the graph (0 to 11)
		 n = 12;
		
		// build a graph from the given edges
		 graph = new UndirectedGraph(edges, n);
		
		// to keep track of whether a vertex is discovered or not
		boolean[] discovered = new boolean[n];
		
		// Perform DFS traversal from the first vertex
		if (detectCycleDFS(graph, 0,  -1,discovered)) {
		    System.out.println("The graph contains a cycle");
		}
		else {
		    System.out.println("The graph doesn't contain any cycle");
		}
	}
   //https://www.techiedelight.com/check-undirected-graph-contains-cycle-not/
	public static boolean detectCycleBFS(UndirectedGraph graph, int src , int n) {
		boolean discovered[] = new boolean[n];
		discovered[src] = true;
		// create a queue for doing BFS and
        // enqueue source vertex
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(src,-1));
		//loop till queue is empty
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int u : graph.adjList.get(node.v)) {
				if(!discovered[u]) {	
				   discovered[u] =true;
				// construct the queue node containing info
                   // about vertex and enqueue it
				   q.add(new Node(u,node.v));
				}
				else if( u !=  node.parent) {//u is discovered and u is not parent.
					
				} return true;
			}
		}
		
		  // we found a cross-edge, i.e., the cycle is found
		 return true;
		
	}
	//https://www.techiedelight.com/check-undirected-graph-contains-cycle-not/
	public static boolean detectCycleDFS(UndirectedGraph graph, int v , int parent,boolean []discovered) {
		//mark the current node 
		discovered[v] = true;
		for(int w : graph.adjList.get(v)) {
			if(!discovered[w]) {
				if(detectCycleDFS(graph,w,v,discovered)) return true;
			}
			else if ( w != parent) return true;
		}
		return false;
		
		
	}
}

class UndirectedGraph{
	// A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;
 
    // Constructor
    UndirectedGraph(List<Edge> edges, int n)
    {
        adjList = new ArrayList<>();
 
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(Edge e : edges) {
        	adjList.get(e.src).add(e.dest);
        	adjList.get(e.dest).add(e.src);
        	
        }
    }
}
//Node to store vertex and its parent info in BFS
class Node
{
 int v, parent;

 Node(int v, int parent)
 {
     this.v = v;
     this.parent = parent;
 }
}
