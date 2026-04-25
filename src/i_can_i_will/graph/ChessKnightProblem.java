package i_can_i_will.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class ChessKnightProblem {

    // Below arrays detail all eight possible movements for a knight
    private static int[] row = { 2, 2, -2, -2, 1, 1, -1, -1 };
    private static int[] col = { -1, 1, 1, -1, 2, -2, 2, -2 };
 
    // Check if (x, y) is valid chessboard coordinates.
    // Note that a knight cannot go out of the chessboard
    private static boolean isValid(int x, int y, int N) {
        return (x >= 0 && x < N) && (y >= 0 && y < N);
    }
 
	public static void main(String[] args) {
		 // N x N matrix
        int N = 8;
 
        // source coordinates
        ChessNode src = new ChessNode(0, 7);
 
        // destination coordinates
        ChessNode dest = new ChessNode(7, 0);
        System.out.println("The minimum number of steps required is " +
                findShortestDistance(src, dest, N));
 
	}
	
	// Find the minimum number of steps taken by the knight
    // from the source to reach the destination using BFS
    public static int findShortestDistance(ChessNode src, ChessNode dest, int N)
    {
        // set to check if the matrix cell is visited before or not
    	Set <ChessNode> visited = new HashSet<>();
    	Queue <ChessNode> q = new ArrayDeque<>();
    	
    	q.add(src);
    	while(!q.isEmpty()) {
    		ChessNode  node = q.poll();
    		int x = node.x;
    		int y = node.y;
    		int dist = node.dist;
    		 // if the destination is reached, return distance
    		if(x == dest.x && y == dest.y ) return dist;
    		if(!visited.contains(node)){
    			visited.add(node);
    			// check for all eight possible movements for a knight
                // and enqueue each valid movement
    			for(int i=0; i <row.length;i++) {
    				// get the knight's valid position from the current position on
                    // the chessboard and enqueue it with +1 distance
    				int x1 = x + row[i];
    				int y1 =y + col[i];
    				if(isValid(x1,y1,N)) {
    					q.add(new ChessNode(x1, y1, dist+1));
    				}
    			}
    		}
    		
    	}
    	return Integer.MAX_VALUE;
    } 	

}

class ChessNode{
	int x,y; //x,y represent cordinate/position n chess-board
	int dist;//dist represent min distnace from source
	
	ChessNode(int x, int y,int d){
    this.x = x;
    this.y = y;
    this.dist = d;
}
	ChessNode(int x, int y){
	    this.x = x;
	    this.y = y;
	}
	// As we are using the class object as a key in a `HashMap`,
    // we need to implement `hashCode()` and `equals()`
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessNode node = (ChessNode) o;
        return x == node.x &&
                y == node.y &&
                dist == node.dist;
    }
    @Override
    public int hashCode() {
    	
    	return Objects.hash(x,y,dist);
    }
	
}