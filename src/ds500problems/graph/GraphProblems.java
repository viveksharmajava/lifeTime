package ds500problems.graph;

import java.util.Arrays;
import java.util.List;

public class GraphProblems {

	public static void main(String[] args) {
		// List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 2), new Edge(2, 3),
                new Edge(2, 4), new Edge(3, 1), new Edge(3, 5),
                new Edge(4, 5), new Edge(6, 7)
        );
 
        // total number of nodes in the graph
        final int N = 8;
 
        // build a graph from the given edges
        Graph graph = new Graph(edges);
        Graph.printGraph(graph);
     // array to store the arrival time of vertex
        int[] arrival = new int[N];
 
        // array to store the departure time of vertex
        int[] departure = new int[N];
 
        // Mark all the vertices as not discovered
        boolean[] discovered = new boolean[N];
        int time = -1;
 
        // Perform DFS traversal from all undiscovered nodes to
        // cover all unconnected components of a graph
        for (int i = 0; i < N; i++)
        {
            if (!discovered[i]) {
                time = DFS(graph, i, discovered, arrival, departure, time);
            }
        }
 
        // print arrival and departure time of each
        // vertex in DFS
        for (int i = 0; i < N; i++)
        {
            System.out.println("Vertex " + i + " (" + arrival[i]
                    + ", " + departure[i] + ")");
        }
	}


	//Arrival and departure time of vertices in DFS
	//https://www.techiedelight.com/arrival-departure-time-vertices-dfs/

	private static int DFS(Graph graph, int v , boolean []discovered, int [] arrival , int []  departure, int time) {
		
		//set arrival time of vertex
		arrival[v] = ++time;
		discovered[v] = true;//mark vertex as discovered.
		System.out.println("vertex "+v+"\t time "+time);
		//System.out.println("adjacent "+graph.getAdjacent().length);
		for(int i : graph.getAdjacent()[v]) {
			if(!discovered[i]) {
				time = DFS(graph , i , discovered,arrival ,departure , time);
			}
		}
		departure[v] = ++time;
		return time;
		
	}

}
