import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
class Project{
	String name;
	List<Project> parents;
}
public class ToptalTest {
	private static void getAdmiRepo(String path)throws IOException{

		  //Logger.log("getAdmiRepo  path ="+path, Logger.EVENT);
		  File adminFilePATH = new File(path);
		        if ((!adminFilePATH.exists()) || (!adminFilePATH.isDirectory()) || (!adminFilePATH.canRead()) || (!adminFilePATH.canWrite()))
		        {
		            System.out.println("#1 DEBUG_ISSUE 34010051  file does not exist or Cannot read or write ");
		            //Logger.log("#1 DEBUG_ISSUE 34010051  file does not exist or Cannot read or write ",Logger.EVENT);
		        }
		        else{
		        	System.out.println("#2 DEBUG_ISSUE 34010051  file does  exist and can read and write");
		        	 //Logger.log("#2 DEBUG_ISSUE 34010051  file does  exist and can read and write",Logger.EVENT);
		        }
			     if(path.contains("\\")) {
			        	String forwardpath = path.replaceAll("\\", "/");
			        	System.out.println("### DEBUG_ISSUE 34010051  forwardpath ="+forwardpath);
			        	
			        	File forwardFile = new File(forwardpath);
			        	 if ((!forwardFile.exists()) || (!forwardFile.isDirectory()) || (!forwardFile.canRead()) || (!forwardFile.canWrite()))
			 	        {
			 	            System.out.println("#3 DEBUG_ISSUE 34010051  tried with forwardSlash Path still not working!");
			 	           //Logger.log("#3 DEBUG_ISSUE 34010051  tried with forwardSlash Path still not working!",Logger.EVENT);
			 	        }
			        	 else {
			        		 System.out.println("#4 DEBUG_ISSUE 34010051  tried with forwardSlash Path, its  working!");
			        		 ////Logger.log("#4 DEBUG_ISSUE 34010051  tried with forwardSlash Path, its  working!",Logger.EVENT);
			        	 }
			        }
			        else if(path.contains("/")) {
			        	String backwordPath = path.replaceAll( "/","\\\\");
			        	
			        	System.out.println("#5 DEBUG_ISSUE 34010051  backslashPath ="+backwordPath);
			        	//Logger.log("#5 DEBUG_ISSUE 34010051  backslashPath",Logger.EVENT);
			        	File backSlashFile = new File(backwordPath);
			        	if ((!backSlashFile.exists()) || (!backSlashFile.isDirectory()) || (!backSlashFile.canRead()) || (!backSlashFile.canWrite()))
			 	        {
			 	            System.out.println("#6 DEBUG_ISSUE 34010051  tried with backSlashFile path still not working!");
			 	           //Logger.log("#6 DEBUG_ISSUE 34010051  tried with backSlashFile path still not working!",Logger.EVENT);
			 	        }
			        	else {
			        		System.out.println("#7 DEBUG_ISSUE 34010051  tried with backSlashFile, its working!");
			        		//Logger.log("#7 DEBUG_ISSUE 34010051  tried with backSlashFile, its working!",Logger.EVENT);
			        	}
			        }
			       System.out.println("#8 DEBUG_ISSUE 34010051  Hardcode testing!");
	        	//Logger.log("#8 DEBUG_ISSUE 34010051  Hardcode testing!",Logger.EVENT);
	        	
			//hardcode test
			boolean backslash=false ,forwardslash=false;
			  File test = new File("S:/Multifonds/bip_reports/OAP_newApp21_domain/components/bipublisher/repository/Admin");
		        if ((!test.exists()) || (!test.isDirectory()) || (!test.canRead()) || (!test.canWrite()))
		        {
		            System.out.println("#9 DEBUG_ISSUE 34010051 Cannot read or write the repository: ");
		            //Logger.log("#9 DEBUG_ISSUE 34010051 Cannot read or write the repository: ="+test.getAbsolutePath(),Logger.EVENT);
		        }else{
		        	forwardslash = true;
		        	System.out.println("#10 DEBUG_ISSUE 34010051  file exist ="+test.getAbsolutePath()); 
		        	//Logger.log("#10 DEBUG_ISSUE 34010051  file exist ="+test.getAbsolutePath(),Logger.EVENT); 
		            BufferedReader br = new BufferedReader(new FileReader("S:/Multifonds/bip_reports/OAP_newApp21_domain/components/bipublisher/repository/Admin/Configuration/xmlp-server-config.xml"));
		            try {
		                StringBuilder sb = new StringBuilder();
		                String line = br.readLine();

		                while (line != null) {
		                    sb.append(line);
		                    sb.append(System.lineSeparator());
		                    line = br.readLine();
		                }
		                String everything = sb.toString();
		                System.out.println("+everything ="+everything);
		                //Logger.log("+everything ="+everything,Logger.EVENT);
		            } finally {
		                br.close();
		            }

		        }
		       
		        File test2 =  new File("S:\\Multifonds\\bip_reports\\OAP_newApp21_domain\\bidata\\components\\bipublisher\\repository\\Admin");
		        if ((!test2.exists()) || (!test2.isDirectory()) || (!test2.canRead()) || (!test2.canWrite()))
		        {
		            System.out.println("#11 Debug test Cannot read or write the repository ####: ");
		            //Logger.log("#11 DEBUG_ISSUE 34010051  can not read or write test2="+test2,Logger.EVENT);
		        }else{
		        	backslash = true;
		        	System.out.println("#12 DEBUG_ISSUE 34010051  file exist ="+test2.getAbsolutePath()); 
		        	//Logger.log("#12 DEBUG_ISSUE 34010051  file exist ="+test2.getAbsolutePath(),Logger.EVENT);
		        	BufferedReader br = new BufferedReader(new FileReader("S:\\Multifonds\\bip_reports\\OAP_newApp21_domain\\components\\bipublisher\\repository\\Admin\\Configuration\\xmlp-server-config.xml"));
		            try {
		                StringBuilder sb = new StringBuilder();
		                String line = br.readLine();

		                while (line != null) {
		                    sb.append(line);
		                    sb.append(System.lineSeparator());
		                    line = br.readLine();
		                }
		                String everything = sb.toString();
		                System.out.println("everything with \\ = "+everything);
		                //Logger.log("+everything  with \\ ="+everything,Logger.EVENT);
		            } finally {
		                br.close();
		            }

		        }
		        //Logger.log("#13 DEBUG_ISSUE 34010051 backslash = "+backslash+"\t forwardslash="+forwardslash,Logger.EVENT);
		        System.out.println("#13 DEBUG_ISSUE 34010051 backslash = "+backslash+"\t forwardslash="+forwardslash);
		
	          
	  }
	public static void main(String[] args) {
		String s  = "/Users/viveksharma/Documents/oracle/bugs";
		try {
			getAdmiRepo(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("After getAdmiRepo");
		String [] words = {"I>N","A>I","P>A","S>P" } ;//SPAIN 
		
//		// AIN
//		HashSet<String> wordsSet = new HashSet<>();
//		for(int i = 0 ; i < words.length ; i++) {
//			words[i] = ""+words[i].charAt(0)+words[i].charAt(2);
//			wordsSet.add(words[i]);
//		}
		
		
		
		
		
		
	}
	
	
   public static void numberOfCarryOperations(int a , int b) {
	   
	   int total = 0;
	   int carry = 0;
	   while(a > 0 && b >0) {
		   int x = a%10;
		   int y = b%10;
		   a = a/10;
		   b= b/10;
		   int sum = x + y + carry;
		   carry = 0;
		   if (sum > 9 ) {
			   total++;
			   carry = sum/10;
		   }
	   
	   }
	   if( a > 0 && carry > 0) {
		   while(a > 0 && carry > 0) {
			   int x = a%10;
			   
			   a = a/10;
			  
			   int sum = x + carry;
			   carry = 0;
			   if (sum > 9 ) {
				   total++;
				   carry = sum/10;
			   }
		   
		   }  
	   }
	   else if( b > 0 && carry > 0) {
		   while(b > 0 && carry > 0) {
			   int x = b%10;
			   
			   b = b/10;
			  
			   int sum = x + carry;
			   carry = 0;
			   if (sum > 9 ) {
				   total++;
				   carry = sum/10;
			   }
		   
		   }  
	   }
	  System.out.println(total);
	   
   }
}
