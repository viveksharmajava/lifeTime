package sample.test.problems.array;

public class MNArrayProblem {

	/**
	 * @param args Write an algorithm such that if an element in an MxN matrix is 0, 
	 * its entire row and column is set to 0.
	 */
	public static void main(String[] args) {

		//int [][]matrix = { { 0,1,2},{3,4,5},{6,7,8}};
		int [][]matrix = { { 6,0,2},{3,4,5}};
		int [] row = new int[matrix.length];
		int [] col = new int [matrix[0].length];
		
		System.out.println("row="+row.length+"\t column="+col.length);
		
		for(int i=0; i<matrix.length ;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j] == 0){
					row[i] = 1;
					col[j] = 1;
				}
			}
		}
		
		for(int i=0; i<matrix.length ;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(row[i]== 1 || col[j] == 1 ){
					matrix[i][j] = 0;
				}
			}
		}
		
		System.out.println("Matrix after filling 0 ");
		for(int i=0; i<matrix.length ;i++){
			for(int j=0;j<matrix[0].length;j++){
				
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
		
	}

}
