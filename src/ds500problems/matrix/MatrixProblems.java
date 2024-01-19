package ds500problems.matrix;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class MatrixProblems {

	public static void main(String[] args) {
    System.out.println(numberOfPaths(2,3));
    System.out.println(numberOfPaths(2,2));
    int [][] input =  {{1,2,3,4,5},{2,4,5,8,10},{3,5,7,9,11},{1,3,5,7,9}};
	
    lowestMatchingElement(input);
    
    int[][] mat =
        {
            { 1, 2, 3, 4, 5},
            {16, 17, 18, 19, 6},
            {15, 24, 25, 20, 7},
            {14, 23, 22, 21, 8},
            {13, 12, 11, 10, 9}
        };
 
        printSpiralOrder(mat);
        int[][] pathMatrix =
            {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
            };
     
            Stack<Integer> path = new Stack<>();
     
            // start from `(0, 0)` cell
            int x = 0, y = 0;
     
            findPaths(pathMatrix, x, y, path);
            int[][] diagonal =
                {
                    { 1, 2, 3, 4, 5 },
                    { 2, 3, 4, 5, 6 },
                    { 3, 4, 5, 6, 7 },
                    { 4, 5, 6, 7, 8 },
                    { 5, 6, 7, 8, 9 }
                };
            printMatrixInDiagonalSlope(diagonal);
	
            int[][] sortedNegative =
                {
                    { -7, -3, -1, 3, 5 },
                    { -3, -2, 2, 4, 6 },
                    { -1, 1, 3, 5, 8 },
                    { 3, 4, 7, 8, 9 }
                };
   
            System.out.println("Negative ="+countNegative(sortedNegative));
	
            int[][] subMatrixSum =
                {
                    { 0, 2, 5, 4, 1 },
                    { 4, 8, 2, 3, 7 },
                    { 6, 3, 4, 6, 2 },
                    { 7, 3, 1, 8, 3 },
                    { 1, 5, 7, 9, 4 }
                };
         
                // (p, q) and (r, s) represent top-left and bottom-right
                // coordinates of the submatrix
                int p = 1, q = 1, r = 3, s = 3;
                // calculate the submatrix sum
                System.out.print(findSubmatrixSum(subMatrixSum, p, q, r, s));
	
	
             // 5 × 5 matrix
                int[][] maxmatrix =
                {
                    { 3, -4, 6, -5, 1 },
                    { 1, -2, 8, -4, -2 },
                    { 3, -8, 9, 3, 1 },
                    { -7, 3, 4, 2, 7 },
                    { -3, 7, -5, 7, -6 }
                };
         
                // submatrix size
                int k = 3;
                System.out.println("######\n");
                
                findMaxSumSubMatrix(maxmatrix, k);
	
	   //countIslands
                int[][] island=
                    {
                            { 1, 0, 1, 0, 0, 0, 1, 1, 1, 1 },
                            { 0, 0, 1, 0, 1, 0, 1, 0, 0, 0 },
                            { 1, 1, 1, 1, 0, 0, 1, 0, 0, 0 },
                            { 1, 0, 0, 1, 0, 1, 0, 0, 0, 0 },
                            { 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
                            { 0, 1, 0, 1, 0, 0, 1, 1, 1, 1 },
                            { 0, 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                            { 0, 0, 0, 1, 0, 0, 1, 1, 1, 0 },
                            { 1, 0, 1, 0, 1, 0, 0, 1, 0, 0 },
                            { 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 }
                    };
     
            System.out.print("The total number of islands is " + countIslands(island));
            char matchingWOrd[][] =
                {
                    "DEMXB".toCharArray(),
                    "AOEPE".toCharArray(),
                    "DDCOD".toCharArray(),
                    "EBEDS".toCharArray(),
                    "CPYEN".toCharArray()
                };
         
                String word = "CODE";
         
                findAllOcurrenceofWord(matchingWOrd, "CODE");
	
	}
	
	/*
	 * Count all possible paths from top left to bottom right 
	 * of a mXn matrix
	 * https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
	 *Input :  m = 2, n = 2;
		Output : 2
		There are two paths
		(0, 0) -> (0, 1) -> (1, 1)
		(0, 0) -> (1, 0) -> (1, 1)
		
		Input :  m = 2, n = 3;
		Output : 3
		There are three paths
		(0, 0) -> (0, 1) -> (0, 2) -> (1, 2)
		(0, 0) -> (0, 1) -> (1, 1) -> (1, 2)
		(0, 0) -> (1, 0) -> (1, 1) -> (1, 2)
	 */
	
	public static int numberOfPaths(int m , int n) {
		
		if( m== 1 || n == 1) return 1;
		return numberOfPaths(m-1,n) + numberOfPaths(m,n-1);
		//+numberOfPaths(m-1,n-1) if diagonal move allowed.
		
	}
 
 /*
  * given an MxN matrix where each row is sorted in ascending order.
  * Findout lowest matching element.
  * input  {{1,2,3,4,5}
  *         {2,4,5,8,10}
  *         {3,5,7,9,11}
  *         {1,3,5,7,9}
  *         }
  */

	public static void lowestMatchingElement(int [][] input) {
		int elem ;
		int row = input.length;
		int column = input[0].length;
		for(int c = 0 ; c < column ; c++) {
			elem = input[0][c];
			boolean matched = true;
			for(int j = 1 ; j < row ; j++) {
				boolean found = false;
			  if(elem == input[j][c]) continue;
			  else if(elem > input[j][c]) {
				  for (int k = c+1 ; k < column ; k++) {
					  if(elem == input[j][k]) {
						  found = true;
						  break;
					  }
				  }
			  } else {
				  
				  for (int k = c-1 ; k >=0  ; k--) {
					  if(elem == input[j][k]) {
						  found = true;
						  break;
					  }
				  }  
			  }
			  if(!found) {
				  matched = false;
				  break;
			  }
			}
		  if(matched) {
			  System.out.println("lowest common element is ="+elem);
		  }
		}
		
	}
 // print spiral order 
 // https://www.techiedelight.com/print-matrix-spiral-order/
	 public static void printSpiralOrder(int[][] mat)
	    {
	        // base case
	        if (mat == null || mat.length == 0) {
	            return;
	        }
	 
	        int top = 0, bottom = mat.length - 1;
	        int left = 0, right = mat[0].length - 1;
	 
	        while (true)
	        {
	            if (left > right) {
	                break;
	            }
	 
	            // print top row
	            for (int i = left; i <= right; i++) {
	                System.out.print(mat[top][i] + " ");
	            }
	            top++;
	 
	            if (top > bottom) {
	                break;
	            }
	 
	            // print right column
	            for (int i = top; i <= bottom; i++) {
	                System.out.print(mat[i][right] + " ");
	            }
	            right--;
	 
	            if (left > right) {
	                break;
	            }
	 
	            // print bottom row
	            for (int i = right; i >= left; i--) {
	                System.out.print(mat[bottom][i] + " ");
	            }
	            bottom--;
	 
	            if (top > bottom) {
	                break;
	            }
	 
	            // print left column
	            for (int i = bottom; i >= top; i--) {
	                System.out.print(mat[i][left] + " ");
	            }
	            left++;
	        }
	    }
 //Find all paths from the first cell to the last cell of a matrix
 /*
  * We can only move down or to the right from the current cell.
  */
	public static void findPaths(int [][] m , int i , int j , Stack<Integer> path  ) {
		int M = m.length;
		int N =m[0].length;
		if(i == M-1 && j == N-1) {
			path.add(m[i][j]);
			System.out.println("\nPath ="+path);
			path.pop();
			return  ;
		}
		path.add(m[i][j]);
		//move down
		if(i+1 < M && i+1 >=0 && j >=0 && j< N) {
			findPaths(m, i+1, j, path);
		}
		//move right 
		if(  j+1 <N && j+1 >=0 && i >=0 && i < M) {
			findPaths(m, i, j+1, path);
		}
		path.pop();
	}
	
/* print element in diagonal slope
	[1 2 3 4 5]
	[2 3 4 5 6]
	[3 4 5 6 7]
	[4 5 6 7 8]
	[5 6 7 8 9]
	output: 
	1
	2 2
	3 3 3
	4 4 4 4
	5 5 5 5 5
	6 6 6 6
	7 7 7
	8 8
	9
	*/
	public static void printMatrixInDiagonalSlope(int [][]a) {
		int M = a.length;
		int N = a[0].length;
		for(int i=0; i < M ; i++) {
		  //process left bottom to top
		  for(int j=0,  r=i; j <=i; j++,r--) {
			  System.out.print(a[r][j]+" ");
		  }
		  System.out.println();
		}
		for(int j=1; j < N ; j++) {
			  //process left bottom to top
			  for(int i=M-1,  c=j;  c< N; c++,i--) {
				  System.out.print(a[i][c]+" ");
			  }
			  System.out.println();
		}
	}
	
	/*
	 * Given an M × N matrix, which is row-wise and column-wise sorted,
	 * count the total number of negative elements present in it in linear time.
	 */
	
	public static int countNegative(int [][] a) {
		int m = a.length;
		int n= a[0].length;
		int negative = 0;
		int i=0;
		int j=n-1;
		while(i < m && j >=0) {
			if(a[i][j] < 0) {
				negative +=j+1;
				i++;
			}else {
				j--;
			}
		}
		return negative;
	}
/*
 * Calculate the sum of all elements in a submatrix in constant time
 https://www.techiedelight.com/calculate-sum-elements-sub-matrix-constant-time/	
 Input: matrix[][] is
 
	[ 0  2  5  4  1 ]
	[ 4  8  2  3  7 ]
	[ 6  3  4  6  2 ]
	[ 7  3  1  8  3 ]
	[ 1  5  7  9  4 ]
	 
	(p, q) = (1, 1)
	(r, s) = (3, 3)
	 
	 
	Output: Sum is 38
 
 */
	public static int findSubmatrixSum(int [][] a , int p , int q, int r , int s) {
		int total=0;
		int sum[][] = sumTill_i_j(a);
		//sum of sub-matrix (p,q) and (r ,s) should be
		//total = sum[r][s]-sum[r][q-1]-sum[p-1][s]+sum[p-1][q-1];
		total = sum[r][s];
		if(q-1 >=0) total -= sum[r][q-1];
		if(p-1 >=0) total -= sum[p-1][s];
		if(p-1 >=0 && q-1 >=0) total += sum[p-1][q-1];
		return total;
	}
	
	private static int [][] sumTill_i_j(int [][] a){
		int sum[][] = new int [a.length][a[0].length];
		sum[0][0] = a[0][0];
		//process first row
		for(int c=1 ; c < a[0].length;c ++) {
			sum[0][c] = sum[0][c-1]+a[0][c];
		} 
		//process first column
		for(int i= 1  ; i < a.length; i++) {
			sum[i][0] = sum[i-1][0]+ a[i][0];
		}
		// process remaining matrix
		
		for(int i = 1 ; i < a.length; i++) {
			for(int j = 1 ; j < a[0].length;j++) {
				sum[i][j] +=a[i][j]+sum[i-1][j]+sum[i][j-1]- sum[i-1][j-1];
				
			}
		}
		return sum;
		
	}
	
 // findMaxSumSubMatrix
 // https://www.techiedelight.com/find-maximum-sum-submatrix-in-given-matrix/
	public static void findMaxSumSubMatrix(int a[][],int k) {
		// preprocess the matrix
        int[][] sum = sumTill_i_j(a);
 
        int total, max = Integer.MIN_VALUE;
 
        // `p` stores bottom-right corner coordinates of the submatrix
        Point p = null;
 
        // find the maximum sum submatrix
        //start from k-1,k-1  and consider each submatrix  of size kxk
       int m  = a.length;
       int n = a[0].length;
        for(int i= k-1; i < m ; i++) {
        	for(int j= k-1; j < n; j++) {
        		
        		total = sum[i][j];
        		if(i-k >= 0 ) total -= sum[i-k][j];
        		if(j-k >=0 ) total -= sum[i][j-k];
        		if(i-k >=0  && j-k >=0) total += sum[i-k][j-k];
        	   
        		if(total > max) {
        			max=total;
        			p = new Point(i,j);
        		}
        	}
        }
        
     // get maximum sum submatrix
        for (int i = 0; i < k; i++)
        {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                int r = i + p.first - k + 1;
                int c = j + p.second - k + 1;
                row.add(a[r][c]);
            }
            System.out.println(row);
        }
	}
	
/*
 * count countIslands
 * https://www.techiedelight.com/count-the-number-of-islands/
 */
  public static int countIslands(int [][] a) {
	  int islands = 0;
	  int m = a.length;
	  int n = a[0].length;
	  boolean [][] processed = new boolean[m][n];
	  for(int i = 0 ; i < m ; i++){
		  for(int j=0 ; j  < n ; j++) {
			  if(a[i][j] == 1 && !processed[i][j]) {
				  bfs(a , i ,j,processed);
				  islands++;
			  }
		  }
	  }
	  return islands;
  }

private static void bfs(int[][] a, int i, int j, boolean[][] processed) {
	// create an empty queue and enqueue source node
    Queue<Pair> q = new ArrayDeque<>();
    q.add(new Pair(i, j));
      int[] row = { -1, -1, -1, 0, 1, 0, 1, 1 };
      int[] col = { -1, 1, 0, -1, -1, 1, 0, 1 };
 
    while(!q.isEmpty()) {
    	int x = q.peek().first;
    	int y = q.peek().second	;
    	q.poll();
    	for(int k = 0 ; k < row.length ; k++) {
    		if(isSafe(a, x+row[k],y+col[k],processed)) {
    			q.add(new Pair(x + row[k], y + col[k]));
    		    processed[x + row[k]][y + col[k]]= true;
    		}
    	}
    }
	
}

private static boolean isSafe(int[][] a, int i, int j, boolean[][] processed) {
	
	return  i < a.length && i >=0  && j < a[0].length && j >=0 &&
			!processed[i][j] && a[i][j] == 1;
}

//https://www.techiedelight.com/find-occurrences-given-string-character-matrix/
/*
 * https://www.techiedelight.com/find-occurrences-given-string-character-matrix/
 */
public static  void findAllOcurrenceofWord(char [][]a, String word) {
	 // base case
    if (a == null || a.length == 0 || word == null) {
        return;
    }
    List <Node> paths = new ArrayList();
    for(int i =0 ; i < a.length ; i ++) {
    	for(int j = 0; j < a[0].length; j++) {
    		dfs(a,word, Node.of(i,j),paths,0);
    	}
    }
}

private static void dfs(char[][] a, String word, Node n, List<Node> paths, int i) {
	
	if(word.charAt(i) != a[n.x][n.y]) return;
	
	 paths.add(Node.of(n.x, n.y));
     if(word.length()-1 == i) {
    	 System.out.println("word found ="+paths);
     }else {
    	// Below arrays detail all eight possible movements from a cell
         int[] row = { -1, -1, -1, 0, 0, 1, 1, 1 };
         int[] col = { -1, 0, 1, -1, 1, -1, 0, 1 };
     
    	 for(int k=0;  k < row.length; k++) {
    		// check if it is possible to go to the next position
             // from the current position
             if (isValid(a,Node.of(n.x+row[k], n.y+col[k]), paths)) {
                 dfs(a, word, Node.of(n.x+row[k], n.y+col[k]), paths, i + 1);
             }
    	 }
    	
     }
     paths.remove(paths.size()-1) ;
}

private static boolean isValid(char[][] a, Node n, List<Node> paths) {
	return n.x >=0 && n.y >=0 && n.x < a.length && n.y < a[0].length && !paths.contains(n)  ;
}
}
//Node class
class Node
{
 public int x, y;

 private Node(int x, int y) {
     this.x = x;
     this.y = y;
 }

 public static Node of(int x, int y) {
     return new Node(x, y);
 }

 @Override
 public boolean equals(Object o) {
     Node node = (Node) o;
     return x == node.x && y == node.y;
 }

 @Override
 public int hashCode() {
     return Objects.hash(x, y);
 }

 @Override
 public String toString() {
     return ("(" + x + ", " + y + ")");
 }
}
class Pair{
	int first  , second;
	 Pair(int i , int j) {
		this.first = i;
		this.second = j;
	}
}
class Point
{
    int first, second;
 
    public Point(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
