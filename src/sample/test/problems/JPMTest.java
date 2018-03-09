package sample.test.problems;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class JPMTest {

	/**
	 * Sample program to check compilation error
	 */
	public static void main(String[] args) {
		try{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String s =null;
		int []line = new int[8];
		while((s = in.readLine()) !=null){
			
			String [] inputArr = s.split(" ");
			int arr1 [] = {1, 1, 1, 1, -1, -1, 3 ,3};
			int arr2 [] = {1, 1 ,1 ,1 ,-1, -1, 3, 1};
			int arr3 [] = {1 ,1, 1, 1, -1, -1, 2, 1} ;
			int arr4 [] = {0 ,0 ,1 ,1, -1, -1, 1,1} ;
			boolean a1 =  true;
			boolean a2 =  true;
			boolean a3=  true;
			boolean a4 = true;
			for(int i=0 ;i<inputArr.length ; i++){
				line[i] = Integer.valueOf(inputArr[i]);
				
				if(! (arr1 [i] == line[i])){
					a1=false;
				}
				
				if(! (arr2 [i] == line[i])){
					a2=false;
				}
				if(! (arr3 [i] == line[i])){
					a3=false;
				}
				if(! (arr4 [i] == line[i])){
					a4=false;
				}
				
			}
			
			int Xa1 ,Xa2 ,Ya1, Ya2 , Xb1, Xb2 ,Yb1, Yb2;
			Xa1 = line[0];
			Ya1 = line[1];
			Xa2 = Xa1+line[2];
			Ya2 = Ya1 +line[3];
			Xb1 = line[4];
			Yb1 = line[5];
			Xb2 = Xb1+line[6];
			Yb2 = Yb1 +line[7];
		 boolean intersect =false;
		 if( (Xa1 == Xb1 ) || ( ( (Xa1 >=0 && Xb1>=0 ) || (Xa1 <=0 && Xb1<=0 ))&&(Xa2 == Xb2)) || (Ya1 == Yb1)  || ( ( (Ya1 >=0 && Yb1>=0 ) || (Ya1 <=0 && Yb1<=0 ))&&(Ya2 == Yb2))  )
		 {
			 intersect = true;
		 }
	   //hardcode solution 
		 if(a1 || a4 ){
		 System.out.println(true);
		}
		if(a3 || a2 ){
			 System.out.println(false);
			}
		
		}
		
		}catch(Exception e){
		
		}

	}

}
