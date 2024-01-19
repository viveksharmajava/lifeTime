package designguru.graph;


import java.util.*;
 
// A class to store a graph edge
class BFSEdge
{
    int source, dest;
 
    public BFSEdge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}
 
// A class to represent a graph object
 class BFSGraph
{
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;
 
    // Constructor
    BFSGraph(List<BFSEdge> edges, int n)
    {
        adjList = new ArrayList<>();
 
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
 
        // add edges to the undirected graph
        for (BFSEdge edge: edges)
        {
            int src = edge.source;
            int dest = edge.dest;
 
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}
 
public class BFS_DFS_Graph
{
    // Perform BFS on the graph starting from vertex `v`
    public static void BFS(BFSGraph graph, int v, boolean[] discovered)
    {
        // create a queue for doing BFS
        Queue<Integer> q = new ArrayDeque<>();
 
        // mark the source vertex as discovered
        discovered[v] = true;
 
        // enqueue source vertex
        q.add(v);
 
        // loop till queue is empty
        while (!q.isEmpty())
        {
            // dequeue front node and print it
            v = q.poll();
            System.out.print(v + " ");
 
            // do for every edge (v, u)
            for (int u: graph.adjList.get(v))
            {
                if (!discovered[u])
                {
                    // mark it as discovered and enqueue it
                    discovered[u] = true;
                    q.add(u);
                }
            }
        }
    }
    
    
 // Perform BFS on the graph starting from vertex `v`
    public static void recursiveBFS(BFSGraph graph, Queue<Integer> q , boolean[] discovered)
    {
      
    	if(q.isEmpty()) return;
 
        int v= q.poll();
        System.out.print(v + " ");
 
           // do for every edge (v, u)
            for (int u: graph.adjList.get(v))
            {
                if (!discovered[u])
                {
                    // mark it as discovered and enqueue it
                    discovered[u] = true;
                    q.add(u);
                }
            }
            recursiveBFS(graph,q,discovered)    ;
    }
 
 
    public static void dfs(BFSGraph graph, int v, boolean[] discovered) {
    	//mark the current node as discovered.
    	discovered[ v] = true;
    	System.out.println(v +" ");
    	for(int u : graph.adjList.get(v)) {
    		if(!discovered[u]) {
    			dfs(graph,u, discovered);
    		}
    	}
    	
    }
    
    public static void dfsIterative(BFSGraph graph, int v, boolean[] discovered) {
    	//mark the current node as discovered.
    	Stack <Integer> stack = new Stack<>();
    	discovered[ v] = true;

    	stack.add(v);
    	while(!stack.isEmpty()) {
    	   v = stack.pop();
    	   System.out.println(v +" ");
    	   for(int u : graph.adjList.get(v)) {
    	    if(!discovered[u]) {
    	    	stack.add(u);
    	    	//dfsIterative(graph,u, discovered);
    		}
    	}
    	}	
    	
    }
    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<BFSEdge> edges = Arrays.asList(
                new BFSEdge(1, 2), new BFSEdge(1, 3), new BFSEdge(1, 4), new BFSEdge(2, 5),
                new BFSEdge(2, 6), new BFSEdge(5, 9), new BFSEdge(5, 10), new BFSEdge(4, 7),
                new BFSEdge(4, 8), new BFSEdge(7, 11), new BFSEdge(7, 12)
                // vertex 0, 13, and 14 are single nodes
        );
 
        // total number of nodes in the graph (labelled from 0 to 14)
        int n = 15;
 
        // build a graph from the given edges
        BFSGraph graph = new BFSGraph(edges, n);
 
        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[n];
 
        // Perform BFS traversal from all undiscovered nodes to
        // cover all connected components of a graph
        for (int i = 0; i < n; i++)
        {
            if (discovered[i] == false)
            {
                // start BFS traversal from vertex `i`
            	System.out.println("Printing edge for ="+i);
                BFS(graph, i, discovered);
            }
        }
        
       System.out.println(" recursiveBFS"); 
       Queue<Integer> q = new ArrayDeque<>();
       discovered = new boolean[n];
       q.add(1);
       recursiveBFS(graph, q, discovered);
       for (int i = 0; i < n; i++)
       {
           if (discovered[i] == false)
           {
               // mark the source vertex as discovered
               discovered[i] = true;

               // enqueue source vertex
               q.add(i);

               // start BFS traversal from vertex `i`
               //recursiveBFS(graph, q, discovered);
           }
       }
     
       System.out.println("dfs");
       edges = Arrays.asList(
               // Notice that node 0 is unconnected
               new BFSEdge(1, 2), new BFSEdge(1, 7), new BFSEdge(1, 8), new BFSEdge(2, 3),
               new BFSEdge(2, 6), new BFSEdge(3, 4), new BFSEdge(3, 5), new BFSEdge(8, 9),
               new BFSEdge(8, 12), new BFSEdge(9, 10), new BFSEdge(9, 11)
           );

       // total number of nodes in the graph (labelled from 0 to 12)
        n = 13;

       // build a graph from the given edges
        graph = new BFSGraph(edges, n);
       discovered = new boolean[n];
       for (int i = 0; i < 13; i++)
       {
           if (!discovered[i]) {
               System.out.println("dfs for "+i+"\n");
        	   dfs(graph, i, discovered);
           }
       }
       discovered = new boolean[n];
       for (int i = 0; i < 13; i++)
       {
           if (!discovered[i]) {
               System.out.println("dfs iterative  for "+i+"\n");
        	   dfsIterative(graph, i, discovered);
           }
       }
       
       
      // dfs(graph,1, discovered);
    }
}

