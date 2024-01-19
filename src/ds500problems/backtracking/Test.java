package ds500problems.backtracking;

import java.util.Arrays;
import java.util.HashMap;

public class Test {

	public static void main(String[] args) {

		// `N × N` chessboard
        int N = 8;
 
        // `mat[][]` keeps track of the position of queens in
        // the current configuration
        char[][] mat = new char[N][N];
 
        // initialize `mat[][]` by `-`
        for (int i = 0; i < N; i++) {
            Arrays.fill(mat[i], '–');
        }
 
        HashMap<a , String> hm = new HashMap();
        a ob= new a();
        ob.id = "sfd";
        ob.name= "sfsdf";
        hm.put(ob,"43243");
        ob= new a();
        ob.id = "abc";
        ob.name= "sdf";
        hm.put(ob,"43243");
        System.out.println(ob);
	}

}

class a {
	String id ,  name;
    
	@Override
	public String toString() {
		return "a [id=" + id + ", name=" + name + "]";
	}
	
}
