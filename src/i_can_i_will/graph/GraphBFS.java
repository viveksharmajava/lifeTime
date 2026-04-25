package i_can_i_will.graph;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class GraphBFS {
	// Function to perform DFS traversal on the graph on a graph
    public static void BFS(Graph graph, Queue <Integer> queue, boolean[] discovered)
    {
    	if(queue.isEmpty())return;
    	int v = queue.poll();
    	System.out.print(" "+v);
    	for(int vert: graph.adjList.get(v)) {
    		if(discovered[vert]) continue;
    		//BFS(graph, vert, discovered);
    		discovered[vert] = true;
    		queue.add(vert);
    	}
    	BFS(graph,queue,discovered);
    }
    
 // Function to perform BFS traversal on the graph on a graph
    public static void BFSIterative(Graph graph, int v, boolean[] discovered)
    {
    	
         Queue <Integer> queue = new ArrayDeque<>();
        
      // mark the source vertex as discovered
         discovered[v] = true;
  
         // push the source node into the stack
         queue.add(v);
 
        // loop till stack is empty
        while (!queue.isEmpty())
        {
            // Pop a vertex from the stack
            v = queue.poll();
            
            System.out.print(v + " ");
            for(int vert : graph.adjList.get(v)) {
            //	System.out.println("discovered len="+discovered.length+"\t v="+vert);
            	if(!discovered[vert]) {
            		discovered[vert] = true;
            		queue.add(vert);
            	}
            }
            
        }
    }
}
