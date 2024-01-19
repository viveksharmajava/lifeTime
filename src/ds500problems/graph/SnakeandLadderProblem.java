package ds500problems.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//Find the minimum number of throws required to win
//a given Snakes and Ladders board game.
//https://www.techiedelight.com/min-throws-required-to-win-snake-and-ladder-game/
public class SnakeandLadderProblem {

	public static void main(String[] args) {
		// snakes and ladders are represented using a map.
        Map<Integer, Integer> ladder = new HashMap<>();
        Map<Integer, Integer> snake = new HashMap<>();
 
        // insert ladders into the map
        ladder.put(1, 38);
        ladder.put(4, 14);
        ladder.put(9, 31);
        ladder.put(21, 42);
        ladder.put(28, 84);
        ladder.put(51, 67);
        ladder.put(72, 91);
        ladder.put(80, 99);
 
        // insert snakes into the map
        snake.put(17, 7);
        snake.put(54, 34);
        snake.put(62, 19);
        snake.put(64, 60);
        snake.put(87, 36);
        snake.put(93, 73);
        snake.put(95, 75);
        snake.put(98, 79);
 
        System.out.println(findMinimumMoves(ladder, snake));
	}
	public static int findMinimumMoves(Map<Integer, Integer> ladder,
            Map<Integer, Integer> snake)
   {
		// total number of nodes in the graph
		int n = 10*10;
		List <Edge>  edges= new  ArrayList<>();
		for(int i=0 ; i < n; i++) {
		  for(int j= 1 ; j <= 6 && i+j <= n ; j++) {
			  int src = i;
			  int dest;
			int _ladder = (ladder.get(i+j)!=null)?ladder.get(i+j):0;
			int _snake = (snake.get(i+j)!=null)?snake.get(i+j):0;
		    if(_ladder != 0 || _snake!= 0) {
		    	dest =	 _ladder + _snake;
		    }
		    else {
		    	dest = i+j;
		    }
		    edges.add(new Edge(src ,dest));
		  }
			
		}
		LadderGraph g = new LadderGraph(edges,n);
		return bfs(g, 0, n);
		
  }

  private static int bfs(LadderGraph g , int source , int n) {
	  Queue <Node> q = new ArrayDeque();
	  boolean [] discovered = new boolean[n+1];
	  discovered[source] = true;
	  Node node = new Node(source ,0);
	  q.add(node);
	  while(!q.isEmpty()) {
		   node = q.poll();
		   if(node.ver == n) return node.min_dist;
		   for(int u : g.adjList.get(node.ver)) {
			   if(!discovered[u]) {
				   discovered[u] = true;
				   q.add(new Node(u,node.min_dist+1));
			   }
		   }
		  
	  }
	  return -1;
  }
}
//A class to represent a graph object
 class LadderGraph
{
 // A list of lists to represent an adjacency list
 List<List<Integer>> adjList = null;

 // Constructor
 LadderGraph(List<Edge> edges, int n)
 {
     adjList = new ArrayList<>();
     for (int i = 0; i < n; i++) {
         adjList.add(new ArrayList<>());
     }

     // add edges to the graph
     for (Edge edge: edges)
     {
         // Please note that the graph is directed
         adjList.get(edge.src).add(edge.dest);
     }
}
}
class Node{
	// stores number associated with graph node
	int ver;
	// `min_dist` stores the minimum distance of a node from the starting vertex
	int min_dist;
	
	Node(int v , int dist){
		this.ver = v;
		this.min_dist = dist;
	}
}



