package designguru.mergeintervals;

public class Interval{
	int start;
	int end;
	Interval(int b ,int e){
		start = b;
		this.end = e;
	}
	@Override
	public String toString() {
		return "["+this.start +", "+this.end+"]";
	}
}