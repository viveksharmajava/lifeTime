package parsers.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.SAXException;

public class DOMParser {

	private DocumentBuilderFactory dbFactory ;
	private DocumentBuilder dBuilder;
	private Document doc ;
	DOMParser(){
		dbFactory = DocumentBuilderFactory.newInstance();
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	
	public Document parse(File fileSoucePath){
		try {
			doc = dBuilder.parse(fileSoucePath);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	public int getNodeChildernCount(Node nNode){
		int count = 0;
		if ( nNode != null  && nNode.getNodeType() == Node.ELEMENT_NODE && nNode.hasChildNodes()) {
		 NodeList childList = 	nNode.getChildNodes();
		 count =  childList == null ? 0 : childList.getLength();
		}
		return count;
	}
	
	public int getNodeAttrCount(Node nNode){
		int count = 0;
		if ( nNode != null  && nNode.getNodeType() == Node.ELEMENT_NODE &&  nNode.hasAttributes()) {
		 NamedNodeMap namedNodeMap = 	nNode.getAttributes();
		 count =  namedNodeMap == null ? 0 : namedNodeMap.getLength();
		}
		return count;
	}
	
	 public static void main(String[] args) {
		  File fXmlFile = new File("staff.xml");
			System.out.println("File name="+fXmlFile.getName());
			
			DOMParser parser  = new DOMParser();
		Document doc = 	parser.parse(fXmlFile);
		doc.getElementsByTagName("company");
			
	}

}
