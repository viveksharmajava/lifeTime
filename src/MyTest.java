import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class MyTest extends DefaultHandler {

	public static void main(String[] args) {
	
		String dataFilePath = "/Users/viveksharma/Documents/oracle/bugs/Bug 34018364/latest/Pike+-+ADP+Wage+Payment+MAR+16.xml";
		//String dataFilePath = args[0];
		String path = convertToFileURL(dataFilePath);
		System.out.println("path is: " +path);
	
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setNamespaceAware(true);
			SAXParser parser = factory.newSAXParser();
			XMLReader xmlReader = parser.getXMLReader();
			//String dataFilePath = args[0];
			xmlReader.setContentHandler(new MyTest());
			long startTime = System.currentTimeMillis();
			System.out.println("Started Parsing: ");
			xmlReader.parse(path);
			System.out.println("End Parsing");
			System.out.println("Total time taken in parsing the document is: " + (System.currentTimeMillis() - startTime)+"ms");
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static String convertToFileURL(String filename) {
	    String path = new File(filename).getAbsolutePath();
	    if (File.separatorChar != '/') {
	      path = path.replace(File.separatorChar, '/');
	    }
	    if (!path.startsWith("/")) {
	      path = "/" + path;
	    }
	    return "file:" + path;
	  }

}
