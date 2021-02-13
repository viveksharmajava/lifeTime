package oops;

public class CloneTest implements Cloneable{
     int a;
     String b;
     
    public Object clone() throws CloneNotSupportedException{
		
      //throw new CloneNotSupportedException("You can not clone");
     // return null;
    	return super.clone();
    	
    }
	public static void main(String[] args) throws CloneNotSupportedException {
		CloneTest ct = new CloneTest();
		ct.a = 10;

		CloneTest ct2 = (CloneTest) ct.clone();
		ct.a = 30;
		System.out.println(ct2.a);
		System.out.println(ct.a);
	}

}
