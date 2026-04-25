package i_can_i_will.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * https://www.techiedelight.com/min-throws-required-to-win-snake-and-ladder-game/
 * The idea is to consider the snakes and ladders board as a directed graph and run Breadth–first search (BFS) from the starting node, vertex 0, as per game rules. We construct a directed graph, keeping in mind the following conditions:
	
	For any vertex in graph v, we have an edge from v to v+1, v+2, v+3, v+4, v+5, v+6 as we can reach any of these nodes in one throw of dice from node v.
	If any of these neighbors of v has a ladder or snake, which takes us to position x, then x becomes the neighbor instead of the base of the ladder or head of the snake.
	Now the problem is reduced to finding the shortest path between two nodes in a directed graph problem. We represent the snakes and ladders board using a map.

   */
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
 
        System.out.println("minimum moves ="+findMinimumMoves(ladder, snake));
   
	}
	
	//perform BFS on graph g starting from given vertex
	
	public static int bfs(Graph g, int source, int n) {
		boolean discovered[] = new boolean[n+1];
		//keep the track of vertex discovered or not
		Deque <SL_Node> q = new ArrayDeque<>();
		//make the source vertex as discovered.
		discovered[source] = true;
		//assign the min distance 0 to starting node(source)
		//enque it..
		SL_Node node = new SL_Node(source ,0);
		q.add(node);
		while(!q.isEmpty()) {
			
			node = q.poll();
			if(node.vert == n) {//stop the bfs/game if the last node is reached. means game over.
				return node.min_dist;
			}
			for(int u: g.adjList.get(node.vert)) {
				if(!discovered[u]) {
					discovered[u] = true;
					//assign the min_distance of current node
					//one more than the min dstiance of parent node.
					q.add(new SL_Node(u,node.min_dist+1));
				}
			}
		}
		return -1;
	}
  public static int findMinimumMoves(Map<Integer, Integer> ladder,
          Map<Integer, Integer> snake) {
	  //total number of nodes in graph/snake-ladder game
	  
	  int n = 100;
	  // find all edges involved and store them in a list
      List<Edge> edges = new ArrayList<>();
	  for(int i = 0 ; i < 100;i++) {
		  //next move can be between 1...6 dice has 1...6 number
		   int src = i;
		   int dest;
		  for(int j=1; j <=6 && i+j <= n; j++) {
			  
			  int _ladder = (ladder.containsKey(i+j))?ladder.get(i+j):0;
			  int _snake = (snake.containsKey(i+j))?snake.get(i+j):0;
			  
			  if(_ladder != 0 || _snake != 0) {
				 dest =  _ladder + _snake;
			  }else {
				  dest = i+j;
			  }
		  //add an edge from source to destination
		  edges.add(new Edge (src,dest));
		  }
		  
	  }
	  // construct a directed graph
      Graph g = new Graph(edges, n);

      // Find the shortest path between 1 and 100 using BFS
      return bfs(g, 0, n);
  }
}

//A queue SL_Node
class SL_Node{
	//store the number associated with graph node.
	int vert;
	int min_dist;//store the min distance of a node from starting vertex.
	
	public SL_Node(int vert,int dist) {
		this.vert = vert;
		this.min_dist = dist;
	}
}
