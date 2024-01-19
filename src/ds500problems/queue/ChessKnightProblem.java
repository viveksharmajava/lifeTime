package ds500problems.queue;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/*
 * Chess Knight Problem | Find the shortest path from source to destination
   Given a chessboard, find the shortest distance (minimum number of steps)
   taken by a knight to reach a given destination from a given source.
 Input:
 
	N = 8 (8 × 8 board)
	Source = (7, 0)
	Destination = (0, 7)
	 
	Output: Minimum number of steps required is 6
	So, from position (x, y) knight’s can move to:
	row[] = [ 2, 2, -2, -2, 1, 1, -1, -1 ]
	col[] = [ -1, 1, 1, -1, 2, -2, 2, -2 ]
	(x + 2, y – 1)
	(x + 2, y + 1)
	(x – 2, y + 1)
	(x – 2, y – 1)
	(x + 1, y + 2)
	(x + 1, y – 2)
	(x – 1, y + 2)
	(x – 1, y – 2)

 *
 */

class Node{
	int x , y , dist;
	public Node(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
 
    public Node(int x, int y, int dist)
    {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x &&
                y == node.y &&
                dist == node.dist;
    }
    @Override
    public int hashCode() {
    	return Objects.hash(x,y,dist);
    }
}
public class ChessKnightProblem {
	// Below arrays detail all eight possible movements for a knight
    private static int[] row = { 2, 2, -2, -2, 1, 1, -1, -1 };
    private static int[] col = { -1, 1, 1, -1, 2, -2, 2, -2 };
 
    // Check if (x, y) is valid chessboard coordinates.
    // Note that a knight cannot go out of the chessboard
    private static boolean isValid(int x, int y, int N) {
        return (x >= 0 && x < N) && (y >= 0 && y < N);
    }
 // Find the minimum number of steps taken by the knight
    // from the source to reach the destination using BFS
    //below is the same problem
   //https://www.techiedelight.com/lee-algorithm-shortest-path-in-a-maze/
    public static int findShortestDistance(Node src, Node dest, int N)
    {
    	Queue <Node> moves = new ArrayDeque<>();
    	Set <Node> visited = new HashSet();
    	moves.add(src);
    	while(!moves.isEmpty()) {
    		
    		Node n = moves.poll();
    		if(n.x == dest.x && n.y == dest.y) return n.dist;
    		if(!visited.contains(n)) {
    			visited.add(n);
    			for(int i = 0 ; i < row.length; i++ ) {
    				int x = n.x + row[i];
    				int y = n.y + col[i];
    				if(isValid(x, y, N)) {
    					moves.add(new Node(x,y,n.dist+1));
    				}
    			}
    		}
    	}
    	// return infinity if the path is not possible
    	return Integer.MAX_VALUE;
    }
	public static void main(String[] args) {
		Node x = new Node(7,0);
		Node y = new Node(0,7);
		System.out.println(findShortestDistance(x,y,8));
	}

}
