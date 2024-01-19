import java.util.ArrayList;
import java.util.List;

public class OnlineTest {

	public static void main(String[] args) {
		System.out.println(MyWorkingHours(50,100,5000));
	}

	public static List<Integer> MyWorkingHours(int PeakRate, int OffPeakRate, int XEarnings) {
		List<Integer> list  = new ArrayList<>(2);
		int peakhour =0 , offHour=0 ;
		if(PeakRate > OffPeakRate) {
			while(10*PeakRate*(++peakhour) <= XEarnings) {
			}
			peakhour--;
			int remaining = XEarnings - 10*PeakRate*peakhour;
			while(10*OffPeakRate*(++offHour) <= remaining) {
				
			}
			offHour--;
			while(10*OffPeakRate*offHour != remaining) {
				offHour = 0;
				remaining = remaining +10*PeakRate;
				peakhour--;
				while(10*OffPeakRate*(++offHour) <= remaining) {
					
				}
				offHour--;
			}
			if(peakhour !=0 || offHour != 0) {
				list.add(peakhour);
				list.add(offHour);
				return list;
			}
		}
		else {

			while(10*OffPeakRate*(++offHour) <= XEarnings) {
				
			}
			offHour--;
			int remaining = XEarnings - 10*OffPeakRate*offHour;
			while(10*PeakRate*(++peakhour) <= remaining) {
				
			}
			peakhour--;
			while(10*PeakRate*peakhour != remaining) {
				peakhour = 0;
				remaining = remaining +10*OffPeakRate;
				offHour--;
				while(10*PeakRate*(++offHour) <= remaining) {
					
				}
				peakhour--;
			}
			if(peakhour !=0 || offHour != 0) {
				list.add(peakhour);
				list.add(offHour);
				return list;
			}
		
		}
		return list;
    }
}
