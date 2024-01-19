package ds500problems.tree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ThreadedBinaryTree {
	 static class Node
	{
		int data;
		Node left, right;
		boolean rightThread;
	}

	// This code contributed by aashish1995
	 static Date addHoursToJavaUtilDate(Date date, int hours,int minutes) {
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    calendar.add(Calendar.HOUR_OF_DAY, hours);
		    calendar.add(Calendar.MINUTE, minutes);
		    return calendar.getTime();
		   
		}
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		  long l = Math.abs(360/60l);
		//  l = l
	       SimpleDateFormat FORMATTER = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a");
	     
	   
	        TimeZone etTimeZone = TimeZone.getTimeZone("America/Chicago"); //Target timezone
	        FORMATTER.setTimeZone(etTimeZone);
	        Calendar calendar = Calendar.getInstance(etTimeZone);
	        Date currentDate = FORMATTER.parse("Nov 09, 2021 11:41:58 AM");
	        calendar.setTime(currentDate);
	        System.out.println("before equavalent = "+ calendar.getTime());
	        System.out.println(etTimeZone.getOffset(currentDate.getTime()));
	        long offset = etTimeZone.getOffset(currentDate.getTime()) ;
		    
	        if(offset > 0 ){
		    	offset = offset/(1000*60);//convert to  minutes
		    	Long h = offset/60;
		    	Long m = offset%60;
		    	 calendar.add(Calendar.HOUR_OF_DAY,- h.intValue());
				  calendar.add(Calendar.MINUTE,- m.intValue());
		    }
	        else  if(offset < 0 ){
	        	Long loffset = -offset;
		    	Long moffset = loffset/(1000*60);//convert to  minutes
		    	Long h = moffset/60;
		    	Long m = moffset%60;
		    	 calendar.add(Calendar.HOUR_OF_DAY, h.intValue());
				  calendar.add(Calendar.MINUTE, m.intValue());
		    }
		    System.out.println("UTC equavalent = "+ calendar.getTime());
	        //currentDate.setHours(currentDate.getHours()+0);
	      //  System.out.println(FORMATTER.format(currentDate));  //Date in current timezone
	         
	        FORMATTER.setTimeZone(etTimeZone);
	         System.out.println("GMT String "+currentDate.toGMTString());
	        System.out.println(FORMATTER.format(currentDate));  //Date in target timezone
	   
	}
	// Utility function to find leftmost node in a tree rooted
	// with n
	 static Node leftMost(Node n)
	{
		if (n == null)
			return null;

		while (n.left != null)
			n = n.left;

		return n;
	}

	// C code to do inorder traversal in a threaded binary tree
	static void inOrder(Node root)
	{
		Node cur = leftMost(root);
		while (cur != null) {
			System.out.printf("%d ", cur.data);

			// If this node is a thread node, then go to
			// inorder successor
			if (cur.rightThread)
				cur = cur.right;
			else // Else go to the leftmost child in right
				cur = leftMost(cur.right);
		}
	}


}
