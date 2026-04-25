package ds500.techiedelight1to500;

public class Pair {
    
	private Integer a;
	private Integer b;
	
	public static Pair  of(int a ,int b){
		Pair p = new Pair() ;
		p.a = a;
		p.b = b;
		return p;
	}

	@Override
	public String toString() {
		return "Pair [a=" + a + ", b=" + b + "]";
	}
	
}
