package sample.test.designPatterns;

public class SingleTonDesign {

	/**
	 * @param args
	 */
	private SingleTonDesign(){
		System.out.println("singleton called");
	}
	private static SingleTonDesign singleTon =null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleTonDesign.getSingleTonObject();
		SingleTonDesign.getSingleTonObject();
		SingleTonDesign.getSingleTonObject();
	}
 
	public static synchronized  SingleTonDesign getSingleTonObject(){
		if(singleTon == null){
			singleTon = new SingleTonDesign();
		}
		return singleTon;
	}
}
