package ds500problems.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 */
public class Graph {

	public static void main(String[] args) {
		Graph graph = new Graph(4);
		/*
		 *    (0)----->---(1)
		 *     |         -
		 *     |     _ <
		 *    <|>  _        
		 *     |  -        -- - - self
		 *     (2)----->--(3)  <--|
		 *       
		 * 
		 * 
		 */
		graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(1,2);
		graph.addEdge(2, 0);
		graph.addEdge(2,3);
		graph.addEdge(3,3);
		System.out.println("Following is Breadth First Traversal "+ 
                "(starting from vertex 2)");
		graph.printBFS(2);
		System.out.println("\n Following is Depth First Traversal "+ 
                "(starting from vertex 2)"); 
		graph.printDFS(2);
	}

	private int vertexes;
	private LinkedList<Integer> [] adjacent;
	
	public int getVertexes() {
		return vertexes;
	}

	public void setVertexes(int vertexes) {
		this.vertexes = vertexes;
	}

	public LinkedList<Integer>[] getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(LinkedList<Integer>[] adjacent) {
		this.adjacent = adjacent;
	}

	Graph(int v){
		this.vertexes = v;
		adjacent = new LinkedList[v];
		for(int i=0; i < v; i++) {
		 adjacent[i] = new LinkedList<Integer>();
		}
	}
	
	Graph(List <Edge> edges){
		
		//find the maximum number of vertices
		int vertexes = 0;
		for(Edge edge : edges) {
			vertexes = Integer.max(vertexes, Integer.max(edge.src, edge.dest)) ;
		}
		vertexes = vertexes+1; // make sure vertex starting from 0
		this.vertexes = vertexes; 
		adjacent = new LinkedList[vertexes];
		for(int i=0; i < vertexes; i++) {
		 adjacent[i] = new LinkedList<Integer>();
		}
		for(Edge edge : edges) {
			adjacent[edge.src].add(edge.dest);
		}
		
	}
	
	// Function to print adjacency list representation of a graph
    public static void printGraph(Graph graph)
    {
       for(int i = 0 ; i < graph.getAdjacent().length ; i++) {
    	   List <Integer>adjacent = graph.getAdjacent()[i];
    	   for(Integer node : adjacent) {
       		System.out.println("("+i+","+node+")");
       	}
       }
    
    	
    }
	public void addEdge(int v , int edge) {
		adjacent[v].add(edge);
	}
	
	public void printBFS(int source){
	
	//Mark all vertex not visted by default.	
	  boolean [] visited = new boolean[this.vertexes];
	  LinkedList <Integer> queue = new LinkedList<Integer>();
	  visited[source] = true;
	  queue.add(source);
	  while(queue.size() != 0) {
		  source = queue.poll();
		  System.out.print(source+"\t");
		  Iterator <Integer> itr = adjacent[source].listIterator();
		  while(itr.hasNext()) {
			  int edge = itr.next();
			  if(!visited[edge])
			   {
				  visited[edge] = true;
				  queue.add(edge);
			   }
		  }
	  }//end of while
	  
	}
	
	public void printDFS(int source) {
		//Mark all vertex not visted by default.	
		  boolean [] visited = new boolean[this.vertexes];
		  dfs(source ,visited);
	 }
	private void dfs(int source , boolean [] visited) {
		
		visited[source] = true;
		 System.out.print(source+"\t");
		  Iterator <Integer> itr = adjacent[source].listIterator();
		  while(itr.hasNext()) {
			  int edge = itr.next();
			  if(!visited[edge])
			   {
				 dfs(edge,visited); 
			   }
		  } 
		
	}
}

class Edge{
	
	int src , dest;
	Edge(int s , int d){
		this.src = s;
		this.dest = d;
	}

}
